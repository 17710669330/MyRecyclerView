package recycler.xhf.asus.myrecyclerview;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import recycler.xhf.asus.myrecyclerview.Fragment.fragment1;
import recycler.xhf.asus.myrecyclerview.Fragment.fragment2;

public class GuoWuYuanActivity extends FragmentActivity implements View.OnClickListener {

    private TextView tv_main_bumen;
    private TextView tv_main_lianbo;
    private ViewPager vp;
    private Fragment fragment;
    private RadioGroup rg;
    private RadioGroup rg1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guo_wu_yuan);

        tv_main_bumen = (TextView) findViewById(R.id.tv_main_bumen);
        tv_main_lianbo = (TextView) findViewById(R.id.tv_main_lianbo);
        vp = (ViewPager) findViewById(R.id.vp);
        rg = (RadioGroup) findViewById(R.id.rg);
        rg1 = (RadioGroup) findViewById(R.id.rg1);
        RadioBianSe(0);
        tv_main_bumen.setOnClickListener(this);
        tv_main_lianbo.setOnClickListener(this);
        rg1.setOnClickListener(this);


        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

           @Override
           public int getCount() {
               return 2;
           }

           @Override
           public Fragment getItem(int position) {

               fragment = new Fragment();
               switch (position){
                   case 0:
                       fragment = new fragment1();
                       break;
                   case 1:
                       fragment = new fragment2();
                       break;
               }
               return fragment;
           }
       });
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                vp.setCurrentItem(position);
                RadioBianSe(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }



    private void RadioBianSe(int tag) {
        for (int i= 0;i<rg.getChildCount();i++){
            TextView rb =(TextView) rg.getChildAt(i);
            if(tag==i){
                rb.setTextColor(Color.BLUE);
                rb.setTextSize(18);
            }else{
                rb.setTextColor(Color.GRAY);
                rb.setTextSize(14);
            }
            for (int w = 0; w<rg1.getChildCount();w++){
                TextView rb1 = (TextView) rg1.getChildAt(w);
                if(tag==w){
                    rb1.setBackgroundColor(Color.BLUE);
                }else{
                    rb1.setBackgroundColor(Color.TRANSPARENT);
                }
            }

        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_main_bumen:
                vp.setCurrentItem(0);
                RadioBianSe(0);
                break;
            case R.id.tv_main_lianbo:
                vp.setCurrentItem(1);
                RadioBianSe(1);
                break;


        }
    }




}
