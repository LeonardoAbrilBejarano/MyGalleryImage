package com.leonardoabrilbejarano.mygallery;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import com.leonardoabrilbejarano.mygallery.util.FakeR;

/**
 * Created by usuario on 25/05/2017.
 */

public class MyViewPager extends ViewPager {

    public static boolean mSwipable = true;
    private ScreenSlidePagerActivity fragmentaux = null;
	private FakeR fakeR;

    public MyViewPager(Context context) {
        super(context);
    }

    public boolean ismSwipable() {
        return mSwipable;
    }

    public ScreenSlidePagerActivity getFragmentaux() {
        return fragmentaux;
    }

    public void setFragmentaux(ScreenSlidePagerActivity fragmentaux) {
        this.fragmentaux = fragmentaux;
    }

    public void setmSwipable(boolean mSwipable) {
        this.mSwipable = mSwipable;
    }

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
		fakeR = new FakeR(context);
        //TypedArray a = context.obtainStyledAttributes(attrs, fakeR.getId("styleable", "MyViewPager_swipeable"));
		TypedArray a = context.obtainStyledAttributes(attrs, new int[]{context.getApplicationContext().getResources().getIdentifier("MyViewPager_swipeable", "styleable", context.getApplicationContext().getPackageName())});
        try {
            mSwipable = a.getBoolean(fakeR.getId("styleable", "MyViewPager_swipeable"), true);
			//mSwipable = a.getBoolean(getContext().getApplication().getResources().getIdentifier("MyViewPager_swipeable", "styleable", getActivity().getApplication().getPackageName()), true);
        } finally {
            a.recycle();
        }
    }
    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        if(!MyViewPager.mSwipable) {
            return false;
        }else {
            try{
                return super.onInterceptTouchEvent(event);
            }catch(Exception e){
                Log.e("EXCEPTION POINTER",e.toString());
                return false;
            }
        }
       // return mSwipable ? super.onInterceptTouchEvent(event) : false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(!MyViewPager.mSwipable) {
            return false;
        }else {
            return super.onTouchEvent(event);
        }
        //return mSwipable ? super.onTouchEvent(event) : false;
    }

    public boolean isSwipable() {
        return mSwipable;
    }

    public void setSwipable(boolean swipable) {
        mSwipable = swipable;
    }
}
