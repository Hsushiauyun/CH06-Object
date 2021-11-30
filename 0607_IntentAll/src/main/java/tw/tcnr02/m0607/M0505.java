package tw.tcnr02.m0607;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class M0505 extends AppCompatActivity {

    private AutoCompleteTextView e001;
    private Button b001;
    private Button b002;
    private ArrayAdapter<String> adapAutoCompText;
//    String[] str={"test one","test two"};//定義資料內容


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0505);
        setupViewcomponent();  //自定義方法
    }

    private void setupViewcomponent() {

        Intent intent=this.getIntent();
        String mode_title=intent.getStringExtra("class_title");
        this.setTitle(mode_title);
        e001=(AutoCompleteTextView)findViewById(R.id.m0505_e001);
        b001=(Button)findViewById(R.id.m0505_b001);
        b002=(Button)findViewById(R.id.m0505_b002);

//        adapAutoCompText=new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,str);
        adapAutoCompText=new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line);
        e001.setAdapter(adapAutoCompText);//設定 Adapter 給 a001
        e001.setThreshold(2);//設定輸入幾個字後開始比對


        //監聽
        b001.setOnClickListener(btn001_c);
//        b002.setOnClickListener(btn002_c);
    }

    private View.OnClickListener btn001_c=new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.m0505_b001:
                    String s = e001.getText().toString();
                    adapAutoCompText.add(s);
                    e001.setText(""); //把原本的autoEditText清空
                    break;

                case R.id.m0505_b002:
                    adapAutoCompText.clear();
                    e001.setText(""); //把原本的autoEditText清空
                    break;

            }




//
//            String ans=e001.getText().toString();
//            adapAutoCompText.add(ans);
//            e001.setText("");

        }
    };
}

