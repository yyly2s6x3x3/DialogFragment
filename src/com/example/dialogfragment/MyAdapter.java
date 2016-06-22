package com.example.dialogfragment;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter{
	
	private Context context;
	private ArrayList<String> datas;
	
	public MyAdapter(Context context,ArrayList<String> datas){
		this.context=context;
		this.datas=datas;
	}

	@Override
	public int getCount() {
		return datas.size();
	}

	@Override
	public String getItem(int position) {
		return datas.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		convertView=View.inflate(context, R.layout.item, null);
		TextView textView=(TextView) convertView.findViewById(R.id.textView1);
		textView.setText(getItem(position));
		return convertView;
	}


}
