package jfelt.saferides;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class RequestRide extends AppCompatActivity {
    RequestRideConfirm.Client answers = new RequestRideConfirm.Client();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_ride);
    }

    public void selectItem(View view){
        boolean checked = ( (CheckBox) view ).isChecked();
        switch ( view.getId() ){

            case R.id.request_quest_answer_yes_1:
                if(checked){
                    answers.isStudent = true;
                    CheckBox ansNo1 = (CheckBox) findViewById(R.id.request_quest_answer_no_1);
                    ansNo1.setChecked(false);
                }
                break;
            case R.id.request_quest_answer_no_1:
                if(checked){
                    answers.isStudent = false;
                    CheckBox ansYes1 = (CheckBox) findViewById(R.id.request_quest_answer_yes_1);
                    ansYes1.setChecked(false);
                }
                break;
            case R.id.request_quest_answer_yes_2:
                if(checked){
                    answers.pickWithin10 = true;
                    CheckBox ansNo2 = (CheckBox) findViewById(R.id.request_quest_answer_no_2);
                    ansNo2.setChecked(false);
                }
                break;
            case R.id.request_quest_answer_no_2:
                if(checked){
                    answers.pickWithin10 = false;
                    CheckBox ansYes2 = (CheckBox) findViewById(R.id.request_quest_answer_yes_2);
                    ansYes2.setChecked(false);
                }
                break;
            case R.id.request_quest_answer_yes_3:
                if(checked){
                    answers.dropWithin10 = true;
                    CheckBox ansNo3 = (CheckBox) findViewById(R.id.request_quest_answer_no_3);
                    ansNo3.setChecked(false);
                }
                break;
            case R.id.request_quest_answer_no_3:
                if(checked){
                    answers.dropWithin10 = false;
                    CheckBox ansYes3 = (CheckBox) findViewById(R.id.request_quest_answer_yes_3);
                    ansYes3.setChecked(false);
                }
                break;
            case R.id.request_quest_answer_4_1:
                if(checked){
                    answers.groupSize = 1;
                    CheckBox ans42 = (CheckBox) findViewById(R.id.request_quest_answer_4_2);
                    ans42.setChecked(false);
                    CheckBox ans43 = (CheckBox) findViewById(R.id.request_quest_answer_4_3);
                    ans43.setChecked(false);
                }
                break;
            case R.id.request_quest_answer_4_2:
                if(checked){
                    answers.groupSize = 2;
                    CheckBox ans41 = (CheckBox) findViewById(R.id.request_quest_answer_4_1);
                    ans41.setChecked(false);
                    CheckBox ans43 = (CheckBox) findViewById(R.id.request_quest_answer_4_3);
                    ans43.setChecked(false);
                }
                break;
            case R.id.request_quest_answer_4_3:
                if(checked){
                    answers.groupSize = 3;
                    CheckBox ans41 = (CheckBox) findViewById(R.id.request_quest_answer_4_1);
                    ans41.setChecked(false);
                    CheckBox ans42 = (CheckBox) findViewById(R.id.request_quest_answer_4_2);
                    ans42.setChecked(false);
                }
                break;

        }
    }

    public void openRequestRideInfo( View view ){
        Intent intent = new Intent(this, RequestRideInfo.class);


        startActivity(intent);
    }
}
