package tw.tcnr02.m0608b;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class M0608b extends AppCompatActivity {

//    private CheckBox chb01;
//    private CheckBox chb02;
//    private CheckBox chb03;
//    private CheckBox chb04;
//    private CheckBox chb05;
//    private CheckBox chb06;
//    private CheckBox chb07;
//    private CheckBox chb08;
//    private CheckBox chb09;
//    private CheckBox chb10;
//    private CheckBox chb11;
//    private CheckBox chb12;
//    private CheckBox chb13;
//    private CheckBox chb14;
//    private CheckBox chb15;
//    private CheckBox chb16;
//    private CheckBox chb17;
//    private CheckBox chb18;
//    private CheckBox chb19;
//    private CheckBox chb20;


    private Button b001;
    private TextView t001;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0608b);
        setupViewcomponent();  //自定義方法
    }

    private void setupViewcomponent() {
        for(int i=1;i<21;i++){
            String idName="m0608b_chb"+String.format("%02d",i);
            int resID=getResources().getIdentifier(idName,"id",getPackageName());
            CheckBox chb=(CheckBox)findViewById(resID);
            // chb.setOnClickListener(btn01OnClick);

        }

//        chb01=(CheckBox)findViewById(R.id.m0608b_chb01);
//         chb02=(CheckBox)findViewById(R.id.m0608b_chb02);
//         chb03=(CheckBox)findViewById(R.id.m0608b_chb03);
//         chb04=(CheckBox)findViewById(R.id.m0608b_chb04);
//
//        chb05=(CheckBox)findViewById(R.id.m0608b_chb05);
//        chb06=(CheckBox)findViewById(R.id.m0608b_chb06);
//        chb07=(CheckBox)findViewById(R.id.m0608b_chb07);
//        chb08=(CheckBox)findViewById(R.id.m0608b_chb08);
//        chb09=(CheckBox)findViewById(R.id.m0608b_chb09);
//        chb10=(CheckBox)findViewById(R.id.m0608b_chb10);
//        chb11=(CheckBox)findViewById(R.id.m0608b_chb11);
//        chb12=(CheckBox)findViewById(R.id.m0608b_chb12);
//
//        chb13=(CheckBox)findViewById(R.id.m0608b_chb13);
//        chb14=(CheckBox)findViewById(R.id.m0608b_chb14);
//        chb15=(CheckBox)findViewById(R.id.m0608b_chb15);
//        chb16=(CheckBox)findViewById(R.id.m0608b_chb16);
//
//        chb17=(CheckBox)findViewById(R.id.m0608b_chb17);
//        chb18=(CheckBox)findViewById(R.id.m0608b_chb18);
//        chb19=(CheckBox)findViewById(R.id.m0608b_chb19);
//        chb20=(CheckBox)findViewById(R.id.m0608b_chb20);
//
        b001=(Button)findViewById(R.id.m0608b_b001);

        t001=(TextView)findViewById(R.id.m0608b_t001);
//
//
//
////        //設監聽
//
        b001.setOnClickListener(btn01OnClick);

    }
    private View.OnClickListener btn01OnClick=new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            String ans01 = getString(R.string.m0608b_t001);

            for(int i=1;i<21;i++){
                String idName="m0608b_chb"+String.format("%02d",i);
                int resID=getResources().getIdentifier(idName,"id",getPackageName());
                CheckBox chb=(CheckBox)findViewById(resID);
                //chb.setOnClickListener(btn01OnClick);
                if(chb.isChecked())  ans01+=chb.getText().toString()+" ";
            }


//            if(chb01.isChecked())  ans01+=chb01.getText().toString()+" ";
//            if(chb02.isChecked())  ans01+=chb02.getText().toString()+" ";
//            if(chb03.isChecked())  ans01+=chb03.getText().toString()+" ";
//            if(chb04.isChecked())  ans01+=chb04.getText().toString()+" ";
//            if(chb05.isChecked())  ans01+=chb05.getText().toString()+" ";
//            if(chb06.isChecked())  ans01+=chb06.getText().toString()+" ";
//            if(chb07.isChecked())  ans01+=chb07.getText().toString()+" ";
//            if(chb08.isChecked())  ans01+=chb08.getText().toString()+" ";
//            if(chb09.isChecked())  ans01+=chb09.getText().toString()+" ";
//            if(chb10.isChecked())  ans01+=chb10.getText().toString()+" ";
//            if(chb11.isChecked())  ans01+=chb11.getText().toString()+" ";
//            if(chb12.isChecked())  ans01+=chb12.getText().toString()+" ";
//            if(chb13.isChecked())  ans01+=chb13.getText().toString()+" ";
//            if(chb14.isChecked())  ans01+=chb14.getText().toString()+" ";
//            if(chb15.isChecked())  ans01+=chb15.getText().toString()+" ";
//            if(chb16.isChecked())  ans01+=chb16.getText().toString()+" ";
//            if(chb17.isChecked())  ans01+=chb17.getText().toString()+" ";
//            if(chb18.isChecked())  ans01+=chb18.getText().toString()+" ";
//            if(chb19.isChecked())  ans01+=chb19.getText().toString()+" ";
//            if(chb20.isChecked())  ans01+=chb20.getText().toString()+" ";


            t001.setText(ans01);


        }
    };

}