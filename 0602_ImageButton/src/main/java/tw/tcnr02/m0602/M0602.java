package tw.tcnr02.m0602;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class M0602 extends AppCompatActivity {

    private ImageView txtComPlay;
    private TextView txtSelect;
    private TextView txtResult;
    private ImageButton btnScissors;
    private ImageButton btnStone;
    private ImageButton btnNet;
    private String user_select;
    private String ff;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0602);
        setupViewComponent();
    }
    private void setupViewComponent(){

        txtComPlay=(ImageView)findViewById(R.id.m0602_c001);
        txtSelect=(TextView)findViewById(R.id.m0602_s001);
        txtResult=(TextView) findViewById(R.id.m0602_f000);
        btnScissors=(ImageButton)findViewById(R.id.m0602_b001);
        btnStone=(ImageButton)findViewById(R.id.m0602_b002);
        btnNet=(ImageButton)findViewById(R.id.m0602_b003);
        btnScissors.setOnClickListener(btn01On);
        btnStone.setOnClickListener(btn01On);
        btnNet.setOnClickListener(btn01On);
}



    private View.OnClickListener btn01On=new Button.OnClickListener(){

        public  void  onClick(View v){
            int iComPlay=(int)(Math.random()*3+1);
            switch (v.getId()){  //玩家出拳
                case R.id.m0602_b001: //玩家選擇剪刀
                    user_select = getString(R.string.m0602_s001) + "  "+getString(R.string.m0602_b001);
                    switch (iComPlay){
                        case 1:
                            txtComPlay.setImageResource(R.drawable.scissors); //電腦選剪刀
                            ff = getString(R.string.m0602_f000) + "  " + getString(R.string.m0602_f001); //ff為變數 是猜拳結果
                            txtResult.setTextColor(getResources().getColor(R.color.Yellow));
                            break;
                        case 2:
                            txtComPlay.setImageResource(R.drawable.stone); //電腦選石頭
                            ff= getString(R.string.m0602_f000)+"   "+getString(R.string.m0602_f002);
                            txtResult.setTextColor(getResources().getColor(R.color.Red));
                            break;
                        case 3:
                            txtComPlay.setImageResource(R.drawable.net); //電腦選布
                            ff=getString(R.string.m0602_f000)+"  "+getString(R.string.m0602_f003);
                            txtResult.setTextColor(getResources().getColor(R.color.Lime));
                            break;
                    }
                break;

                case R.id.m0602_b002: //選擇石頭
                    user_select = getString(R.string.m0602_s001) + "  "+
                            getString(R.string.m0602_b002);
                    switch (iComPlay){
                        case 1:
                            txtComPlay.setImageResource(R.drawable.scissors);
                            ff = getString(R.string.m0602_f000) + "  " + getString(R.string.m0602_f003);
                            txtResult.setTextColor(getResources().getColor(R.color.Lime));
                            break;
                        case 2:
                            txtComPlay.setImageResource(R.drawable.stone);
                            ff= getString(R.string.m0602_f000)+"   "+getString(R.string.m0602_f001);
                            txtResult.setTextColor(getResources().getColor(R.color.Yellow));
                            break;
                        case 3:
                            txtComPlay.setImageResource(R.drawable.net);
                            ff=getString(R.string.m0602_f000)+"  "+getString(R.string.m0602_f002);
                            txtResult.setTextColor(getResources().getColor(R.color.Red));
                            break;
                    }
                    break;
                case R.id.m0602_b003: //玩家選擇布
                    user_select = getString(R.string.m0602_s001) + "  "+
                            getString(R.string.m0602_b003);
                    switch (iComPlay){
                        case 1:
                            txtComPlay.setImageResource(R.drawable.scissors);
                            ff = getString(R.string.m0602_f000) + "  " + getString(R.string.m0602_f002);
                            txtResult.setTextColor(getResources().getColor(R.color.Red));
                            break;
                        case 2:
                            txtComPlay.setImageResource(R.drawable.stone);
                            ff= getString(R.string.m0602_f000)+"   "+getString(R.string.m0602_f003);
                            txtResult.setTextColor(getResources().getColor(R.color.Lime));
                            break;
                        case 3:
                            txtComPlay.setImageResource(R.drawable.net);
                            ff=getString(R.string.m0602_f000)+"  "+getString(R.string.m0602_f001);
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