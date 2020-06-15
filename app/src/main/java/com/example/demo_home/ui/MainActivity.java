package com.example.demo_home.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.demo_home.Adapter.MovieAdapter;
import com.example.demo_home.model.Movie;
import com.example.demo_home.Adapter.MovieItemClickListner;
import com.example.demo_home.R;
import com.example.demo_home.model.Slide;
import com.example.demo_home.Adapter.SliderPageAdapter;
import com.example.demo_home.utils.DataSource;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements MovieItemClickListner {
private List<Slide> lstslides;
private ViewPager sliderpage;
private TabLayout  indicator;
private RecyclerView MovieRv, movieRVWeek,movierVWeekTop;
FloatingActionButton floatingActionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sliderpage=findViewById(R.id.slider_pager);
        indicator=findViewById(R.id.indicator);
        MovieRv=findViewById(R.id.Rv_movies);
        movieRVWeek=findViewById(R.id.Rv_movies_week);
        movierVWeekTop=findViewById(R.id.Rv_movies_week_top);
       /* floatingActionButton=findViewById(R.id.floatingActionButton2);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Hope_movie_play.class);
                startActivity(intent);
            }
        });*/

        inSlider();

        iniPopularMovies();
        iniWeekMoviez();
        iniWeekMovieTop();
    }

    private void iniWeekMovieTop() {

        MovieAdapter weekmovieAdapter=new MovieAdapter(this,DataSource.getWeekMovies(),this);
        movierVWeekTop.setAdapter(weekmovieAdapter);
        movierVWeekTop.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }

    private void iniWeekMoviez() {
        MovieAdapter weekmovieAdapter=new MovieAdapter(this,DataSource.getWeekMoviesTop(),this);
        movieRVWeek.setAdapter(weekmovieAdapter);
        movieRVWeek.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }

    private void iniPopularMovies() {
   
        MovieAdapter movieAdapter=new MovieAdapter(this, DataSource.getPopularMovies(),this);
        MovieRv.setAdapter(movieAdapter);
        MovieRv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }

    private void inSlider() {
        lstslides=new ArrayList<>();
        lstslides.add(new Slide(R.drawable.h1,"Slide Title \nmore text here"));
        lstslides.add(new Slide(R.drawable.h2,"Slide Title \nmore text here"));
        lstslides.add(new Slide(R.drawable.h3,"Slide Title \nmore text here"));
        lstslides.add(new Slide(R.drawable.h4,"Slide Title \nmore text here"));
        lstslides.add(new Slide(R.drawable.h5,"Slide Title \nmore text here"));

        SliderPageAdapter sliderPageAdapter=new SliderPageAdapter(this,lstslides);
        sliderpage.setAdapter(sliderPageAdapter);

        Timer timer=new Timer();
        timer.scheduleAtFixedRate(new SliderTimer(),4000,6000);
        indicator.setupWithViewPager(sliderpage,true);
    }

    @Override
    public void onMovieClick(Movie movie, ImageView movieImageView) {
        Intent intent=new Intent(this, DetailActivity.class);
        intent.putExtra("title",movie.getTitle());
        intent.putExtra("imgURL",movie.getThumbnail());
        intent.putExtra("imgcover",movie.getCoverphoto());

        ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,movieImageView,"sharedName");
        startActivity(intent,options.toBundle());

       // Toast.makeText(this, "Item Clicked  "+ movie.getTitle(), Toast.LENGTH_SHORT).show();
    }

    class SliderTimer extends TimerTask{
        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (sliderpage.getCurrentItem()<lstslides.size()-1){
                        sliderpage.setCurrentItem(sliderpage.getCurrentItem()+1);
                    }else
                    {
                        sliderpage.setCurrentItem(0);
                    }
                }
            });
        }
    }
    public void play_video(View view){
        startActivity(new Intent(getApplicationContext(),Hope_movie_play.class));
    }
}
