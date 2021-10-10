package com.edu.calarea;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView logo, lottieAnim;
    View box, wave;
    ScrollView mainScroll;
    CardView circle, triangle, square, rectangle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind variables with xml components
        logo = findViewById(R.id.logo);
        lottieAnim = findViewById(R.id.lottie_anim);
        box = findViewById(R.id.splash_bg_view);
        wave = findViewById(R.id.splash_bg_view_wave);
        mainScroll = findViewById(R.id.scroll_main);
        circle = findViewById(R.id.card_circle);
        triangle = findViewById(R.id.card_triangle);
        square = findViewById(R.id.card_square);
        rectangle = findViewById(R.id.card_rectangle);

        box.animate().translationY(-1600).setDuration(1000).setStartDelay(2000);
        wave.animate().translationY(-1600).setDuration(1000).setStartDelay(2000);
        lottieAnim.animate().translationY(1700).setDuration(1000).setStartDelay(2000);
        logo.animate().translationY(2000).setDuration(1000).setStartDelay(2000);

        //Make scroll view visibility visible after 6 seconds
        mainScroll.postDelayed(new Runnable() {
            @Override
            public void run() {
                mainScroll.setVisibility(View.VISIBLE);
            }
        }, 3000);

        //Click functions
        circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCirclePage();
            }
        });

        triangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTrianglePage();
            }
        });

        rectangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRectanlgePage();
            }
        });

        square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSquarePage();
            }
        });
    }

    public void openCirclePage(){
        Intent circle = new Intent(this, circle_page.class);
        startActivity(circle);
    }

    public void openTrianglePage(){
        Intent triangle = new Intent(this, triangle_page.class);
        startActivity(triangle);
    }

    public void openSquarePage(){
        Intent square = new Intent(this, square_page.class);
        startActivity(square);
    }

    public void openRectanlgePage(){
        Intent rectangle = new Intent(this, rectangle_page.class);
        startActivity(rectangle);
    }
}