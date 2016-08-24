package com.guoyu.calendardemo.ui.customview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.guoyu.calendardemo.R;
import com.guoyu.calendardemo.view.CalendarPagerView;

public class CustomViewActivity2 extends AppCompatActivity implements View.OnClickListener {

    private CalendarPagerView mCalendarPagerView;

    private Button mBTMerge,mBTRemove;

    private int mergeNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view2);

        init();

    }

    private void init() {
        initWidget();
    }

    private void initWidget() {
        mCalendarPagerView = (CalendarPagerView) findViewById(R.id.act_cus_cpv);
        mBTMerge = (Button) findViewById(R.id.act_cus_merge);
        mBTMerge.setOnClickListener(this);
        mBTRemove = (Button) findViewById(R.id.act_cus_remove);
        mBTRemove.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.act_cus_merge:
                mCalendarPagerView.mergeView(this,2);
                break;
            case R.id.act_cus_remove:
                mCalendarPagerView.removeViewAt(1);
                break;
        }
    }
}
