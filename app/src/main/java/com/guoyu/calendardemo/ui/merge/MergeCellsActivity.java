package com.guoyu.calendardemo.ui.merge;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import com.guoyu.calendardemo.R;
import com.guoyu.calendardemo.ui.adapter.GridViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 合并单元格的联系
 */
public class MergeCellsActivity extends AppCompatActivity {

    private GridView mGridView;

    private GridViewAdapter mAdapter;
    private List<String> items = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merge_cells);

        try {
            init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void init() throws Exception {
        initWidget();
        initData();
        initGridView();
    }

    private void initGridView() {
        if (mAdapter == null) {
            mAdapter = new GridViewAdapter(items, MergeCellsActivity.this);
            mGridView.setAdapter(mAdapter);
        }
    }

    private void initData() {
        for (int i = 1; i < 32; i++) {
            items.add("" + i);
        }
    }

    private void initWidget() {
        mGridView = (GridView) findViewById(R.id.act_merge_gv);

    }
}
