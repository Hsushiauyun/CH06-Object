package tw.tcnr02.m0608;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
//---------------------------------------
public class M0608 extends AppCompatActivity {
    private Button btn0,btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6,btn7,btn8,btn9,btn10,btn11;
    private Button btn12,btn13,btn14,btn15;
    private TextView num1;
    private TextView ans;
    private String keyin;
    private double nn;
    private String s;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0608);
        setupViewCompoent();

    }

    private void setupViewCompoent() {
        num1 = (TextView) findViewById(R.id.m0608_e001);
        num1.setText("");
        ans = (TextView) findViewById(R.id.m0608_t001);
//--------------------------------------------------------
        btn0 = (Button) findViewById(R.id.m0608_b000);
        btn1= (Button) findViewById(R.id.m0608_b001);
        btn2 = (Button) findViewById(R.id.m0608_b002);
        btn3 = (Button) findViewById(R.id.m0608_b003);
        btn4 = (Button) findViewById(R.id.m0608_b004);
        btn5 = (Button) findViewById(R.id.m0608_b005);
        btn6 = (Button) findViewById(R.id.m0608_b006);
        btn7 = (Button) findViewById(R.id.m0608_b007);
        btn8 = (Button) findViewById(R.id.m0608_b008);
        btn9 = (Button) findViewById(R.id.m0608_b009);
        btn10 = (Button) findViewById(R.id.m0608_b010); //.

        btn11 = (Button) findViewById(R.id.m0608_b011);// +
        btn12 = (Button) findViewById(R.id.m0608_b012);// -
        btn13 = (Button) findViewById(R.id.m0608_b013);// *
        btn14 = (Button) findViewById(R.id.m0608_b014);// /
        btn15 = (Button) findViewById(R.id.m0608_b015); // =

        btn0.setOnClickListener(numberOnClick);
        btn1.setOnClickListener(numberOnClick);
        btn2.setOnClickListener(numberOnClick);
        btn3.setOnClickListener(numberOnClick);
        btn4.setOnClickListener(numberOnClick);
        btn5.setOnClickListener(numberOnClick);
        btn6.setOnClickListener(numberOnClick);
        btn7.setOnClickListener(numberOnClick);
        btn8.setOnClickListener(numberOnClick);
        btn9.setOnClickListener(numberOnClick);
        btn10.setOnClickListener(numberOnClick);

        btn11.setOnClickListener(calOnClick);
        btn12.setOnClickListener(calOnClick);
        btn13.setOnClickListener(calOnClick);
        btn14.setOnClickListener(calOnClick);

        btn15.setOnClickListener(equalOnClick);
    }


    private Button.OnClickListener numberOnClick = new Button.OnClickListener() {


        @Override
        public void onClick(View v) {
            keyin=num1.getText().toString();
            switch (v.getId()) {
                case R.id.m0608_b000:
                    num1.setText(keyin+"0");
                    break;
                case R.id.m0608_b001:
                    num1.setText(keyin+"1");
                    break;
                case R.id.m0608_b002:
                    num1.setText(keyin+"2");
                    break;
                case R.id.m0608_b003:
                    num1.setText(keyin+"3");
                    break;
                case R.id.m0608_b004:
                    num1.setText(keyin+"4");
                    break;
                case R.id.m0608_b005:
                    num1.setText(keyin+"5");
                    break;
                case R.id.m0608_b006:
                    num1.setText(keyin+"6");
                    break;
                case R.id.m0608_b007:
                    num1.setText(keyin+"7");
                    break;
                case R.id.m0608_b008:
                    num1.setText(keyin+"8");
                    break;
                case R.id.m0608_b009:
                    num1.setText(keyin+"9");
                    break;

            }

        }
    };

    private View.OnClickListener calOnClick=new View.OnClickListener(){




        @Override
        public void onClick(View v) {
            try { nn=Double.parseDouble(num1.getText().toString()); //把字串丟入nn
            }catch(Exception e){
                Toast.makeText(getApplicationContext(),getString(R.string.error),Toast.LENGTH_LONG).show();
            }
            num1.setText(""); //答案框設空白

            switch (v.getId()){
                case R.id.m0608_b011: //+
                    s="P";
                    break;
                case R.id.m0608_b012: //-
                    s="M";
                    break;
                case R.id.m0608_b013: //*
                    s="X";
                    break;
                case R.id.m0608_b014: // /
                    s="D";
                    break;

            }
        }
    };

    private View.OnClickListener equalOnClick=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        if (num1.getText().toString().trim().length()!=0) {
            double n2=Double.parseDouble(num1.getText().toString());
            DecimalFormat nf=new DecimalFormat("0.0000"); //格式化
            if(s.equals("P"))ans.setText(nf.format(nn+n2));
            if(s.equals("M"))ans.setText(nf.format(nn-n2));
            if(s.equals("X"))ans.setText(nf.format(nn*n2));
            if(s.equals("D"))ans.setText(nf.format(nn/n2));
            num1.setText("");
            nn=0;

        }else {
            Toast.makeText(getApplicationContext(),getString(R.string.error),Toast.LENGTH_LONG).show();
        }
        }
    };
}
//----------------------------------------
