package com.guoyu.calendardemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.guoyu.calendardemo.R;
import com.guoyu.calendardemo.ui.customview.CustomViewActivity;
import com.guoyu.calendardemo.ui.merge.MergeCellsActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBTMC,mBTCustom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        initWidget();
        initClick();
    }

    private void initClick() {
        mBTMC.setOnClickListener(this);
        mBTCustom.setOnClickListener(this);
    }

    private void initWidget() {
        mBTMC = (Button) findViewById(R.id.act_main_mercel);
        mBTCustom = (Button) findViewById(R.id.act_main_customview);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.act_main_mercel:
                simpleJump(MergeCellsActivity.class);
                break;
            case R.id.act_main_customview:
                simpleJump(CustomViewActivity.class);
                break;
        }
    }

    private void simpleJump(Class totalClazz) {
        Intent intent = new Intent(this, totalClazz);
        startActivity(intent);
    }
}
