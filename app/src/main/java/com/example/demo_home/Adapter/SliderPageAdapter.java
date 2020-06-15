package com.example.demo_home.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.demo_home.R;
import com.example.demo_home.model.Slide;

import java.util.List;

public class SliderPageAdapter extends PagerAdapter {
private Context mcontext;
private List<Slide> mList;

    public SliderPageAdapter(Context mcontext, List<Slide> mList) {
        this.mcontext = mcontext;
        this.mList = mList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater=(LayoutInflater)mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View slideLayout=inflater.inflate(R.layout.slide_item,null);
        ImageView slideImg=slideLayout.findViewById(R.id.slide_image);
        TextView slideText=slideLayout.findViewById(R.id.slide_item);
        slideImg.setImageResource(mList.get(position).getImage());
        slideText.setText(mList.get(position).getTitle());
        container.addView(slideLayout);
        return slideLayout;







    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view ==object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
       container.removeView((View)object);
    }
}
