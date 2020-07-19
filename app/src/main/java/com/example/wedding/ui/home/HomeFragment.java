package com.example.wedding.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.wedding.DekorasiActivity;
import com.example.wedding.MakeUpActivity;
import com.example.wedding.R;
import com.example.wedding.SouvenirActivity;
import com.example.wedding.UndanganActivity;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class HomeFragment extends Fragment {


    private int[] mImage = new int[]{ R.drawable.gambar1, R.drawable.gambar2, R.drawable.echadekor,R.drawable.mua_tradisional};


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_home, container, false);
        CardView cardview_1 = view.findViewById(R.id.cardview_1);
        CardView cardview_2 =  view.findViewById(R.id.cardview_2);
        CardView cardview_3 = view.findViewById(R.id.cardview_3);
        CardView cardview_4 = view.findViewById(R.id.cardview_4);

        cardview_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(getActivity(), DekorasiActivity.class);
                a.putExtra("Dekorasi", "cardview_1");
                startActivity(a);
            }
        });

        cardview_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(getActivity(), MakeUpActivity.class);
                a.putExtra("Make Up", "cardview_2");
                startActivity(a);
            }
        });
        cardview_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(getActivity(), UndanganActivity.class);
                a.putExtra("Undangan", "cardview_3");
                startActivity(a);
            }
        });

        cardview_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(getActivity(), SouvenirActivity.class);
                a.putExtra("Souvenir", "cardview_4");
                startActivity(a);
            }
        });

        CarouselView carouselView = view.findViewById(R.id.carousel);

        carouselView.setPageCount(mImage.length);
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(mImage[position]);
            }
        });



        return view;
    }


}