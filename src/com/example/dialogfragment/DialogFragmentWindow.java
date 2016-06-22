package com.example.dialogfragment;

import java.util.ArrayList;
import java.util.List;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

public class DialogFragmentWindow  extends DialogFragment {
	
	private List<Fragment> fragments;

	@Override
	public void onStart() {
		super.onStart();
		DisplayMetrics dm = new DisplayMetrics();
		getActivity().getWindowManager().getDefaultDisplay().getMetrics( dm );
		getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0xffffffff));
		getDialog().getWindow().setLayout( dm.widthPixels, getDialog().getWindow().getAttributes().height );
	}
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.popup, container);

        ViewPager viewpager = (ViewPager) view.findViewById(R.id.viewpager);
        fragments = getFragments();
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        viewpager.setAdapter(adapter);
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getDialog().getWindow().setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM);
        return view;
    }

    private List<Fragment> getFragments(){
        List<Fragment> fList = new ArrayList<Fragment>();
        fList.add(new VpSimpleFragment("fragment1",0));
        fList.add(new VpSimpleFragment("fragment2",1));
        fList.add(new VpSimpleFragment("fragment3",2));
        return fList;
    }
    
    class ViewPagerAdapter extends FragmentPagerAdapter{

    	public ViewPagerAdapter(FragmentManager fm) {
    		super(fm);
    	}

    	@Override
    	public Fragment getItem(int arg0) {
    		return fragments.get(arg0);
    	}

    	@Override
    	public int getCount() {
    		return fragments.size();
    	}

    }
}
