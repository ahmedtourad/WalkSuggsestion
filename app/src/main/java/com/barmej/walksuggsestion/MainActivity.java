package com.barmej.walksuggsestion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final String BUNDLE_CURRENT_INDEX = "BUNDLE_CURRENT_INDEX";
int[] mWalkingPirectures = {
       R.drawable.park,
        R.drawable.bike,
        R.drawable.football,
        R.drawable.museum,
        R.drawable.beach,
        R.drawable.restaurant,
        R.drawable.running,
        R.drawable.shop,
        R.drawable.swimming,
        R.drawable.walking,


};
int mCurrentIndex = 0;
ImageView imageWalking;
private Random mRandom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRandom = new Random();
        imageWalking = findViewById(R.id.imageView);
    }
    public void showImage(){
        Drawable image = getDrawable(mWalkingPirectures[mCurrentIndex]);
        imageWalking.setImageDrawable(image);
    }
    public void display(View view){

        mCurrentIndex = mRandom.nextInt(10);
        showImage();
    }
    public void next(View view){
        if(mCurrentIndex < 10) {
            mCurrentIndex++;
            showImage();
        }else{
            mCurrentIndex = 0;
            showImage();
        }
    }
    public void pevrious(View view){
        if(mCurrentIndex ==0) {
            mCurrentIndex=9;
            showImage();
        }else{
            --mCurrentIndex;
            showImage();
        }
        }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(BUNDLE_CURRENT_INDEX,mCurrentIndex);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState != null){
            mCurrentIndex =savedInstanceState.getInt(BUNDLE_CURRENT_INDEX, mCurrentIndex);
            showImage();
        }
    }
}
