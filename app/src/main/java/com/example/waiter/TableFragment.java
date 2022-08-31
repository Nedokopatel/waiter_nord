package com.example.waiter;

import static com.example.waiter.MainActivity.token;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.waiter.Api.ApiService;
import com.example.waiter.Api.Area;
import com.example.waiter.Api.AreaList;
import com.example.waiter.Api.MenuFull;
import com.example.waiter.Api.Object;
import com.example.waiter.Api.ObjectList;
import com.example.waiter.ApiMet.GetArea;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TableFragment extends Fragment {
    private String token;
    static public TextView textView;
    RecyclerView recyclerView;
    //Adapter adapter;
    //List<Object> values;

    public TableFragment() {
        super(R.layout.fragment_table);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
                /*TextView textView = view.findViewById(R.id.textView2);
                textView.setText(GetArea.message);
                recyclerView = view.findViewById(R.id.list);

                GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter);*/


    }
}


