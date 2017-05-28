package com.leonardoabrilbejarano.mygallery;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by leillo on 28/05/2017.
 */

public class MyGalleryManager {
    private ArrayList data;
    private Context ctx;

    public MyGalleryManager(Context ctx){
        data = new ArrayList();
        this.ctx = ctx;
    }


    public void pushImage(String name, String url){
        String [] datarow = new String [2];
        datarow[0] = name;
        datarow[1] = url;
        data.add(datarow);
    }

    public ArrayList gerImage(){
        return data;
    }

    public void removeImage(int i){
        data.remove(i);
    }

    public void removeALL(){
        data.clear();
    }

    public void LoadGallery(){
        ScreenSlidePagerActivity.urls = new String[data.size()][2];
        for(int i = 0; i < data.size();i++){
            String [] datarow = (String[]) data.get(i);
            ScreenSlidePagerActivity.urls[i][0] = datarow[0];
            ScreenSlidePagerActivity.urls[i][1] = datarow[1];
            Log.e("Name", ScreenSlidePagerActivity.urls[i][0] + "Value" + ScreenSlidePagerActivity.urls[i][1]);
        }
        Intent intent = new Intent(ctx, ScreenSlidePagerActivity.class);
        ctx.startActivity(intent);
    }
}
