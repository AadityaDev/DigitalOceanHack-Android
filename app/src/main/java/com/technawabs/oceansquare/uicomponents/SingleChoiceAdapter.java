package com.technawabs.oceansquare.uicomponents;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.technawabs.oceansquare.R;

public class SingleChoiceAdapter extends BaseAdapter {

    Context context;
    String[] list;
    LayoutInflater layoutInflater;

    public SingleChoiceAdapter(@NonNull Context context, @NonNull String[] list) {
        this.context = context;
        this.list = list;
        layoutInflater = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return list.length;
    }

    @Override
    public Object getItem(int i) {
        return list[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = layoutInflater.inflate(R.layout.list_item, null);
        TextView title = (TextView) view.findViewById(R.id.list_name);
        title.setText(list[i]);
        return view;
    }
}
