package com.leonardoabrilbejarano.mygallery;


import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.leonardoabrilbejarano.mygallery.util.FakeR;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import android.util.Base64;
import com.leonardoabrilbejarano.mygallery.photoview.PhotoViewAttacher;

/**
 * Created by usuario on 23/05/2017.
 */

public class ScreenSlidePageFragment extends Fragment {
    public ImageView photo;
    private LinearLayout fr;
    public PhotoViewAttacher mAttacher;
    private String imageUrl;
    private int index;
	private FakeR fakeR;
	private TextView txt;



    @SuppressLint("ValidFragment")
    public ScreenSlidePageFragment(int i) {
        this.index = i;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
								 //fakeR = new FakeR(this);
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                getActivity().getApplication().getResources().getIdentifier("fragment_screen_slide_page", "layout", getActivity().getApplication().getPackageName()), container, false);


        photo = (ImageView) rootView.findViewById( getActivity().getApplication().getResources().getIdentifier("photoView", "id", getActivity().getApplication().getPackageName()) );
        fr = (LinearLayout) rootView.findViewById( getActivity().getApplication().getResources().getIdentifier("fullscreen_content_controls", "id", getActivity().getApplication().getPackageName()) );
        txt = (TextView)  rootView.findViewById( getActivity().getApplication().getResources().getIdentifier("titleTxt", "id", getActivity().getApplication().getPackageName()) );
     
        mAttacher = new PhotoViewAttacher(photo,fr);
        //photo=(ImageView) rootView.findViewById(fakeR.getId("id", "photoView"));
        Log.e("INDEXIMAGE", index  + "");
        loadImage();/*
        if(index-1>=0 && index -1<5){
            if(ScreenSlidePagerActivity.img[index-1] == null){
                loadImage();
            } else {
                photo = ScreenSlidePagerActivity.img[index-1];
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.e("TRIGGERED","RUN ON UI THREAD");
                        photo.setVisibility(View.VISIBLE);

                    }
                });
            }
        }*/
        return rootView;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public boolean loadImage(){
        try{
			 txt.setText(ScreenSlidePagerActivity.urls[index][0]);
                 if(ScreenSlidePagerActivity.urls[index][1].split(",")[0].startsWith("data")){
                               byte[] imageByteArray = Base64.decode(ScreenSlidePagerActivity.urls[index][1].split(",")[1], Base64.DEFAULT);
                Glide
                        .with(this)
                        .load(imageByteArray)
                        .fitCenter()
                        .crossFade()
                        .listener(new RequestListener<byte[], GlideDrawable>() {
                            @Override
                            public boolean onException(Exception e, byte[] model, Target<GlideDrawable> target, boolean isFirstResource) {
                                return false;
                            }

                            @Override
                            public boolean onResourceReady(GlideDrawable resource, byte[] model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {

                                new Thread(new Runnable() {
                                    public void run() {
                                        //wait, put here some sleep
                                        try {
                                            getActivity().runOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    photo.setVisibility(View.INVISIBLE);
                                                }
                                            });
                                            try {
                                                Thread.sleep(200);
                                            } catch (InterruptedException e) {
                                                e.printStackTrace();
                                            }
                                            getActivity().runOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    Log.e("TRIGGERED", "RUN ON UI THREAD");
                                                    mAttacher.update();

                                                }
                                            });
                                            try {
                                                Thread.sleep(100);
                                            } catch (InterruptedException e) {
                                                e.printStackTrace();
                                            }
                                            getActivity().runOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    Log.e("TRIGGERED", "RUN ON UI THREAD");
                                                    photo.setVisibility(View.VISIBLE);
                                                    //ScreenSlidePagerActivity.img[index ] = photo;
                                                    Log.e("PAGE", String.valueOf(index ));
                                                }
                                            });
                                        }catch(Exception e){
                                            Log.e("ERROR", e.toString());

                                        }
                                    }}).start();

                                Log.e("Procedure","Done");
                    /*
                    mAttacher.update();
                    photo.setVisibility(View.VISIBLE);
                    */

                                return false;
                            }
                            
                        }).into(photo);

            }else{

                Glide
                        .with(this)
                        .load(ScreenSlidePagerActivity.urls[index][1])
                        .fitCenter()
                        .crossFade()
                        .listener(new RequestListener<String, GlideDrawable>() {
                            @Override
                            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                                return false;
                            }

                            @Override
                            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                                Log.e("B","bb");

                                new Thread(new Runnable() {
                                    public void run() {
                                        //wait, put here some sleep
                                        try {
                                            getActivity().runOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    photo.setVisibility(View.INVISIBLE);
                                                }
                                            });
                                            try {
                                                Thread.sleep(200);
                                            } catch (InterruptedException e) {
                                                e.printStackTrace();
                                            }
                                            getActivity().runOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    Log.e("TRIGGERED", "RUN ON UI THREAD");
                                                    mAttacher.update();

                                                }
                                            });
                                            try {
                                                Thread.sleep(100);
                                            } catch (InterruptedException e) {
                                                e.printStackTrace();
                                            }
                                            getActivity().runOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    Log.e("TRIGGERED", "RUN ON UI THREAD");
                                                    photo.setVisibility(View.VISIBLE);
                                                    //ScreenSlidePagerActivity.img[index ] = photo;
                                                    Log.e("PAGE", String.valueOf(index ));
                                                }
                                            });
                                        }catch(Exception e){
                                            Log.e("ERROR", e.toString());

                                        }
                                    }}).start();

                                Log.e("Procedure","Done");
                    /*
                    mAttacher.update();
                    photo.setVisibility(View.VISIBLE);
                    */

                                return false;
                            }
                        }).into(photo);

            }

            Log.e("A","aa");
            //Glide.with(this).load("https://static.pexels.com/photos/28221/pexels-photo-28221.jpg").into(photo);
            //Drawable myDrawable = getResources().getDrawable(R.drawable.four);

            //photo.setImageDrawable(myDrawable);
            return true;

        }catch (OutOfMemoryError oom){
            Toast.makeText(getActivity(), "OUT OF MEMORY DETECTED.", Toast.LENGTH_LONG).show();
            return false;
        }


    }
}
