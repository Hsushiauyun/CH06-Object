package tw.tcnr02.m0609;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Menu03 extends AppCompatActivity {
    private Intent intent02 = new Intent();
    private TextView tv;
    private TextView myname, objt001;
    private Intent intent03;
    String mode_title;
    
    public boolean onCreateOptionsMenu(Menu menu) {  //右上角三點設定
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.m0609, menu);
        return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmenu);

        setupViewComponent();
    }

    private void setupViewComponent() {

        TextView myname = (TextView) findViewById(R.id.t001);

        LinearLayout mlay02 = (LinearLayout) findViewById(R.id.lay02);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
//        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
//                LayoutParams.MATCH_PARENT, 180);

        lp.setMargins(0, 0, 0, 10); // 設定物件之間距離

        // 動態調整高度 抓取使用裝置尺寸
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int newscrollheight = displayMetrics.heightPixels * 75 / 100; // 設定ScrollView使用尺寸的4/5
        ScrollView scr01 = (ScrollView) findViewById(R.id.scr01);
        scr01.getLayoutParams().height = newscrollheight;
        scr01.setLayoutParams(scr01.getLayoutParams()); // 重定ScrollView大小
        //--------------------
        myname.setText("size:" + displayMetrics.widthPixels + " x "
                + displayMetrics.heightPixels + " "
                + getString(R.string.name));
        // -------------------
        TextView objt001 = (TextView) findViewById(R.id.objT001); // 取出參考物件
        objt001.setVisibility(View.GONE); // 設定參考物件隱藏不佔空間

        // 設定class標題
        Intent intent01 = this.getIntent();
        mode_title = intent01.getStringExtra("subname");
        this.setTitle(this.getResources().getIdentifier(mode_title, "string", getPackageName()));
        //-------------------------------------
        try {
            for (int i = 1; i <= 20; i++) {
                tv = new TextView(this);// 產生新的TextView layout
                tv.setId(i);
                // 設定新TextView的ID
                // %02d執行十進制整數轉換d，格式化補零，寬度為2。 因此，一個int參數，它的值是7
                // ，將被格式化為"07"作為一個String
                String microNo = String.format("%02d", i);
                int id = getResources().getIdentifier(mode_title+ microNo,
                        "string",  getPackageName());
                if (id == 0) {
                    break; // 假如 getIdentifier 找不到滿足資料, 會傳回 0 , 所以中斷迴圈
                }
                tv.setText(id);
                tv.setLayoutParams(lp);
                tv.setTextColor(objt001.getCurrentTextColor()); // 以objt001字體顏色為依據
                tv.setGravity(objt001.getGravity()); // 以objt001字體靠右靠左
                tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, objt001.getTextSize()); // 設定文字大小
                tv.setBackground(objt001.getBackground()); // 設定背景
//				tv.setPadding(40, 0, 40, 0); // 設定文字內間距 left,top,right,bottom
                tv.setPadding(objt001.getPaddingLeft(),
                        objt001.getPaddingTop(),
                        objt001.getPaddingRight(),
                        objt001.getPaddingBottom()); // 設定文字內間距 left,top,right,bottom

                mlay02.addView(tv);
                tv.setOnClickListener(clkOn);
            }
        } catch (Exception e) {
            return;
        }
    }

    private TextView.OnClickListener clkOn = new TextView.OnClickListener() {



        public void onClick(View v) {

            int ii = v.getId(); // 下層巨集前兩碼

            String mm = String.format("%02d", ii);
            String thrname = mode_title + mm;
            intent03.putExtra("subname", thrname);
            intent03.setClass(Menu03.this, Menu03.class);
            startActivity(intent03);
//            onCreate(null);
        }
    };

}