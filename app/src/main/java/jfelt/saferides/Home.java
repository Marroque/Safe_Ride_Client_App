package jfelt.saferides;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void openRequestRide(View view) {
        Intent intent = new Intent(this, RequestRide.class);
        startActivity(intent);
    }

    public void openRegisterDriver(View view) {
        Intent intent = new Intent(this, RegisterDriver.class);
        startActivity(intent);
    }
}
