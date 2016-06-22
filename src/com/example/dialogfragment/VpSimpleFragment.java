package com.example.dialogfragment;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class VpSimpleFragment extends Fragment {
	public static final String BUNDLE_TITLE = "title";
	public static final String BUNDLE_POSITION = "position";
	private String mTitle = "DefaultValue";
	private int position=0;
	private ArrayList<String> datas;

	public VpSimpleFragment(String title,int position){
		mTitle=title;
		this.position=position;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
		View view=inflater.inflate(R.layout.fragment, container,false);
		ListView listView=(ListView) view.findViewById(R.id.listview);
		datas=new ArrayList<String>();
		for(int i=0;i<96;i++){
			datas.add("fragment:"+position+",position:"+i);
		}
		listView.setAdapter(new MyAdapter(getContext(), datas));
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
				Toast.makeText(getActivity(), datas.get(position), Toast.LENGTH_SHORT).show();
			}
		});
		return view;
	}
}
