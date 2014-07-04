package com.example.slideupdownviewpage;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Scroller;

/**
 * 
 * @author ÀîÐ¡Ç¿
 *
 */
public class ViewPagerTab extends ViewGroup{
	
	private ViewPager mViewPager;
	private PageListener mPageListener = new PageListener();
	private Context mContext;
	
	private int mWidth;
	private int mHeight;
	private Scroller mScroller;  

	public ViewPagerTab(Context context, AttributeSet attrs) {
		super(context, attrs);	
		this.mContext = context;
		mScroller = new Scroller(mContext);  
	}
	

	
	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		if(getChildCount() > 0){
			getChildAt(0).layout(0, 0, mWidth / 3, mHeight);  
		}
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		mWidth = MeasureSpec.getSize(widthMeasureSpec);  
        mHeight = MeasureSpec.getSize(heightMeasureSpec); 
	}
	
	public void setViewPager(ViewPager viewPager){
		this.mViewPager = viewPager;
		mViewPager.setOnPageChangeListener(mPageListener);
	}

	@Override
	public void computeScroll() {
		super.computeScroll();  
        if(mScroller.computeScrollOffset()){  
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());  
            postInvalidate();  
        }  
	}
	
	
	private class PageListener implements OnPageChangeListener {

		@Override
		public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
			scrollTo(- position * mWidth / 3 - Math.round(positionOffset * mWidth / 3), 0);
		}

		@Override
		public void onPageSelected(int position) {

		}

		@Override
		public void onPageScrollStateChanged(int arg0) {
	
		}

	}
}
