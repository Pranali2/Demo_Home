package com.example.demo_home.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demo_home.R;

public class Hope_audio_play extends AppCompatActivity {
private ImageView imagePlay;
private TextView txtCurrentTime,txtTotalTime;
private SeekBar seekBar;
private MediaPlayer mediaPlayer;
private Handler handler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hope_audio_play);
        imagePlay=findViewById(R.id.Audio_play);
        txtCurrentTime=findViewById(R.id.currentTime);
        txtTotalTime=findViewById(R.id.totalduration);
        seekBar=findViewById(R.id.playerSeekbar);
        mediaPlayer=new MediaPlayer();
        seekBar.setMax(100);
        imagePlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()){
                    handler.removeCallbacks(updater);
                    mediaPlayer.pause();
                    imagePlay.setImageResource(R.drawable.ic_play_new);
                }else{
                    mediaPlayer.start();
                    imagePlay.setImageResource(R.drawable.ic_pause_new);
                    updateSeekbar();
                }

            }
        });
        PrepareMedia();
        seekBar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                SeekBar seekBar=(SeekBar) v;
                int playPosition=(mediaPlayer.getDuration()/100)*seekBar.getProgress();
                mediaPlayer.seekTo(playPosition);
                txtCurrentTime.setText(milisecondToTimer(mediaPlayer.getCurrentPosition()));
                return false;
            }
        });
    }
    private void PrepareMedia(){
        try{
            mediaPlayer.setDataSource("http://infinityandroid.com/music/good_times.mp3");
            mediaPlayer.prepare();
            txtTotalTime.setText(milisecondToTimer(mediaPlayer.getDuration()));

        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    private Runnable updater=new Runnable() {
        @Override
        public void run() {
            updateSeekbar();
            long cueerntDuration=mediaPlayer.getCurrentPosition();
            txtCurrentTime.setText(milisecondToTimer(cueerntDuration));
        }
    };
    private  void updateSeekbar(){
        if (mediaPlayer.isPlaying()){
            seekBar.setProgress((int)(((float)mediaPlayer.getCurrentPosition() / mediaPlayer.getDuration()) * 100));
            handler.postDelayed(updater,1000);
        }
    }
    private String milisecondToTimer(long milisecond){
        String timerString= "";
        String secondString;
        int hr=(int)(milisecond / (1000 * 60 * 60));
        int minr=(int)(milisecond % (1000 * 60 * 60)) / (1000 * 60);
        int sec=(int)((milisecond % (1000 * 60 * 60)) % (1000 * 60) / 1000);
        if(hr > 0){
           timerString= hr + ":";
        }
        if (sec < 10){
            secondString= "0" + sec;
        }else {
            secondString= "" + sec;
        }
        timerString = timerString + minr + ":" + secondString;
        return timerString;
    }
}
