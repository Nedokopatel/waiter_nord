package com.example.waiter.ApiMet;

import androidx.annotation.NonNull;

import com.example.waiter.Api.ApiService;
import com.example.waiter.Api.Area;
import com.example.waiter.Api.AreaList;
import com.example.waiter.TableFragment;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetArea {
private String token;
public static String message;
public List<Area> values;
public GetArea(String token){
    this.token = token;
    ApiService.getInstance()
            .getJSONApi()
            .getArea(token)
            .enqueue(new Callback<AreaList>() {
                @Override
                public void onResponse(@NonNull Call<AreaList> call, @NonNull Response<AreaList> response) {
                    AreaList objectList = response.body();
                    List<Area> objects = new ArrayList<>();
                    values = objectList.getArea();
                    message = values.get(0).getName();


                }

                @Override
                public void onFailure(@NonNull Call<AreaList> call, @NonNull Throwable t) {

                    message = "Error occurred while getting request!";
                    t.printStackTrace();
                }
            });
}
}
