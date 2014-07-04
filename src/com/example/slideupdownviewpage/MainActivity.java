package com.example.slideupdownviewpage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * 上下滑动的ViewPager实现
 * @author 李小强
 *
 */
public class MainActivity extends FragmentActivity {

	//创建三个Fragment对象
	
	private ViewPager mViewPager;
	private ViewPagerAdapter mViewPagerAdapter;
	private ViewPagerTab mViewPagerTab;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		setUpViewPage();
		setUpTab();
	}
	
	private void setUpTab(){
		mViewPagerTab = (ViewPagerTab) findViewById(R.id.viewpager_tab);
		mViewPagerTab.setViewPager(mViewPager);
		ImageView childView = new ImageView(this);
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1);
		childView.setImageResource(R.drawable.line);
		childView.setLayoutParams(params);
		mViewPagerTab.addView(childView);
	}
	
	private void setUpViewPage(){
		mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
		mViewPager = (ViewPager) findViewById(R.id.viewpager);
		mViewPager.setAdapter(mViewPagerAdapter);
	}
	
	/**
	 * ViewPager适配器
	 * @author 李小强
	 *
	 */
	class ViewPagerAdapter extends FragmentPagerAdapter{
		
		private Class[] fragments;
		public ViewPagerAdapter(FragmentManager fm) {
			super(fm);
			fragments = new Class[]{Fragment1.class, Fragment2.class, Fragment3.class};
		}

		@Override
		public Fragment getItem(int position) {
			try {
				return (Fragment) fragments[position].newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
				return null;
			} catch (IllegalAccessException e) {
				e.printStackTrace();
				return null;
			}
		}	

		@Override
		public int getCount() {
			return fragments.length;
		}
		
	}
}
