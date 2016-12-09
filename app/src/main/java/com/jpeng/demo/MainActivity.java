package com.jpeng.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.jpeng.jptabbar.BadgeDismissListener;
import com.jpeng.jptabbar.JPTabBar;
import com.jpeng.jptabbar.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

import static com.jpeng.demo.R.id.tabbar;


public class MainActivity extends AppCompatActivity implements OnTabSelectListener{

    private List<Fragment> list = new ArrayList<>();
    private NoScrollViewPager mPager;
    private JPTabBar mTabbar;
    private Sport mTab1;
    private Care mTab2;
    private Score mTab3;
    private Personal mTab4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPager = (NoScrollViewPager) findViewById(R.id.view_pager);
        mTabbar = (JPTabBar) findViewById(tabbar);
        mTabbar.setTitles(R.string.tab1,R.string.tab2,R.string.tab3,R.string.tab4)
                .setNormalIcons(R.mipmap.tab1_normal, R.mipmap.tab2_normal, R.mipmap.tab3_normal, R.mipmap.tab4_normal)
                .setSelectedIcons(R.mipmap.tab1_selected, R.mipmap.tab2_selected, R.mipmap.tab3_selected, R.mipmap.tab4_selected)
                .generate();
        mPager.setNoScroll(false);
        mTab1 = new Sport();
        mTab2 = new Care();
        list.add(mTab1);
        list.add(mTab2);
        list.add(new Score());
        list.add(new Personal());
        mPager.setAdapter(new com.jpeng.demo.Adapter(getSupportFragmentManager(), list));
        //显示圆点模式的徽章
        //设置容器
       // mTabbar.showBadge(0, 50);
        mTabbar.setContainer(mPager);
        //设置Badge消失的代理
       // mTabbar.setDismissListener(this);
        mTabbar.setTabListener(this);
    }




    @Override
    public void onTabSelect(int index) {

    }

    @Override
    public void onClickMiddle(View middleBtn) {
        Intent intent= new Intent(this,SayActivity.class);
        startActivity(intent);
    }

    public JPTabBar getTabbar() {
        return mTabbar;
    }
}
