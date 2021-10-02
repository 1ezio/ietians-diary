package com.iet.ietians_diary;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SelectDetails extends AppCompatActivity implements View.OnClickListener {

    FirebaseDatabase database ;



    Button btnNext;
    private Button[] btnb = new Button[6];

    private Button[] btns = new Button[8];

    private int selected_btnb_id, selected_btns_id;



    private String selected_btnb, selected_btns;

    private Button btn_unfocusb;
    private Button btn_unfocuss;
    private int[] btnb_id = {
            R.id.btnSelectBranchCS,
            R.id.btnSelectBranchCivil,
            R.id.btnSelectBranchEI,
            R.id.btnSelectBranchETC,
            R.id.btnSelectBranchIT,
            R.id.btnSelectBranchMechanical};

    private int[] btns_id = {
            R.id.btnSelectSemester1st,
            R.id.btnSelectSemester2nd,
            R.id.btnSelectSemester3rd,
            R.id.btnSelectSemester4th,
            R.id.btnSelectSemester5th,
            R.id.btnSelectSemester6th,
            R.id.btnSelectSemester7th,
            R.id.btnSelectSemester8th

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_details);

        btnNext = findViewById(R.id.btnNextFromSelectBranch);
        //btnNext.setEnabled(false);

        database= FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("Syllabi");



        for(int i = 0; i < btnb.length; i++){
            btnb[i] = (Button) findViewById(btnb_id[i]);
            //btn[i].setBackgroundColor(Color.rgb(207, 207, 207));
            //btn[i].setBackground(getResources().getDrawable(R.drawable.dw_select_details_bg));
            btnb[i].setOnClickListener(this);
        }

        for(int i = 0; i < btns.length; i++){
            btns[i] = (Button) findViewById(btns_id[i]);
            //btn[i].setBackgroundColor(Color.rgb(207, 207, 207));
            //btn[i].setBackground(getResources().getDrawable(R.drawable.dw_select_details_bg));
            btns[i].setOnClickListener(this);
        }

        btn_unfocusb = btnb[0];
        btn_unfocuss = btns[0];


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),   selected_btnb + " \t " + selected_btns, Toast.LENGTH_LONG).show();



            }
        });




    }

    @Override
    public void onClick(View v) {
        Button tmpbtn = (Button) v;
        switch (v.getId()){
            case R.id.btnSelectBranchCS :
                setFocusb(btn_unfocusb, btnb[0]);
                selected_btnb_id = v.getId();

                selected_btnb = tmpbtn.getText().toString();
                break;

            case R.id.btnSelectBranchCivil :
                setFocusb(btn_unfocusb, btnb[1]);
                selected_btnb_id = v.getId();

                selected_btnb = tmpbtn.getText().toString();
                break;

            case R.id.btnSelectBranchEI :
                setFocusb(btn_unfocusb, btnb[2]);
                selected_btnb_id = v.getId();

                selected_btnb = tmpbtn.getText().toString();
                break;

            case R.id.btnSelectBranchETC :
                setFocusb(btn_unfocusb, btnb[3]);
                selected_btnb_id = v.getId();

                selected_btnb = tmpbtn.getText().toString();
                break;
            case R.id.btnSelectBranchIT :
                setFocusb(btn_unfocusb, btnb[4]);
                selected_btnb_id = v.getId();

                selected_btnb = tmpbtn.getText().toString();
                break;
            case R.id.btnSelectBranchMechanical :
                setFocusb(btn_unfocusb, btnb[5]);
                selected_btnb_id = v.getId();

                selected_btnb = tmpbtn.getText().toString();
                break;
        }

        switch (v.getId()){
            case R.id.btnSelectSemester1st:
                setFocuss(btn_unfocuss, btns[0]);
                selected_btns_id = v.getId();

                selected_btns = tmpbtn.getText().toString();
                break;

            case R.id.btnSelectSemester2nd:
                setFocuss(btn_unfocuss, btns[1]);
                selected_btns_id = v.getId();
                selected_btns = tmpbtn.getText().toString();
                break;

            case R.id.btnSelectSemester3rd:
                setFocuss(btn_unfocuss, btns[2]);
                selected_btns_id = v.getId();
                selected_btns = tmpbtn.getText().toString();
                break;

            case R.id.btnSelectSemester4th:
                setFocuss(btn_unfocuss, btns[3]);
                selected_btns_id = v.getId();
                selected_btns = tmpbtn.getText().toString();
                break;
            case R.id.btnSelectSemester5th:
                setFocuss(btn_unfocuss, btns[4]);
                selected_btns_id = v.getId();
                selected_btns = tmpbtn.getText().toString();
                break;
            case R.id.btnSelectSemester6th:
                setFocuss(btn_unfocuss, btns[5]);
                selected_btns_id = v.getId();
                selected_btns = tmpbtn.getText().toString();
                break;
            case R.id.btnSelectSemester7th:
                setFocuss(btn_unfocuss, btns[6]);
                selected_btns_id = v.getId();
                selected_btns = tmpbtn.getText().toString();
                break;
            case R.id.btnSelectSemester8th:
                setFocuss(btn_unfocuss, btns[7]);
                selected_btns_id = v.getId();
                selected_btns = tmpbtn.getText().toString();
                break;

        }

    }

    private void setFocusb(Button btn_unfocus, Button btn_focus){
        btn_unfocus.setTextColor(getResources().getColor(R.color.text_black_200));
        //btn_unfocus.setBackgroundColor(Color.rgb(207, 207, 207));
        btn_unfocus.setBackground(getResources().getDrawable(R.drawable.dw_select_details_bg));


        btn_focus.setTextColor(getResources().getColor(R.color.peach_red_400));
        //btn_focus.setBackgroundColor(Color.rgb(3, 106, 150));
        btn_focus.setBackground(getResources().getDrawable(R.drawable.dw_select_details_bg_pink));
        this.btn_unfocusb = btn_focus;
    }

    private void setFocuss(Button btn_unfocus, Button btn_focus){
        btn_unfocus.setTextColor(getResources().getColor(R.color.text_black_200));
        //btn_unfocus.setBackgroundColor(Color.rgb(207, 207, 207));
        btn_unfocus.setBackground(getResources().getDrawable(R.drawable.dw_select_details_bg));



        btn_focus.setTextColor(getResources().getColor(R.color.peach_red_400));
        //btn_focus.setBackgroundColor(Color.rgb(3, 106, 150));
        btn_focus.setBackground(getResources().getDrawable(R.drawable.dw_select_details_bg_pink));
        this.btn_unfocuss = btn_focus;



    }
}