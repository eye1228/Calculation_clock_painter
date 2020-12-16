package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class Clock extends AppCompatActivity {
    TextView Date;
    TextView Gre;
    UsedAsync asyncTask;
    ProgressHandler handler;


    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    String time = sdf.format(new Date(System.currentTimeMillis()));

    Calendar cal = new GregorianCalendar();
    public static Activity ClockActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);
        MainActivity MainActivity = (com.example.myapplication.MainActivity) com.example.myapplication.MainActivity.MainActivity;
        MainActivity.finish();
        Gre = (TextView)findViewById(R.id.Gre);

        handler = new ProgressHandler();

        runTime();

        ClockActivity = Clock.this;

        Button back_button = (Button)findViewById(R.id.back_btn2);//백 버튼
        back_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });

    }
    public void runTime()
    {
        Thread thread = new Thread(new Runnable()
        {
            @Override
            public void run(){
                while (true){
                    try{
                        time = sdf.format(new Date(System.currentTimeMillis()));

                        Message message = handler.obtainMessage();
                        handler.sendMessage(message);

                        Thread.sleep(1000);
                    }catch(InterruptedException e){}
                }
            }
        });
        thread.start();
        asyncTask = new UsedAsync();
        asyncTask.execute();
    }
    class ProgressHandler extends Handler {
        @Override
        public void handleMessage(Message msg){
            //Date.setText("");
        }
    }
    class UsedAsync extends AsyncTask<Integer, Integer, Integer>{
        Calendar cal;
        String timeGre;
        @Override
        protected Integer doInBackground(Integer...params)
        {
            while(isCancelled() == false)
            {
                cal = new GregorianCalendar();

                if(cal.get(Calendar.HOUR) < 10)
                {
                    if(cal.get(Calendar.MINUTE) < 10)
                    {
                        if(cal.get(Calendar.SECOND) < 10)
                        {
                            timeGre = String.format("%d : %d : %d \n 0%d : 0%d : 0%d", cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DATE), cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND));
                        }
                        else
                        {
                            timeGre = String.format("%d : %d : %d \n 0%d : 0%d : %d", cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DATE), cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND));
                        }
                    }
                    else
                    {
                        if(cal.get(Calendar.SECOND) < 10)
                        {
                            timeGre = String.format("%d : %d : %d \n 0%d : %d : 0%d", cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DATE), cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND));
                        }
                        else
                        {
                            timeGre = String.format("%d : %d : %d \n 0%d : %d : %d", cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DATE), cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND));
                        }
                    }
                }
                else
                {
                    if(cal.get(Calendar.MINUTE) < 10)
                    {
                        if(cal.get(Calendar.SECOND) < 10)
                        {
                            timeGre = String.format("%d : %d : %d \n %d : 0%d : 0%d", cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DATE), cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND));
                        }
                        else
                        {
                            timeGre = String.format("%d : %d : %d \n %d : 0%d : %d", cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DATE), cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND));
                        }
                    }
                    else
                    {
                        if(cal.get(Calendar.SECOND) < 10)
                        {
                            timeGre = String.format("%d : %d : %d \n %d : %d : 0%d", cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DATE), cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND));
                        }
                        else
                        {
                            timeGre = String.format("%d : %d : %d \n %d : %d : %d", cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DATE), cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND));
                        }
                    }
                }
                publishProgress();
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){}
            }
            return null;
        }
        @Override
        protected void onPreExecute()
        {
            cal = new GregorianCalendar();
            timeGre = String.format("%d%d%d %d:%d:%d", cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND));
            Gre.setText(timeGre);

            super.onPreExecute();
        }
        @Override
        protected void onPostExecute(Integer integer)
        {
            super.onPostExecute(integer);
        }
        @Override
        protected  void onProgressUpdate(Integer...values)
        {
            Gre.setText(timeGre);
            super.onProgressUpdate();
        }
    }
}
