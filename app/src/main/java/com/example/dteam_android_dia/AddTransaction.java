package com.example.dteam_android_dia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class AddTransaction extends AppCompatActivity {
    ImageView arrow;
    LinearLayout hiddenView;
    CardView cardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_transaction);
        cardView = findViewById(R.id.base_cardview);
        arrow = findViewById(R.id.ImgGroupItem);
        hiddenView = findViewById(R.id.hidden_view);

        arrow.setOnClickListener(view -> {

            if (hiddenView.getVisibility() == View.VISIBLE) {

                TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                hiddenView.setVisibility(View.GONE);
//                arrow.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24);
            }


            else {
                TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                hiddenView.setVisibility(View.VISIBLE);
//                arrow.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24);
            }
        });
    }
}