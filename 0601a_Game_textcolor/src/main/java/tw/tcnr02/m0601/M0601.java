package tw.tcnr02.m0601;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class M0601 extends AppCompatActivity {

    private TextView txtComPlay;
    private TextView txtSelect;
    private TextView txtResult;
    private Button btnScissors;
    private Button btnStone;
    private Button btnNet;
    private String user_select;
    private String ff;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0601);
        setupViewComponent();
    }
    private void setupViewComponent(){
        txtComPlay=(TextView)findViewById(R.id.m0601_c001);
        txtSelect=(TextView)findViewById(R.id.m0601_s001);
        txtResult=(TextView) findViewById(R.id.m0601_f000);
        btnScissors=(Button)findViewById(R.id.m0601_b001);
        btnStone=(Button)findViewById(R.id.m0601_b002);
        btnNet=(Button)findViewById(R.id.m0601_b003);
        btnScissors.setOnClickListener(btn01On);
        btnStone.setOnClickListener(btn01On);
        btnNet.setOnClickListener(btn01On);
}



    private View.OnClickListener btn01On=new Button.OnClickListener(){

        public  void  onClick(View v){
            int iComPlay=(int)(Math.random()*3+1);
            switch (v.getId()){  //玩家出拳
                case R.id.m0601_b001: //玩家選擇剪刀
                    user_select = getString(R.string.m0601_s001) + "  "+getString(R.string.m0601_b001);
                    switch (iComPlay){
                        case 1:
                            txtComPlay.setText(R.string.m0601_b001); //電腦選剪刀
                            ff = getString(R.string.m0601_f000) + "  " + getString(R.string.m0601_f001); //ff為變數 是猜拳結果
                            txtResult.setTextColor(getResources().getColor(R.color.Yellow));
                            break;
                        case 2:
                            txtComPlay.setText(R.string.m0601_b002); //電腦選石頭
                            ff= getString(R.string.m0601_f000)+"   "+getString(R.string.m0601_f002);
                            txtResult.setTextColor(getResources().getColor(R.color.Red));
                            break;
                        case 3:
                            txtComPlay.setText(R.string.m0601_b003); //電腦選布
                            ff=getString(R.string.m0601_f000)+"  "+getString(R.string.m0601_f003);
                            txtResult.setTextColor(getResources().getColor(R.color.Lime));
                            break;
                    }
                break;

                case R.id.m0601_b002: //選擇石頭
                    user_select = getString(R.string.m0601_s001) + "  "+
                            getString(R.string.m0601_b002);
                    switch (iComPlay){
                        case 1:
                            txtComPlay.setText(R.string.m0601_b001);
                            ff = getString(R.string.m0601_f000) + "  " + getString(R.string.m0601_f003);
                            txtResult.setTextColor(getResources().getColor(R.color.Lime));
                            break;
                        case 2:
                            txtComPlay.setText(R.string.m0601_b002);
                            ff= getString(R.string.m0601_f000)+"   "+getString(R.string.m0601_f001);
                            txtResult.setTextColor(getResources().getColor(R.color.Yellow));
                            break;
                        case 3:
                            txtComPlay.setText(R.string.m0601_b003);
                            ff=getString(R.string.m0601_f000)+"  "+getString(R.string.m0601_f002);
                            txtResult.setTextColor(getResources().getColor(R.color.Red));
                            break;
                    }
                    break;
                case R.id.m0601_b003: //玩家選擇布
                    user_select = getString(R.string.m0601_s001) + "  "+
                            getString(R.string.m0601_b003);
                    switch (iComPlay){
                        case 1:
                            txtComPlay.setText(R.string.m0601_b001);
                            ff = getString(R.string.m0601_f000) + "  " + getString(R.string.m0601_f002);
                            txtResult.setTextColor(getResources().getColor(R.color.Red));
                            break;
                        case 2:
                            txtComPlay.setText(R.string.m0601_b002);
                            ff= getString(R.string.m0601_f000)+"   "+getString(R.string.m0601_f003);
                            txtResult.setTextColor(getResources().getColor(R.color.Lime));
                            break;
                        case 3:
                            txtComPlay.setText(R.string.m0601_b003);
                            ff=getString(R.string.m0601_f000)+"  "+getString(R.string.m0601_f001);
                            txtResult.setTextColor(getResources().getColor(R.color.Yellow));
                            break;
                    }
                    break;

            }
            txtSelect.setText(user_select);
            txtResult.setText(ff);



        }



        };


        }