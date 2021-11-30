package tw.tcnr02.m0607;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class M0502 extends AppCompatActivity {



    private Button b001;
    private TextView ans01;
    private String sSex;
    private RadioGroup rb01;
    private RadioGroup rb02;
    private RadioButton rb021;
    private RadioButton rb022;
    private RadioButton rb023;

    private String strSug;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0502);
        setupViewcomponent();  //自定義方法
    }
    private void setupViewcomponent() {


        Intent intent=this.getIntent();
        String mode_title=intent.getStringExtra("class_title");
        this.setTitle(mode_title);

        b001=(Button)findViewById(R.id.m0502_b001);
        ans01=(TextView)findViewById(R.id.m0502_f000);
        rb01 = (RadioGroup) findViewById(R.id.m0502_r001); //性別
        rb02 = (RadioGroup) findViewById(R.id.m0502_r002); //年齡
        rb021 = (RadioButton) findViewById(R.id.m0502_r002a);//小於28歲
        rb022 = (RadioButton) findViewById(R.id.m0502_r002b);//28-33歲
        rb023 = (RadioButton) findViewById(R.id.m0502_r002c);//大於33歲


        //設監聽
        rb01.setOnCheckedChangeListener(radGSexOnCheChanLis);

        b001.setOnClickListener(btnDoSugOnClick);


    }

    private RadioGroup.OnCheckedChangeListener radGSexOnCheChanLis = new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId){
                case R.id.m0502_r001a: //點"男"
                    rb021.setText(R.string.m0502_r002aa);
                    rb022.setText(R.string.m0502_r002ab);
                    rb023.setText(R.string.m0502_r002ac);
                    break;
                case  R.id.m0502_r001b: //點"女"
                    rb021.setText(R.string.m0502_r002ba);
                    rb022.setText(R.string.m0502_r002bb);
                    rb023.setText(R.string.m0502_r002bc);
                    break;


            }
        }
    };



    //m0501_b001 Listener 執行
    private View.OnClickListener btnDoSugOnClick=new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            //------------------------------------------
            int iCheckedRadBtn = rb01.getCheckedRadioButtonId();

            strSug = getString(R.string.m0502_f000); //建議您
            switch (iCheckedRadBtn) {
                case R.id.m0502_r001a:
                    switch (rb02.getCheckedRadioButtonId()) {
                        case R.id.m0502_r002a:
                            strSug += getString(R.string.m0502_f001);
                            break;
                        case R.id.m0502_r002b:
                            strSug += getString(R.string.m0502_f002);
                            break;
                        default:
                            strSug += getString(R.string.m0502_f003);
                    }
                    break;
                case R.id.m0502_r001b:
                    switch (rb02.getCheckedRadioButtonId()) {
                        case R.id.m0502_r002a:
                            strSug += getString(R.string.m0502_f004);
                            break;
                        case R.id.m0502_r002b:
                            strSug += getString(R.string.m0502_f005);
                            break;
                        default:
                            strSug += getString(R.string.m0502_f006);
                    }
                    break;
            }

            ans01.setText(strSug); //strSug是變數



        }
    };

}