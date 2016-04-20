package jfelt.saferides;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class RequestRideConfirm extends AppCompatActivity {
    public final static String EXTRA_NAME = "jfelt.saferides.NAME";
    public final static String EXTRA_PICKADD = "jfelt.saferides.PICKADD";
    public final static String EXTRA_DROPADD = "jfelt.saferides.DROPADD";
    public final static String EXTRA_COMMENT = "jfelt.saferides.COMMENT";
    public final static String EXTRA_ISSTUDENT = "jfelt.saferides.ISSTUDENT";
    public final static String EXTRA_PICKWITHIN = "jfelt.saferides.PICKWITHIN";
    public final static String EXTRA_DROPWITHIN = "jfelt.saferides.DROPWITHIN";
    public final static String EXTRA_GROUPSIZE = "jfelt.saferides.GROUPSIZE";

    Client client = new Client();

    public static class Client {
        String name;
        String pickupAddress;
        String dropoffAddress;
        String otherComment;
        boolean isStudent;
        boolean pickWithin10;
        boolean dropWithin10;
        int groupSize;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_ride_confirm);

        Intent intent = getIntent();

        //client.name = intent.getStringExtra(RequestRideInfo.EXTRA_NAME);
        //client.pickupAddress = intent.getStringExtra(RequestRideInfo.EXTRA_PICKWITHIN);
        //client.dropoffAddress = intent.getStringExtra(RequestRideInfo.EXTRA_DROPWITHIN);
        //client.otherComment = intent.getStringExtra(RequestRideInfo.EXTRA_COMMENT);
        //client.isStudent = intent.getBooleanExtra(RequestRideInfo.EXTRA_ISSTUDENT, false);
        //client.pickWithin10 = intent.getBooleanExtra(RequestRideInfo.EXTRA_PICKWITHIN, false);
        //client.dropWithin10 = intent.getBooleanExtra(RequestRideInfo.EXTRA_DROPWITHIN, false);
        //client.groupSize = intent.getIntExtra(RequestRideInfo.EXTRA_ISSTUDENT, 1);

        TextView textName = (TextView) findViewById(R.id.confirm_name);
        if(client.name != null)
            textName.setText(client.name);
        TextView textPickAdd = (TextView) findViewById(R.id.confirm_pick_add);
        if(client.pickupAddress != null)
            textPickAdd.setText(client.pickupAddress);

        TextView textDropAdd = (TextView) findViewById(R.id.confirm_drop_add);
        if(client.dropoffAddress != null)
            textDropAdd.setText(client.dropoffAddress);

        TextView textComments = (TextView) findViewById(R.id.confirm_comments);
        if(client.otherComment != null)
            textComments.setText(client.otherComment);
    }

    public void submitRequest( View view ){
        Intent intent = new Intent(this, RequestRideSubmit.class);

        startActivity(intent);
    }
}
