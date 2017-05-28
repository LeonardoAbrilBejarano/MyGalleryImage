package com.leonardoabrilbejarano.mygallery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.leonardoabrilbejarano.mygallery.util.FakeR;

public class MainActivity extends AppCompatActivity {
private FakeR fakeR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		fakeR = new FakeR(this);
        setContentView(fakeR.getId("layout", "activity_main"));

    }

    public void initslide(View view){
        MyGalleryManager gm = new MyGalleryManager(this);
        for(int i =0; i<10;i++) {
            gm.pushImage("IMAGE 1", "https://www.qdtricks.net/wp-content/uploads/2016/05/latest-1080-wallpaper.jpg");
        }
        gm.LoadGallery();
        //Intent intent = new Intent(this, ScreenSlidePagerActivity.class);
        //startActivity(intent);
    }
}
