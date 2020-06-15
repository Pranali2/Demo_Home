package com.example.demo_home.Adapter;

import android.widget.ImageView;

import com.example.demo_home.model.Movie;

public interface MovieItemClickListner {
    void onMovieClick(Movie movie, ImageView movieImageView);
}
