package com.example.viewpageindicator;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends FragmentActivity implements ViewPager.OnPageChangeListener{
    @Bind(R.id.text1) RadioButton text1;
    @Bind(R.id.text2) RadioButton text2;
    @Bind(R.id.text3) RadioButton text3;
    @Bind(R.id.text4) RadioButton text4;
    @Bind(R.id.text5) RadioButton text5;
    @Bind(R.id.text6) RadioButton text6;
    @Bind(R.id.text7) RadioButton text7;
    @Bind(R.id.text8) RadioButton text8;
    @Bind(R.id.indicator) ViewPageIndicator indicator;
    @Bind(R.id.viewpager) ViewPager viewpager;

    private boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.indicator);
        ButterKnife.bind(this);

        viewpager.setAdapter(new pageadapter(getSupportFragmentManager(), 8));
        viewpager.setOnPageChangeListener(this);
        indicator.setOnCheckedChangeListener(listener);
        text1.setChecked(true);
    }

    private RadioGroup.OnCheckedChangeListener listener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId){
                case R.id.text1:
                    viewpager.setCurrentItem(0,flag);
                break;

                case R.id.text2:
                    viewpager.setCurrentItem(1,flag);
                    break;

                case R.id.text3:
                    viewpager.setCurrentItem(2,flag);
                    break;

                case R.id.text4:
                    viewpager.setCurrentItem(3,flag);
                    break;

                case R.id.text5:
                    viewpager.setCurrentItem(4,flag);
                    break;

                case R.id.text6:
                    viewpager.setCurrentItem(5,flag);
                    break;

                case R.id.text7:
                    viewpager.setCurrentItem(6,flag);
                    break;

                case R.id.text8:
                    viewpager.setCurrentItem(7,flag);
                    break;
            }
        }
    };

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        indicator.scroll(position, positionOffset);
    }

    @Override
    public void onPageSelected(int position) {
        switch (position+1){
            case 1:
                text1.setChecked(true);
                break;
            case 2:
                text2.setChecked(true);
                break;
            case 3:
                text3.setChecked(true);
                break;
            case 4:
                text4.setChecked(true);
                break;
            case 5:
                text5.setChecked(true);
                break;
            case 6:
                text6.setChecked(true);
                break;
            case 7:
                text7.setChecked(true);
                break;
            case 8:
                text8.setChecked(true);
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) { }
}
