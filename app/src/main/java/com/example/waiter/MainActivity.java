package com.example.waiter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.waiter.Api.Encoder;
import com.example.waiter.Api.MainApplication;
import com.example.waiter.Api.User;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.UUID;

import javax.security.auth.login.LoginException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//import com.example.waiter.Api.*;

public class MainActivity extends AppCompatActivity {
    public static boolean isOnline(Context context)
    {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting())
        {
            return true;
        }
        return false;
    }
    public static String token;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Вход");
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        Button entry = (Button) findViewById(R.id.entry);

        EditText text = (EditText)findViewById(R.id.password);
        setSupportActionBar(findViewById(R.id.mainToolBar));

        entry.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String password_waiter = "/";
                /*final String session_id = UUID.randomUUID().toString();
                try {
                    password_waiter = Encoder.Encryption(text.getText().toString());
                } catch (LoginException | NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
                User user = new User(password_waiter, session_id);
                MainApplication.apiManager.loginUser(user, new Callback<User>() {
                    @Override
                    public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {
                        User responseUser = response.body();
                        if (response.isSuccessful() && responseUser != null) {
                            token = responseUser.getToken();
                            Intent intent = new Intent(v.getContext(), GreetingActivity.class);
                            startActivity(intent);
                        } else {
                            Toast toast = Toast.makeText(MainActivity.this, "Ошибка подключения!",
                                    Toast.LENGTH_LONG);
                            toast.show();

                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<User> call, Throwable t) {
                        Toast toast = Toast.makeText(MainActivity.this, "Ошибка подключения: " + t,
                                Toast.LENGTH_LONG);
                        toast.show();
                    }

                });*/
                password_waiter = text.getText().toString();
                if(password_waiter.equals("8713")) {
                    Intent intent = new Intent(v.getContext(), GreetingActivity.class);
                    startActivity(intent);
                } else {
                    Toast toast = Toast.makeText(MainActivity.this, "Ошибка подключения!",
                            Toast.LENGTH_LONG);
                    toast.show();

                }
            }
        });

    }

}