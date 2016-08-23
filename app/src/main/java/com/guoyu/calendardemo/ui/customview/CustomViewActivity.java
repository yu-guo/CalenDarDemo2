package com.guoyu.calendardemo.ui.customview;

import android.content.DialogInterface;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.guoyu.calendardemo.R;
import com.guoyu.calendardemo.bean.DayViewEvent;
import com.guoyu.calendardemo.inte.EmptyViewClickListener;
import com.guoyu.calendardemo.inte.EventClickListener;
import com.guoyu.calendardemo.inte.EventLongPressListener;
import com.guoyu.calendardemo.view.RectView;
import com.guoyu.calendardemo.view.TableTestView;
import com.orhanobut.logger.Logger;

public class CustomViewActivity extends AppCompatActivity implements EmptyViewClickListener, EventClickListener, EventLongPressListener {

    private RectView mRectView;

    private TableTestView mTableTestView;

    private int mergeNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);

        init();

    }

    private void init() {
        initWidget();
    }

    private void initWidget() {
//        mRectView = (RectView) findViewById(R.id.act_cus_view);
        mTableTestView = (TableTestView) findViewById(R.id.act_custom_tabletest);
        mTableTestView.setEmptyViewClickListener(this);
        mTableTestView.setEventClickListener(this);
        mTableTestView.setEventLongPressListener(this);
    }



    @Override
    public void onEventClick(DayViewEvent event, RectF eventRectf) {

    }

    @Override
    public void onEventLongPress(DayViewEvent event, RectF eventRectf) {

    }

    private void showDialog(final RectF rectF) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(this).inflate(R.layout.merge_dialog, null);
        final EditText mET = (EditText) view.findViewById(R.id.merge_dialog_num);
        builder.setTitle("请输入需要合并的数量");
        builder.setView(view);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                mergeNum = Integer.valueOf(mET.getText().toString());
                Logger.i("需要合并：" + mergeNum);
                mTableTestView.merge(rectF, mergeNum);
            }
        });
        builder.create().show();
    }

    @Override
    public void onEmptyViewClicked(DayViewEvent event, RectF rectF) {
        showDialog(rectF);


    }
}
