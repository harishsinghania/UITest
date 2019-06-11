package com.harish.uidesign.activiies;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.harish.uidesign.adapters.TestFragmentAdapter;
import com.harish.uidesign.R;

public class TestTwoActivity extends FragmentActivity {
    private ViewPager mPager;
    public static final String[] CONTENT1 = new String[]{"Scratch card 1", "Scratch card 2",
            "Scratch card 3"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tast_two);
        initViewPager();
    }

    private void initViewPager() {
        mPager = findViewById(R.id.text_view_pager);
        mPager.setAdapter(new TestFragmentAdapter(CONTENT1,
                TestTwoActivity.this));
        mPager.setClipToPadding(false);
        mPager.setPadding(220,100,220,100);
        mPager.setPageMargin(80);
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(mPager, true);
        mPager.setPageTransformer(false, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(View page, float position) {
                int pageWidth = mPager.getMeasuredWidth() -
                        mPager.getPaddingLeft() - mPager.getPaddingRight();
                int paddingLeft = mPager.getPaddingLeft();
                float transformPos = (float) (page.getLeft() -
                        (mPager.getScrollX() + paddingLeft)) / pageWidth;

                if (transformPos < -1){
                    page.setScaleY(0.8f);
                } else if (transformPos <= 1) {
                    page.setScaleY(1f);
                } else {
                    page.setScaleY(0.8f);
                }

            }
        });
    }
}
