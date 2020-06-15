package com.example.demo_home.utils;

import com.example.demo_home.model.Movie;
import com.example.demo_home.R;

import java.util.ArrayList;
import java.util.List;

public class DataSource {
    public static List<Movie> getPopularMovies(){
        List<Movie> lsMovies=new ArrayList<>();
        lsMovies.add(new Movie("Tanhaji", R.drawable.m5,R.drawable.m5));
        lsMovies.add(new Movie("Rabta",R.drawable.m6,R.drawable.m6));
        lsMovies.add(new Movie("Good News",R.drawable.m7,R.drawable.m7));
        lsMovies.add(new Movie("Uri",R.drawable.m8,R.drawable.m8));
        lsMovies.add(new Movie("Prashanam",R.drawable.m9,R.drawable.m9));
        return  lsMovies;
    }
    public static List<Movie> getWeekMovies(){
        List<Movie> lsMovies=new ArrayList<>();
        lsMovies.add(new Movie("Baagi3", R.drawable.m10,R.drawable.m10));
        lsMovies.add(new Movie("Super30",R.drawable.m11,R.drawable.m11));
        lsMovies.add(new Movie("Heros",R.drawable.m12,R.drawable.m12));
        lsMovies.add(new Movie("Uri",R.drawable.m8,R.drawable.m8));
        lsMovies.add(new Movie("Prashanam",R.drawable.m9,R.drawable.m9));
        return  lsMovies;
    }
    public static List<Movie> getWeekMoviesTop(){
        List<Movie> lsMovies=new ArrayList<>();
        lsMovies.add(new Movie("Mantera", R.drawable.r1,R.drawable.r1));
        lsMovies.add(new Movie("The Conjuring",R.drawable.r2,R.drawable.r2));
        lsMovies.add(new Movie("Ghost",R.drawable.r3,R.drawable.r3));
        lsMovies.add(new Movie("Mission Mangal",R.drawable.r4,R.drawable.r4));
        lsMovies.add(new Movie("Prashanam",R.drawable.r5,R.drawable.r5));
        return  lsMovies;
    }
}
