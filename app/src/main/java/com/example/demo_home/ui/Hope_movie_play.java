package com.example.demo_home.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.example.demo_home.R;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;

public class Hope_movie_play extends AppCompatActivity {
SimpleExoPlayerView simpleExoPlayerView;
SimpleExoPlayer simpleExoPlayer;
String videourl="https://www.radiantmediaplayer.com/media/bbb-360p.mp4";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setFullScreen();

        setContentView(R.layout.activity_hope_movie_play);
        simpleExoPlayerView=findViewById(R.id.simple_exo);
        hideActionBar();

        try{
            BandwidthMeter bandwidthMeter=new DefaultBandwidthMeter();
            TrackSelector trackSelector=new DefaultTrackSelector(new AdaptiveTrackSelection.Factory(bandwidthMeter));
            simpleExoPlayer= ExoPlayerFactory.newSimpleInstance(this,trackSelector);
            Uri video=Uri.parse(videourl);
            DefaultHttpDataSourceFactory dataSourceFactory=new DefaultHttpDataSourceFactory("exoplayer_video");
            ExtractorsFactory extractorsFactory=new DefaultExtractorsFactory();
            MediaSource mediaSource=new ExtractorMediaSource(video,dataSourceFactory,extractorsFactory,null,null);
            simpleExoPlayerView.setPlayer(simpleExoPlayer);
            simpleExoPlayer.prepare(mediaSource);
            simpleExoPlayer.setPlayWhenReady(true);
        }catch (Exception e){
            Log.e("Hope_movie_play","error"+e.toString());
        }
    }

   private void hideActionBar() {

        getSupportActionBar().hide();
    }

    private void setFullScreen() {

            requestWindowFeature(Window.FEATURE_NO_TITLE);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        simpleExoPlayer.release();
    }
}
