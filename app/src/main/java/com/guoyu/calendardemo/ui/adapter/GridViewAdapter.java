package com.guoyu.calendardemo.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.guoyu.calendardemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gyz on 2016/8/22.
 */
public class GridViewAdapter extends BaseAdapter {
    private List<String> itemStr = new ArrayList<>();

    private Context mContext;

    public GridViewAdapter(List<String> itemStr, Context context) {
        this.itemStr.addAll(itemStr);
        mContext = context;
    }

    public void setItemStr(List<String> itemStr) {
        this.itemStr = itemStr;
    }

    @Override
    public int getCount() {
        return itemStr.size() > 0 ? itemStr.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return itemStr.size() > 0 ? itemStr.get(i) : null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ChildItemView handler = null;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.item_gv, null);
            handler = new ChildItemView();
            handler.mItem = (TextView) view.findViewById(R.id.item_gv_index);
            view.setTag(handler);
        }else {
            handler = (ChildItemView) view.getTag();
        }
        handler.mItem.setText(itemStr.get(i));

        return view;
    }

    class ChildItemView {
        private TextView mItem;
    }

}
