package com.example.onezhoukao;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;


/**
 * data:2017/4/7
 * 适配器
 */

public class MyBeaseAdapter extends BaseAdapter {

    private Context context;
    private List<Bean.ListBean> list ;

    public MyBeaseAdapter(Context context, List<Bean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder ;
        if (convertView == null){
            holder = new ViewHolder();
            convertView = View.inflate(context,R.layout.item,null);
            holder.textView1 = (TextView) convertView.findViewById(R.id.textView1_item);
            holder.textView2 = (TextView) convertView.findViewById(R.id.textView2_item);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textView1.setText(list.get(position).getSite_name()+"");
        holder.textView2.setText(list.get(position).getAddress()+"");
        return convertView;
    }

    class  ViewHolder{
        TextView textView1,textView2;
    }
}