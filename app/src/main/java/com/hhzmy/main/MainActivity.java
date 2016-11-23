package com.hhzmy.main;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.np_vp)
    ViewPager npVp;
    @BindView(R.id.np_ll)
    LinearLayout npLl;
    @BindView(R.id.np_iv_one)
    ImageView npIvOne;
    @BindView(R.id.np_iv_two)
    ImageView npIvTwo;
    private ViewPager vp;
    private LinearLayout np_ll;
    private List<View> viewlist;
    private ImageView iv_one;
    private ImageView iv_two;
    private ImageView iv_three;
    private View one;
    private View two;
    private View three;
    private static SharedPreferences sp;
    private boolean isflag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp=getPreferences(MODE_PRIVATE);
        isflag = sp.getBoolean("isflag", false);
        if(isflag){
            startActivity(new Intent(getApplicationContext(),SecondActivity.class));
            MainActivity.this.finish();
            return;
        }
        isflag=!isflag;
        ButterKnife.bind(this);
        initData();
        initViewPager();
        iv_one = (ImageView)one.findViewById(R.id.np_iv_one);
        iv_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),SecondActivity.class));
                sp.edit().putBoolean("isflag",true).commit();
            }
        });
        iv_two = (ImageView)two.findViewById(R.id.np_iv_two);
        iv_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),SecondActivity.class));
                sp.edit().putBoolean("isflag",true).commit();
            }
        });
        iv_three = (ImageView)three.findViewById(R.id.np_iv_three);
        iv_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),SecondActivity.class));
                sp.edit().putBoolean("isflag",true).commit();
            }
        });
    }

    private void initData() {
        viewlist = new ArrayList<View>();
        one = View.inflate(this, R.layout.np_one, null);
        two = View.inflate(this, R.layout.np_two, null);
        three = View.inflate(this, R.layout.np_three, null);
        viewlist.add(one);
        viewlist.add(two);
        viewlist.add(three);
    }

    private void initViewPager() {
        vp = (ViewPager) findViewById(R.id.np_vp);
        np_ll = (LinearLayout) findViewById(R.id.np_ll);
        vp.setAdapter(new PagerAdapter() {
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view = viewlist.get(position);
                container.addView(view);
                return view;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(viewlist.get(position));
            }

            @Override
            public int getCount() {
                return viewlist.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }
        });
            vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int arg0, float positionOffset, int positionOffsetPixels) {
                // 将arg0换算到viewList的索引范围之内
                final int position = arg0 % viewlist.size();
                // 遍历所有的点对应的ImageView ，判断点的索引是否跟ViewPager当前的索引一致
                for (int i = 0; i < np_ll.getChildCount(); i++) {
                    ImageView image = (ImageView) np_ll.getChildAt(i);
                    if (i == position) {
                        image.setSelected(true);
                    } else {
                        image.setSelected(false);
                    }
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        // 添加下面的圆点
        for (int i = 0; i < viewlist.size(); i++) {
            // 动态实例化ImageView对象，添加到LinearLayout里面
            ImageView imageview = new ImageView(getApplicationContext());
            // 手动代码设置间距
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(5, 0, 5, 0);
            // 将当前属性设置给ImageView
            imageview.setLayoutParams(params);
            // 给ImageView设置显示资源
            imageview.setBackgroundResource(R.drawable.item_selector);
            // 将ImageView添加到LinearLayout里面
            np_ll.addView(imageview);
            // 设置默认选中第一个
            if (i == 0) {
                imageview.setSelected(true);
            }
        }
    }

}
