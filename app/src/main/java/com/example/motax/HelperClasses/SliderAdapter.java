package com.example.motax.HelperClasses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.example.motax.R;

/**
 * Created by QuocKM on 12,November,2020
 * EbizWorld company,
 * HCMCity, VietNam.
 */
public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context = context;
    }

    int images[]={
            R.drawable.logobig,
            R.drawable.map,
            R.drawable.wallet
    };

    int headings[]={
            R.string.heading1,
            R.string.heading2,
            R.string.heading3,
    };

    int details[]={
            R.string.detail1,
            R.string.detail2,
            R.string.detail3
    };
    @Override
    public int getCount() {
        return headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (ConstraintLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout,container,false);

        //Hooks
        ImageView imageView = view.findViewById(R.id.slider_imgView);
        TextView heading = view.findViewById(R.id.slider_txtHeader);
        TextView detail = view.findViewById(R.id.slider_txtDetails);

        imageView.setImageResource(images[position]);
        heading.setText(headings[position]);
        detail.setText(details[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
