package com.nguyentanphat.multi_thread_ex1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.nguyentanphat.multi_thread_ex1.databinding.ActivityMainBinding;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    Random random = new Random();

    //Main/UI - Thread
    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            int percent = msg.arg1;
            int randNumb = (int) msg.obj;
            binding.txtPercent.setText(percent + " %");
            binding.pbPercent.setProgress(percent);

            //ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(new ViewGroup.LayoutParams(200, ViewGroup.LayoutParams.WRAP_CONTENT));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(200,ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(15, 15, 15 ,15);
//            ImageView imv = new ImageView(MainActivity.this);
//            imv.setLayoutParams(params);
//
//            binding.containerLayout.addView(imv);
//
//            if(randNumb % 2 == 0)
//                imv.setImageDrawable(getDrawable(R.drawable.baseline_360_24));
//            else
//                imv.setImageDrawable(getDrawable(R.drawable.baseline_accessibility_24));
//
//
//            binding.containerLayout.addView(imv);

            Button button = new Button(MainActivity.this);
            button.setLayoutParams(params);
            button.setTextSize(24);
            button.setTextColor(Color.WHITE);

            button.setText(String.valueOf(randNumb));

            if(randNumb % 2 == 0){
                button.setBackgroundColor(Color.rgb(255,0,255));
            }else
                button.setBackgroundColor(Color.rgb(255,87,34));
            binding.containerLayout.addView(button);

            if(percent == 100)
                binding.txtPercent.setText("Done");

            return false;
        }
    });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addEvents();
    }

    private void addEvents() {
        binding.btnDraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                draw();
            }
        });
    }

    private void draw() {
        binding.containerLayout.removeAllViews();
        //Background/Worker - thread
        int numbOfView = Integer.parseInt(binding.edtNumbOfViews.getText().toString());
        Thread backgroundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1 ; i <= numbOfView ; i++){
                    Message message = handler.obtainMessage();

                    message.arg1 = i*100/numbOfView; //percent
                    message.obj = random.nextInt(100); //Random number
                    handler.sendMessage(message);
                    SystemClock.sleep(100);
                }
            }
        });
        backgroundThread.start();
    }
}