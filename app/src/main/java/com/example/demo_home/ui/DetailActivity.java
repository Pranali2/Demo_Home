package com.example.demo_home.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.demo_home.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DetailActivity extends AppCompatActivity {
private ImageView MovieThunbnailImg,MovieCoverImg;
private TextView tv_title,tv_desc;
private FloatingActionButton play_fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        iniViews();



    }

    private void iniViews() {
        play_fab=findViewById(R.id.play_fab);
        String movieTitle=getIntent().getExtras().getString("title");
        int imageResourceId=getIntent().getExtras().getInt("imgURL");
        int imageCovereId=getIntent().getExtras().getInt("imgcover");
        MovieThunbnailImg=findViewById(R.id.detail_movie_img);
        MovieThunbnailImg.setImageResource(imageResourceId);
        Glide.with(this).load(imageResourceId).into(MovieThunbnailImg);

        MovieCoverImg=findViewById(R.id.detail_movie_cover);
        MovieCoverImg=findViewById(R.id.detail_movie_cover);
        MovieCoverImg.setImageResource(imageCovereId);
        Glide.with(this).load(imageCovereId).into(MovieCoverImg);



        tv_title=findViewById(R.id.detail_movie_title);
        tv_title.setText(movieTitle);
        getSupportActionBar().setTitle(movieTitle);
        tv_desc=findViewById(R.id.detail_movie_desc);
        MovieCoverImg.setAnimation(AnimationUtils.loadAnimation(this,R.anim.scale_animation));
        play_fab.setAnimation(AnimationUtils.loadAnimation(this,R.anim.scale_animation));
        play_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DetailActivity.this,Hope_audio_play.class);
                startActivity(intent);
            }
        });
    }

}
