package com.example.waiter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.waiter.Api.ExampleAdapter;
import com.example.waiter.Api.Object;
import com.example.waiter.Api.TableObj;

import java.util.ArrayList;
import java.util.List;

public class OrderedActivity extends AppCompatActivity {
    private static final String EXTRA_DATE = "OrderedActivity.EXTRA_DATE";
    private ArrayList<OrderGroup> mExampleList;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static void start(Context caller) {
        Intent intent = new Intent(caller, OrderedActivity.class);
        caller.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordered);
        setSupportActionBar(findViewById(R.id.mainToolBar));
        setTitle("");
        TextView title = (TextView) findViewById(R.id.title);
        title.setText("Заказ 1");
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragmentContainerView, MenuFragment.class, null)
                    .commit();

        }

        ImageButton btn_Kit = (ImageButton) findViewById(R.id.btnKit);
        btn_Kit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(OrderedActivity.this, "Заказ отправлен на кухню!",
                        Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();

            }
        });
        ImageButton btn_bck = (ImageButton) findViewById(R.id.btnBck);
        btn_bck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (savedInstanceState == null) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragmentContainerView, MenuFragment.class, null)
                            .addToBackStack(null)
                            .commit();
                }
                insertItem(1,"","");
            }
        });
        ImageButton btn_Prechek = (ImageButton) findViewById(R.id.btnPrechek);
        btn_Prechek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(OrderedActivity.this, "Заказ сформирован!",
                        Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();


            }
        });
        ImageButton btn_F = (ImageButton) findViewById(R.id.btnToF);
        btn_F.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), FinalActivity.class);
                startActivity(intent);

            }
        });
        createExampleList();
        buildRecyclerView();

    }
        public void insertItem(int position,String name,String price) {
            mExampleList.clear();
            mExampleList.add(0, new OrderGroup( "Грибной", "250.0"+ Html.fromHtml(" &#x20bd")));
            mExampleList.add(1, new OrderGroup( "Борщ", "365.0"+Html.fromHtml(" &#x20bd")));
            mAdapter.notifyDataSetChanged();
        }
        public void insertItem2(int position,String name,String price) {
            mExampleList.add(position,new OrderGroup( name, price));
            mAdapter.notifyItemInserted(position);
    }


        public void removeItem(int position) {
            mExampleList.remove(position);
            mAdapter.notifyItemRemoved(position);
        }

        public void createExampleList() {
            mExampleList = new ArrayList<>();
            mExampleList.add(new OrderGroup( "Название", "Цена"));
        }

        public void buildRecyclerView() {
            mRecyclerView = findViewById(R.id.recyclerView);
            mRecyclerView.setHasFixedSize(true);
            mLayoutManager = new LinearLayoutManager(this);
            mAdapter = new ExampleAdapter(mExampleList);

            mRecyclerView.setLayoutManager(mLayoutManager);
            mRecyclerView.setAdapter(mAdapter);
        }

    }
