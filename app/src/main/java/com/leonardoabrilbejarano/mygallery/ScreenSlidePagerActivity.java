package com.leonardoabrilbejarano.mygallery;

/**
 * Created by usuario on 23/05/2017.
 */

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.ListFragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.leonardoabrilbejarano.mygallery.util.FakeR;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.leonardoabrilbejarano.mygallery.photoview.PhotoViewAttacher;


public class ScreenSlidePagerActivity extends FragmentActivity {
    /**
     * The number of pages (wizard steps) to show in this demo.
     */
    public static int actualpage = 0;
    public static String[][] urls ;
    //public static boolean[] init = new boolean[10];
    //public static ImageView[] img = new ImageView[5];
    //private static ScreenSlidePageFragment[] fragment = new ScreenSlidePageFragment[5];
    private static final int NUM_PAGES = 10;
    private int index = 0;
    private ScreenSlidePageFragment fragmentaux = null;
    private boolean swipeable=true;
    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private MyViewPager mPager;
	private FakeR fakeR;
	
    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_screen_slide);
		fakeR = new FakeR(this);
        setContentView(fakeR.getId("layout", "activity_screen_slide"));//this.getResources().getIdentifier("activity_screen_slide", "layout", this.getPackageName()));
		Log.e("source",urls[0][0] + urls[0][1]);

        // Init url
        //for(int i = 0; i < urls.length ; i++){
			/*
        urls[0] = "http://images4.fanpop.com/image/photos/22100000/The-number-numbers-22189047-1732-1732.jpg";
        urls[1] = "http://www.wallcoo.net/cartoon/The_fiery_English_alphabets_and_fiery_numbers_1920_1600/images/The_fiery_numbers_picture_4108942.jpg";
        urls[2] = "http://wallpapercave.com/wp/wp1850997.jpg";
        urls[3] = "http://wallpapercave.com/wp/wp1844052.jpg";
        urls[4] = "http://www.xsjjys.com/data/out/228/WHDQ-513634753.jpg";
        urls[5] = "http://images4.fanpop.com/image/photos/22100000/The-number-numerology-22189678-1732-1732.jpg";
        urls[6] = "http://images4.fanpop.com/image/photos/22100000/The-number-numerology-22189683-1732-1732.jpg";
        urls[7] = "http://wallpapercave.com/wp/wW1Sm7B.jpg";
        urls[8] = "http://images4.fanpop.com/image/photos/22100000/The-number-numbers-22189114-1732-1732.jpg";
        urls[9] = "http://images4.fanpop.com/image/photos/22100000/The-number-numerology-22189711-1732-1732.jpg";
        */
		//}
        /*
        for(int i = 0; i < img.length ; i++){
            img[i] = null;
        }
        */
        /*
        for(int i = 0; i < fragment.length ; i++){
            fragment[i] = new ScreenSlidePageFragment(i);
        }
        */

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (MyViewPager) findViewById(fakeR.getId("id", "pager"));
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        mPager.setPageTransformer(true, new ZoomOutPageTransformer());

       /* mPager.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (swipeable)
                    return false;
                else
                    return true;
            }
        });*/
        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            /*
            @Override
            public boolean onInterceptTouchEvent(MotionEvent event) {
                if(fragmentaux.mAttacher.getScale() > 1.1) {
                    return false;
                }else {
                    return super.onInterceptTouchEvent(event);
                }
            }

            @Override
            public boolean onTouchEvent(MotionEvent event) {
                if(fragmentaux.mAttacher.getScale() > 1.1) {
                    return false;
                }else {
                    return super.onInterceptTouchEvent(event);
                }
            }*/


            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.e("SCROLLPAGE", position + "");
               // index = position;

            }

            @Override
            public void onPageSelected(int position) {
                //index = position;

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                //Log.e("state",state+"");
            }
        });
    }

    public ScreenSlidePageFragment getFragmentaux() {
        return fragmentaux;
    }

    public void setFragmentaux(ScreenSlidePageFragment fragmentaux) {
        this.fragmentaux = fragmentaux;
    }

    @Override
    public void onBackPressed() {

		finish();
	
        //super.onBackPressed();

        // mPager.setCurrentItem(mPager.getCurrentItem() - 1);
    }
    public void passData(){
        mPager.setFragmentaux(this);
    }

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public Fragment getItem(int position) {
            /*
            actualpage = position ;
            return fragment[position];
            */
            //mPager.setCurrentItem(index);
            Log.e("INDEX ASD", position + "");
            fragmentaux = new ScreenSlidePageFragment(position);
            passData();
            return fragmentaux;

            //return ArrayListFragment.newInstance(position);

        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
    
    public void back(View view){
        finish();
    }
}

