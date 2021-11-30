package tw.tcnr02.m0604;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class M0604 extends AppCompatActivity {

    private Button b001;
    private Button b002;
    private Button b003;
    private Button b004;
    private Toast toast;
    private LinearLayout toastView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0604);
        setupViewCompoent();
    }
    private void setupViewCompoent() {
        // ---取得R.java 配置碼---
        b001 = (Button) findViewById(R.id.m0604_b001); // 默認
        b002 = (Button) findViewById(R.id.m0604_b002); // 自定義顯示位置
        b003 = (Button) findViewById(R.id.m0604_b003); // 帶圖片
        b004 = (Button) findViewById(R.id.m0604_b004); // 完全自定義

        b001.setOnClickListener(btoast);
        b002.setOnClickListener(btoast);
        b003.setOnClickListener(btoast);
        b004.setOnClickListener(btoast);
    }


    private View.OnClickListener btoast=new View.OnClickListener(){




        @Override
        public void onClick(View v) {
            toast=null;
            switch(v.getId()){
                case R.id.m0604_b001: //默認Toast
                    Toast.makeText(getApplicationContext(), "請注意", Toast.LENGTH_SHORT).show(); //  第1參數，"第2參數_請注意"，第3參數__選長的
                    break;

                case R.id.m0604_b002: //自定義顯示位置 Toast
//                    toast=Toast.makeText(getApplicationContext(), "請注意", Toast.LENGTH_LONG);
//                    toast.setGravity(Gravity.CENTER,0, 0);//第1參數:置中  ，第2參數: 微調  ，第3參數:微調
                    toast = Toast.makeText(getApplicationContext(), getString(R.string.m0604_b002), Toast.LENGTH_SHORT); //大T:物件 小t:變數
                    toast.setGravity(Gravity.CENTER, -1000, 0);
                    toast.show();
                    break;

                case R.id.m0604_b003: //默認Toast
                    toast = Toast.makeText(getApplicationContext(), getString(R.string.m0604_b003), Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP|Gravity.END,0, 0);
//                    toastView = (LinearLayout) toast.getView();
//                    ImageView imageCodeProject = new ImageView(getApplicationContext());
//                    imageCodeProject.setImageResource(R.drawable.ic_sample);
//                    toastView.addView(imageCodeProject, 0);

                    toastView=(LinearLayout)toast.getView();
                    ImageView imageCodeProject=new ImageView(getApplicationContext());
                    imageCodeProject.setImageResource(R.drawable.ic_sample);
                    toastView.addView(imageCodeProject,0);
                    toast.show();
                    break;


                case R.id.m0604_b004: //默認Toast
                    LayoutInflater inflater = getLayoutInflater();
                    View layout = inflater.inflate(R.layout.custom, (ViewGroup) findViewById(R.id.llToast));

                    ImageView image = (ImageView) layout.findViewById(R.id.tvImageToast);
                    TextView title = (TextView) layout.findViewById(R.id.tvTitleToast);
                    TextView text = (TextView) layout.findViewById(R.id.tvTextToast);

                    image.setImageResource(R.drawable.ic_sample);
                    title.setText(getString(R.string.m0604_t001).toString());
                    text.setText(getString(R.string.m0604_test).toString());
//-----------------------------------
//-----------------------------------
                    toast = new Toast(getApplicationContext());
                    toast.setGravity(Gravity.START | Gravity.TOP, 20, 40);
                    toast.setDuration(Toast.LENGTH_LONG);
                    toast.setView(layout);
                    toast.show();
                    break;
            }


        }
    };



}