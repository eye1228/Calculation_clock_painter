package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class Picture extends AppCompatActivity {
    private SingleTouchView drawView;
    private ImageButton currPaint;
    //private LinearLayout capture;
    LinearLayout paintLayout;

    public static Activity PictureActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);
        drawView = (com.example.myapplication.SingleTouchView)findViewById(R.id.drawing);
        paintLayout = (LinearLayout)findViewById(R.id.paint_colors);
        currPaint = (ImageButton)paintLayout.getChildAt(0);
        PictureActivity = Picture.this;
        //MainActivity MainActivity = (com.example.myapplication.MainActivity) com.example.myapplication.MainActivity.MainActivity;
        //MainActivity.finish();
    }
    public void clicked(View view){
        if(view != currPaint){
            String color = view.getTag().toString();
            drawView.setColor(color);
            currPaint = (ImageButton)view;
        }
    }
    public void clearclicked(View view)
    {
        drawView.resetCanvas();
    }
    public void erased(View view)
    {
        //색 버튼 잠금
        ImageButton colorB = (ImageButton)findViewById(R.id.colorB);
        ImageButton colorR = (ImageButton)findViewById(R.id.colorR);
        ImageButton colorO = (ImageButton)findViewById(R.id.colorO);
        ImageButton colorG = (ImageButton)findViewById(R.id.colorG);
        ImageButton colorY = (ImageButton)findViewById(R.id.colorY);
        ImageButton colorW = (ImageButton)findViewById(R.id.colorW);
        colorB.setEnabled(false);
        colorR.setEnabled(false);
        colorO.setEnabled(false);
        colorG.setEnabled(false);
        colorY.setEnabled(false);
        colorW.setEnabled(false);
        if(view != currPaint){//여기는 색 흰색으로 ㅎㅎ
            String color = view.getTag().toString();
            drawView.setColor(color);
            currPaint = (ImageButton)paintLayout.getChildAt(0);
        }
    }
    public void draw(View view)
    {
        ImageButton colorB = (ImageButton)findViewById(R.id.colorB);
        ImageButton colorR = (ImageButton)findViewById(R.id.colorR);
        ImageButton colorO = (ImageButton)findViewById(R.id.colorO);
        ImageButton colorG = (ImageButton)findViewById(R.id.colorG);
        ImageButton colorY = (ImageButton)findViewById(R.id.colorY);
        ImageButton colorW = (ImageButton)findViewById(R.id.colorW);
        colorB.setEnabled(true);
        colorR.setEnabled(true);
        colorO.setEnabled(true);
        colorG.setEnabled(true);
        colorY.setEnabled(true);
        colorW.setEnabled(true);
        if(view != currPaint){//여기는 색 흰색으로 ㅎㅎ
            String color = view.getTag().toString();
            drawView.setColor(color);
        }
    }
    public void big_click(View view)
    {
        drawView.setPaint(20f);
    }
    public void small_click(View view)
    {
        drawView.setPaint(10f);
    }

    public void back_click(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }
}

