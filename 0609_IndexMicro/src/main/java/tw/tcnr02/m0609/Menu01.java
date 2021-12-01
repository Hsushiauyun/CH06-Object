package tw.tcnr02.m0609;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class Menu01 extends AppCompatActivity {


    private LinearLayout mlay02;
    private TextView myname;
    private TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmenu);
        setupViewComponent();
    }

    private void setupViewComponent() {
        mlay02 = (LinearLayout) findViewById(R.id.lay02);
        myname = (TextView) findViewById(R.id.t001);
        //-----------------------------------------------------
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
//                LayoutParams.MATCH_PARENT, 180);
        lp.setMargins(0, 0, 0, 10); // 設定物件之間距離

        // 動態調整高度 抓取使用裝置尺寸
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int newscrollheight = displayMetrics.heightPixels * 75/ 100; // 設定ScrollView使用尺寸的4/5
//        String px = displayMetrics.widthPixels + " x " +
//                displayMetrics.heightPixels;
//        String dp = displayMetrics.xdpi + " x " + displayMetrics.ydpi;
//        String density = "densityDpi = " + displayMetrics.densityDpi +
//                ", density=" + displayMetrics.density + ", scaledDensity = " +
//                displayMetrics.scaledDensity;
//        myname.setText(px + "\n" + dp + "\n" + density + "\n" +
//                newscrollheight);
        //------------------------------------------------------------------------
        ScrollView scr01 = (ScrollView) findViewById(R.id.scr01);
        scr01.getLayoutParams().height = newscrollheight;
        scr01.setLayoutParams(scr01.getLayoutParams()); // 重定ScrollView大小
        myname.setText("size:" + displayMetrics.widthPixels + " x "
                + displayMetrics.heightPixels + " "
                + "\n"+getString(R.string.name));
        // ----
        TextView objt001 = (TextView) findViewById(R.id.objT001); // 取出參考物件
        objt001.setVisibility(View.GONE); // 設定參考物件隱藏不佔空間
        // ----
        try {
            for (int i = 5; i <= 20; i++) {// 設定走20圈, 遇到沒資料自動停止.
                tv = new TextView(this); // tv 繼承TextView
                tv.setId(i); // 寫入配置碼ID 代號
                // %02d執行十進制整數轉換d，格式化補零，寬度為2。 因此，一個int參數，它的值是7
                // ，將被格式化為"07"作為一個String
                String microNo = String.format("%02d", i);
//                Log.d(TAG,             microNo                );
                // 取得string 裏頭相對應的ID 碼
                int id = getResources().getIdentifier("m" + microNo, "string", getPackageName());
                // --------------------------------------------
                if (id == 0) {
                    break; // 假如 getIdentifier 找不到滿足資料, 會傳回 0 , 所以中斷迴圈
                }
                // --------------------------------------------
                tv.setText(id); // 將產生的物件填入文字.

                tv.setLayoutParams(lp); // 套用格式
                tv.setTextColor(objt001.getCurrentTextColor()); // 以objt001字體顏色為依據
                tv.setGravity(objt001.getGravity()); // 以objt001字體靠右靠左
                tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, objt001.getTextSize()); // 設定文字大小
                tv.setBackground(objt001.getBackground()); // 設定背景
                tv.setPadding(objt001.getPaddingLeft(),
                        objt001.getPaddingTop(),
                        objt001.getPaddingRight(),
                        objt001.getPaddingBottom()); // 設定文字內間距 left,top,right,bottom
                mlay02.addView(tv);// 顯示textview物件

//                tv.setOnClickListener(clkOn);
            }

        } catch (Exception e) {
            return;
        }
    }
}