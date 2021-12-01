package tw.tcnr02.m0608;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class M0608 extends AppCompatActivity {

    private TextView num1;
    private double n1 = 0;
    private String s = "S"; //用來判斷+-*/
    private DecimalFormat nf;
    private TextView show;
    private double nn;
    private double n2 = 0;
    private String se = "";
    private String st = "";
    private Boolean e_ok = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0608);
        setupViewComponent();
    }

    private void setupViewComponent() {
        num1 = (TextView) findViewById(R.id.m0608_e001);
        show = (TextView) findViewById(R.id.m0608_show);

//        clearOnClick.onClick(null);

        nf = new DecimalFormat("0.0000");
        //-----巨集執行----
        for (int i = 0; i < 18; i++) {
            String idName = "m0608_b0" + String.format("%02d", i);
            int resID = getResources().getIdentifier(idName, "id", getPackageName());

            Button btn = ((Button) findViewById(resID));
            if (i < 11) btn.setOnClickListener(numberOnClick);
            if (i > 10 && i < 15) btn.setOnClickListener(calOnClick);
            if (i == 15) btn.setOnClickListener(equalOnClick);
            if (i == 16) btn.setOnClickListener(delOnClick);
            if (i == 17) btn.setOnClickListener(clearOnClick);
        }
        num1.setText("");
        show.setText("");
    }


    private Button.OnClickListener numberOnClick = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            String keyin = num1.getText().toString();
            switch (v.getId()) {
                case R.id.m0608_b000:
                    num1.setText(keyin + "0");
                    break;
                case R.id.m0608_b001:
                    num1.setText(keyin + "1");
                    break;
                case R.id.m0608_b002:
                    num1.setText(keyin + "2");
                    break;
                case R.id.m0608_b003:
                    num1.setText(keyin + "3");
                    break;
                case R.id.m0608_b004:
                    num1.setText(keyin + "4");
                    break;
                case R.id.m0608_b005:
                    num1.setText(keyin + "5");
                    break;
                case R.id.m0608_b006:
                    num1.setText(keyin + "6");
                    break;
                case R.id.m0608_b007:
                    num1.setText(keyin + "7");
                    break;
                case R.id.m0608_b008:
                    num1.setText(keyin + "8");
                    break;
                case R.id.m0608_b009:
                    num1.setText(keyin + "9");
                    break;
                case R.id.m0608_b010:
                    num1.setText(keyin + ".");
                    break;
            }
        }
    };
    ////-----------修正 1-1-1=-1
    private View.OnClickListener calOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {
                if (num1.getText().toString().equals("") && v.getId() == R.id.m0608_b012) {
                    num1.setText("-");
                } else {

                    //-----------進行執行中的運算----------//
                    nn = Double.parseDouble(num1.getText().toString());
                    int a = 0;
//                u_Calculation(nn);
                    if (s.equals("S")) n1 = nn;
                    u_Calculation(nn);
                    num1.setText("");
                    switch (v.getId()) {
                        case R.id.m0608_b011:
                            s = "P";
                            show.setText(getString(R.string.m0608_b011));
                            break;
                        case R.id.m0608_b012:
                            s = "M";
                            show.setText(getString(R.string.m0608_b012));
                            break;
                        case R.id.m0608_b013:
                            s = "X";
                            show.setText(getString(R.string.m0608_b013));
                            break;
                        case R.id.m0608_b014:
                            s = "D";
                            show.setText(getString(R.string.m0608_b014));
                            break;
                    }
                }
            } catch (Exception e) {
            }
        }
    };
    //------------------------------------------------------

    private void u_Calculation(double in_nn) {
        if (s.equals("P")) n1 += in_nn; //上一個運算符號
        if (s.equals("M")) n1 -= in_nn;
        if (s.equals("X")) n1 *= in_nn;
        if (s.equals("D")) n1 /= in_nn;
    }

    private View.OnClickListener equalOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (num1.getText().toString().trim().length() != 0) {
                n2 = Double.parseDouble(num1.getText().toString());
                DecimalFormat nf = new DecimalFormat("0.0000");
                u_Calculation(n2);
                num1.setText(nf.format(n1));
                show.setText(getString(R.string.m0608_b015));
                n1 = 0;
                nn = 0;
            }
        }
    };
    //-----------------------可連續計算-------------------
//private View.OnClickListener equalOnClick = new View.OnClickListener() {
//    @Override
//    public void onClick(View v) {
////            Toast.makeText(getApplicationContext(), Double.toString(n1), Toast.LENGTH_LONG).show();
//        if (num1.getText().toString().trim().length() != 0) {
//            if (!se.equals("1")){
//                n2 = Double.parseDouble((num1.getText().toString()));
//
//            } else{
//                s=st;
//
//            }
//
//            nf = new DecimalFormat("0.0000");
//            u_Calculation(n2);
//            num1.setText(nf.format(n1));
////                if (s.equals("")) num1.setText(nf.format(n2));
////                num1.setText("");
//            //n1 = 0;
//            se = "1";
//            st=s;
//            s="E";
//            show.setText(getString(R.string.m0608_b015));
////                num1.setText(ans.getText());
////                num1.setText("");
////                n1 = 0;
//        }
//    }
//};
    //----------------------------------------

    private View.OnClickListener delOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            num1.setText("");
        }
    };
    private Button.OnClickListener clearOnClick = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            n1 = 0;
            num1.setText("");
            show.setText("");
            if (!s.equals("E")) {  //按= 狀態 不清除結果欄
                num1.setText("");
                show.setText("");
            }
            s = "S";  //設成起始狀態
        }
    };
    //------------------end---------------
}
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import java.text.DecimalFormat;
////---------------------------------------
//public class M0608 extends AppCompatActivity {
////    private Button btn0,btn1;
////    private Button btn2;
////    private Button btn3;
////    private Button btn4;
////    private Button btn5;
////    private Button btn6,btn7,btn8,btn9,btn10,btn11;
////    private Button btn12,btn13,btn14,btn15;
//    private TextView num1;
//    private TextView ans;
//    private String keyin;
//    private double nn;
//    private String s;
//    private TextView show;
//    private String idname;
//    private Button btn16;
//    private Button btn17;
//    private View.OnClickListener calOnClick;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.m0608);
//        setupViewCompoent();
//
//    }
//
//    private void setupViewCompoent() {
//        num1=(TextView) findViewById(R.id.m0608_e001);
//        show=(TextView)findViewById(R.id.m0608_show);
//        DecimalFormat nf=new DecimalFormat("0.0000");
//
//        for(int i=0;i<18;i++){                           //初始值 範圍 每次做甚麼
//            idname="m0608_b0"+String.format("%02d",i);  //缺位數補0  此稱巨集
//            int resID=getResources().getIdentifier(idname,"id",getPackageName());
//
//            Button btn = ((Button) findViewById(resID));
//            if (i<=11) btn.setOnClickListener(numberOnClick);
//            if (i>10&&i<15)btn.setOnClickListener(calOnClick);
//            if (i==15)btn.setOnClickListener(equalOnClick);
//            if (i==16)btn.setOnClickListener(delOnClick);
//            if (i==17)btn.setOnClickListener(clearOnClick);
//
//        }
//        num1.setText("");
//        show.setText("");
//
//        btn16=(Button)findViewById(R.id.m0608_b016);
//        btn17=(Button)findViewById(R.id.m0608_b017);
//
////
////        btn0.setOnClickListener(numberOnClick);
////        btn1.setOnClickListener(numberOnClick);
////        btn2.setOnClickListener(numberOnClick);
////        btn3.setOnClickListener(numberOnClick);
////        btn4.setOnClickListener(numberOnClick);
////        btn5.setOnClickListener(numberOnClick);
////        btn6.setOnClickListener(numberOnClick);
////        btn7.setOnClickListener(numberOnClick);
////        btn8.setOnClickListener(numberOnClick);
////        btn9.setOnClickListener(numberOnClick);
////        btn10.setOnClickListener(numberOnClick);
////
////        btn11.setOnClickListener(calOnClick);
////        btn12.setOnClickListener(calOnClick);
////        btn13.setOnClickListener(calOnClick);
////        btn14.setOnClickListener(calOnClick);
////
////        btn15.setOnClickListener(equalOnClick);
//
//    }
//private View.OnClickListener delOnClick=new View.OnClickListener(){
//
//    @Override
//    public void onClick(View v) {
//
//    }
//};
//   private View.OnClickListener claerOnclick=new View.OnClickListener(){
//
//       @Override
//       public void onClick(View v) {
//
//       }
//   };
//
//    private Button.OnClickListener numberOnClick = new Button.OnClickListener() {
//
//
//        @Override
//        public void onClick(View v) {
//            keyin=num1.getText().toString();
//            switch (v.getId()) {
//                case R.id.m0608_b000:
//                    num1.setText(keyin+"0");
//                    break;
//                case R.id.m0608_b001:
//                    num1.setText(keyin+"1");
//                    break;
//                case R.id.m0608_b002:
//                    num1.setText(keyin+"2");
//                    break;
//                case R.id.m0608_b003:
//                    num1.setText(keyin+"3");
//                    break;
//                case R.id.m0608_b004:
//                    num1.setText(keyin+"4");
//                    break;
//                case R.id.m0608_b005:
//                    num1.setText(keyin+"5");
//                    break;
//                case R.id.m0608_b006:
//                    num1.setText(keyin+"6");
//                    break;
//                case R.id.m0608_b007:
//                    num1.setText(keyin+"7");
//                    break;
//                case R.id.m0608_b008:
//                    num1.setText(keyin+"8");
//                    break;
//                case R.id.m0608_b009:
//                    num1.setText(keyin+"9");
//                    break;
//                case R.id.m0608_b010:
//                    num1.setText(keyin+".");
//                    break;
//
//            }
//
//        }
//    };
//
////    private View.OnClickListener calOnClick=new View.OnClickListener(){
////
////        @Override
////        public void onClick(View v) {
//            try {}
//            if(){
//
//            }else{
//
//            }
//            { nn=Double.parseDouble(num1.getText().toString()); //把字串丟入nn
//            }catch(Exception e){
//                Toast.makeText(getApplicationContext(),getString(R.string.error),Toast.LENGTH_LONG).show();
//        if (num1.getText().toString().equals("") && v.getId() == R.id.m0608_b012) {
//            num1.setText("-");
//        } else {
//
//            //-----------進行執行中的運算----------//
//            nn = Double.parseDouble(num1.getText().toString());
//            int a = 0;
////                u_Calculation(nn);
//            if (s.equals("S")) n1 = nn;
//            u_Calculation(nn);
//            num1.setText("");
//            switch (v.getId()) {
//                case R.id.m0608_b011:
//                    s = "P";
//                    show.setText(getString(R.string.m0608_b011));
//                    break;
//                case R.id.m0608_b012:
//                    s = "M";
//                    show.setText(getString(R.string.m0608_b012));
//                    break;
//                case R.id.m0608_b013:
//                    s = "X";
//                    show.setText(getString(R.string.m0608_b013));
//                    break;
//                case R.id.m0608_b014:
//                    s = "D";
//                    show.setText(getString(R.string.m0608_b014));
//                    break;
//            }
//        }
//            }
//
//    private void u_Calculation(double in_nn) {
//        if (s.equals("P")) n1 += in_nn; //上一個運算符號
//        if (s.equals("M")) n1 -= in_nn;
//        if (s.equals("X")) n1 *= in_nn;
//        if (s.equals("D")) n1 /= in_nn;
//    }
////            num1.setText(""); //答案框設空白
////
////            switch (v.getId()){
////                case R.id.m0608_b011: //+
////                    s="P";
////                    break;
////                case R.id.m0608_b012: //-
////                    s="M";
////                    break;
////                case R.id.m0608_b013: //*
////                    s="X";
////                    break;
////                case R.id.m0608_b014: // /
////                    s="D";
////                    break;
////
////            }
////        }
////    };
//
//    private View.OnClickListener equalOnClick=new View.OnClickListener() {
//        private double n2;
//        private int n1;
//
//        @Override
//        public void onClick(View v) {
//            if (num1.getText().toString().trim().length() != 0) {
//                n2 = Double.parseDouble(num1.getText().toString());
////                DecimalFormat nf = new DecimalFormat("0.0000");
//                u_Calculation(n2);
//                num1.setText(nf.format(n1));
//                show.setText(getString(R.string.m0608_b015));
//                n1 = 0;
//                nn = 0;
//            }
//
//
////        if (num1.getText().toString().trim().length()!=0) {
////            double n2=Double.parseDouble(num1.getText().toString());
////            DecimalFormat nf=new DecimalFormat("0.0000"); //格式化
////            if(s.equals("P"))ans.setText(nf.format(nn+n2));
////            if(s.equals("M"))ans.setText(nf.format(nn-n2));
////            if(s.equals("X"))ans.setText(nf.format(nn*n2));
////            if(s.equals("D"))ans.setText(nf.format(nn/n2));
////            num1.setText("");
////            nn=0;
////
////        }else {
////            Toast.makeText(getApplicationContext(),getString(R.string.error),Toast.LENGTH_LONG).show();
////        }
//        }
//    };
//}
////----------------------------------------
