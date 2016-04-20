package jfelt.saferides;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RequestRideInfo extends AppCompatActivity {
    public final static String EXTRA_NAME = "jfelt.saferides.NAME";
    public final static String EXTRA_PICKADD = "jfelt.saferides.PICKADD";
    public final static String EXTRA_DROPADD = "jfelt.saferides.DROPADD";
    public final static String EXTRA_COMMENT = "jfelt.saferides.COMMENT";
    public final static String EXTRA_ISSTUDENT = "jfelt.saferides.ISSTUDENT";
    public final static String EXTRA_PICKWITHIN = "jfelt.saferides.PICKWITHIN";
    public final static String EXTRA_DROPWITHIN = "jfelt.saferides.DROPWITHIN";
    public final static String EXTRA_GROUPSIZE = "jfelt.saferides.GROUPSIZE";

    RequestRideConfirm.Client client = new RequestRideConfirm.Client();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_ride_info);

        Intent intent = getIntent();
        //client.isStudent = intent.getBooleanExtra(RequestRide.EXTRA_ISSTUDENT, false);
        //lient.pickWithin10 = intent.getBooleanExtra(RequestRide.EXTRA_PICKWITHIN, false);
        //client.dropWithin10 = intent.getBooleanExtra(RequestRide.EXTRA_DROPWITHIN, false);
        //client.groupSize = intent.getIntExtra(RequestRide.EXTRA_ISSTUDENT, 1);

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
}
