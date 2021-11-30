package tw.tcnr02.m0607;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class M0501 extends AppCompatActivity {

    private Spinner s001;
    private EditText e001;
    private Button b001;
    private TextView ans01;
    private String sSex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0501);
        setupViewcomponent();  //自定義方法
    }
    private void setupViewcomponent() {

        Intent intent=this.getIntent();
        String mode_title=intent.getStringExtra("class_title");
        this.setTitle(mode_title);
        s001 = (Spinner)findViewById(R.id.m0501_s001);

        e001 = (EditText)findViewById(R.id.m0501_e001);

        b001=(Button)findViewById(R.id.m0501_b001);
        ans01=(TextView)findViewById(R.id.m0501_f001);


        // 設定 spinner item 選項------------
//        ArrayAdapter<CharSequence> adapSexList = ArrayAdapter.createFromResource(this, R.array.m0501_a001,
//                        android.R.layout.simple_spinner_item);
//        adapSexList.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        s001.setAdapter(adapSexList);

//         ArrayAdapter<CharSequence> adapSexList
//                 = ArrayAdapter.createFromResource(
//                         this,
//                          R.array.m0501_a001,
//                          android.R.layout.simple_spinner_dropdown_item);
                        //第1個參數。代表 M0501此Class
                        //第2個參數。代表 value/m0501.xml
                        //第3個參數。代表 彈跳出視窗 用"系統預設內建的:"


//-------------------------------------------------------------------------------
        ArrayAdapter adapSexList = ArrayAdapter.createFromResource(
                this,
                R.array.m0501_a001,
                R.layout.spinner_item);   //第3個參數。代表 彈跳出視窗 用"自定義的 彈跳視窗"
        s001.setAdapter(adapSexList);

//-------------------------------------------------------------------------------------


        // 準備 Listener a001Lis 需再設定 Listener
        s001.setOnItemSelectedListener(spnSexItemSelLis);

        // 準備 Listener m0501_b001 需再設定 Listener
        b001.setOnClickListener(b001ON);

    }



    //m0501_s001 Listener 執行
    private AdapterView.OnItemSelectedListener spnSexItemSelLis=new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        sSex=parent.getSelectedItem().toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {


    }
};


//m0501_b001 Listener 執行
    private View.OnClickListener b001ON=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String strSug = getString(R.string.m0501_f000);
//---------------------------------------------------------------------------------------
            //檢查年齡是否有輸入
            if(e001.getText().toString().trim().length()!=0){

                int age=Integer.parseInt(e001.getText().toString());
                //男生
                if(sSex.equals(getString(R.string.chk01)) ){

                    if(age<28){
                        strSug+=getString(R.string.m0501_f001);

                    }else if(age>33){
                        strSug+=getString(R.string.m0501_f003);
                    }else{
                        strSug+=getString(R.string.m0501_f002);
                    }

                }else if (age<25){     //女生
                    strSug+=getString(R.string.m0501_f001);

                }else if (age>30){
                    strSug+=getString(R.string.m0501_f003);
                }else{
                    strSug+=getString(R.string.m0501_f002);
                }




            }else {
//                strSug="請輸入年齡";
                 strSug=getString(R.string.nospace);//當使用者未輸入時，要顯示的字(定義在 nospace)
            }

//------------------------------------------------------------------------------------------
            ans01.setText(strSug);

        }
    };

}