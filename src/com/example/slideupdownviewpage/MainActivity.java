package com.example.slideupdownviewpage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
/**
 * 上下滑动的ViewPager实现
 * @author 李小强
 *
 */
public class MainActivity extends FragmentActivity {

	//创建三个Fragment对象
	private Fragment mFragment1 = new Fragment1();
	private Fragment mFragment2 = new Fragment2();
	private Fragment mFragment3 = new Fragment3();
	
	private static final int TAB_INDEX_COUNT = 3;
	
	private static final int TAB_INDEX_ONE = 0;
	private static final int TAB_INDEX_TWO = 1;
	private static final int TAB_INDEX_THREE = 2;
	
	private ViewPager mViewPager;
	private ViewPagerAdapter mViewPagerAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		setUpViewPage();
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

		public ViewPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			switch (position) {
			case TAB_INDEX_ONE:
				return mFragment1;
			case TAB_INDEX_TWO:
				return mFragment2;
			case TAB_INDEX_THREE:
				return mFragment3;
			}
			throw new IllegalStateException("No fragment at position " + position);
		}

		@Override
		public int getCount() {
			return TAB_INDEX_COUNT;
		}
		
	}

}
