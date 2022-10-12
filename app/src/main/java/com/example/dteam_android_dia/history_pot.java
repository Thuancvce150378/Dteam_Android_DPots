package com.example.dteam_android_dia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class history_pot extends AppCompatActivity {
    ImageButton imgmenu;
    TextView txtMenu;
    MenuBuilder menuBuilder;
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_pot);
        imgmenu = findViewById(R.id.img_btn_vert);
//        txtMenu = findViewById(R.id.txtMenu);

        menuBuilder = new MenuBuilder(this);
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.popupmenu_historypot, menuBuilder);

        imgmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu(menuBuilder,view);
            }
        });

    }

    @SuppressLint("RestrictedApi")
    public void PopupMenu(MenuBuilder a, View view){
        @SuppressLint("RestrictedApi") MenuPopupHelper optionMenu = new MenuPopupHelper(this, a,view);
        optionMenu.setForceShowIcon(true);
        menuBuilder.setCallback(new MenuBuilder.Callback() {
            @Override
            public boolean onMenuItemSelected(@NonNull MenuBuilder menu, @NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_edit:
                        txtMenu.setText("Click Edit");
                        return true;
                    case R.id.menu_remove:
                        txtMenu.setText("Click Remove");
                        return true;
                    default:
                        return false;
                }
            }

            @Override
            public void onMenuModeChange(@NonNull MenuBuilder menu) {

            }
        });
        optionMenu.show();
    }
}