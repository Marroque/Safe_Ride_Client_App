package jfelt.saferides;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RequestRideInfo extends AppCompatActivity {
    public final static String EXTRA_NAME = "jfelt.saferides.NAME";
    public final static String EXTRA_PICKADD = "jfelt.saferides.PICKADD";
    public final static String EXTRA_DROPADD = "jfelt.saferides.DROPADD";
    public final static String EXTRA_COMMENT = "jfelt.saferides.COMMENT";
    public final static String EXTRA_ISSTUDENT = "jfelt.saferides.ISSTUDENT";
    public final static String EXTRA_PICKWITHIN = "jfelt.saferides.PICKWITHIN";
    public final static String EXTRA_DROPWITHIN = "jfelt.saferides.DROPWITHIN";
    public final static String EXTRA_GROUPSIZE = "jfelt.saferides.GROUPSIZE";
    AppLocationService appLocationService;
    Button btnGetLocation;
    EditText pickup_address;
    RequestRideConfirm.Client client = new RequestRideConfirm.Client();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_ride_info);
        pickup_address = (EditText) findViewById(R.id.pickup_address);
        appLocationService = new AppLocationService(
                RequestRideInfo.this);

        Intent intent = getIntent();
        //client.isStudent = intent.getBooleanExtra(RequestRide.EXTRA_ISSTUDENT, false);
        //lient.pickWithin10 = intent.getBooleanExtra(RequestRide.EXTRA_PICKWITHIN, false);
        //client.dropWithin10 = intent.getBooleanExtra(RequestRide.EXTRA_DROPWITHIN, false);
        //client.groupSize = intent.getIntExtra(RequestRide.EXTRA_ISSTUDENT, 1);
        btnGetLocation = (Button) findViewById(R.id.btnGetLocation);
        btnGetLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                Location location = appLocationService
                        .getLocation(LocationManager.NETWORK_PROVIDER);

                if (location != null) {
                    double latitude = location.getLatitude();
                    double longitude = location.getLongitude();
                    LocationAddress locationAddress = new LocationAddress();
                    locationAddress.getAddressFromLocation(latitude, longitude,
                            getApplicationContext(), new GeocoderHandler());
                } else {
                    showSettingsAlert();
                }

            }
        });

    }

    public void openRequestRideConfirm( View view ){
        //create the intent
        Intent intent = new Intent(this, RequestRideConfirm.class);

        //
        EditText name = (EditText) findViewById(R.id.student_name);
        client.name = name.getText().toString();
        EditText  pickupAdd = (EditText) findViewById(R.id.pickup_address);
        client.pickupAddress = pickupAdd.getText().toString();
        EditText  dropoffAdd = (EditText) findViewById(R.id.dropoff_address);
        client.dropoffAddress = dropoffAdd.getText().toString();
        EditText  otherComment = (EditText) findViewById(R.id.other_comments);
        client.otherComment = otherComment.getText().toString();


        //place inside the intent
        intent.putExtra(EXTRA_NAME, client.name);
        intent.putExtra(EXTRA_PICKADD, client.pickupAddress);
        intent.putExtra(EXTRA_DROPADD, client.dropoffAddress);
        intent.putExtra(EXTRA_COMMENT, client.otherComment);
        intent.putExtra(EXTRA_ISSTUDENT, client.isStudent);
        intent.putExtra(EXTRA_PICKWITHIN, client.pickWithin10);
        intent.putExtra(EXTRA_DROPWITHIN, client.dropWithin10);
        intent.putExtra(EXTRA_GROUPSIZE, client.groupSize);

        startActivity(intent);
    }

    public void showSettingsAlert() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(
                RequestRideInfo.this);
        alertDialog.setTitle("SETTINGS");
        alertDialog.setMessage("GPS is disabled! Please enable it in your settings to use this feature.");
        alertDialog.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        alertDialog.setPositiveButton("Settings",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(
                                Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        RequestRideInfo.this.startActivity(intent);
                    }
                });
        alertDialog.show();
    }

    private class GeocoderHandler extends Handler {
        @Override
        public void handleMessage(Message message) {
            String locationAddress;
            switch (message.what) {
                case 1:
                    Bundle bundle = message.getData();
                    locationAddress = bundle.getString("address");
                    break;
                default:
                    locationAddress = null;
            }
            pickup_address.setText(locationAddress);
        }
    }
}
