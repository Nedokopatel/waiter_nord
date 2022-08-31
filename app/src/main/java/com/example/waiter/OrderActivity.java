package com.example.waiter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.waiter.Api.ApiService;
import com.example.waiter.Api.MenuFull;
import com.example.waiter.Api.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderActivity extends AppCompatActivity {
    private Menu menu;
    private String token;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        setTitle("");
        setSupportActionBar(findViewById(R.id.mainToolBar));
        //this.menu = menu;
                /*token = MainActivity.token;
                ApiService.getInstance()
                        .getJSONApi()
                        .getMenu(token)
                        .enqueue(new Callback<MenuFull>() {
                            @Override
                            public void onResponse(@NonNull Call<MenuFull> call, @NonNull Response<MenuFull> response) {
                                MenuFull menu = response.body();


                            }

                            @Override
                            public void onFailure(@NonNull Call<MenuFull> call, @NonNull Throwable t) {

                                t.printStackTrace();
                            }
                        });*/

        ImageButton addButton = (ImageButton) findViewById(R.id.addButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), TableActivity.class);
                startActivity(intent);

            }
        });
    }

}