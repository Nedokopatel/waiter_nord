package com.example.waiter;

import static com.example.waiter.MainActivity.token;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.waiter.Api.ApiService;
import com.example.waiter.Api.AreaList;
import com.example.waiter.Api.Object;
import com.example.waiter.Api.ObjectList;
import com.example.waiter.Api.TableObj;
import com.example.waiter.ApiMet.GetArea;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TableActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Adapter adapter;
    List<TableObj> values = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        setTitle("");
        setSupportActionBar(findViewById(R.id.mainToolBar));
        ImageButton tableArea = (ImageButton) findViewById(R.id.areaTable);
        tableArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(TableActivity.this, tableArea);
                //Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.popup_menu, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(
                                TableActivity.this,
                                "You Clicked : " + item.getTitle(),
                                Toast.LENGTH_SHORT
                        ).show();
                        return true;
                    }

                });

                popup.show(); //showing popup menu
            }
        });

        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText("Зал Season");
        recyclerView = (RecyclerView) findViewById(R.id.list);
        setInitialData();
        adapter = new Adapter(this,values);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 4);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


        /*ApiService.getInstance()
                .getJSONApi()
                .getObject(MainActivity.token)
                .enqueue(new Callback<ObjectList>() {
                    @Override
                    public void onResponse(@NonNull Call<ObjectList> call, @NonNull Response<ObjectList> response) {
                        ObjectList objectList = response.body();

                        List<Object> values = objectList.getObject();
                        adapter.setNameObject(values);
                        //message = values.get(0).getName();


                    }

                    @Override
                    public void onFailure(@NonNull Call<ObjectList> call, @NonNull Throwable t) {

                        //message = "Error occurred while getting request!";
                        t.printStackTrace();
                    }
                });*/


    }
    private void setInitialData(){
        values.add(new TableObj("Стол 1"));
        values.add(new TableObj("Стол 2"));
        values.add(new TableObj("Стол 3"));
        values.add(new TableObj("Стол 4"));
    }
    private static class Adapter extends RecyclerView.Adapter<ViewHolder> {
        private final List<TableObj> names;
        private final LayoutInflater inflater;

        Adapter(Context context, List<TableObj> values) {
            this.names = values;
            this.inflater = LayoutInflater.from(context);
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new ViewHolder(LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.item_table, viewGroup, false));
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
            viewHolder.bind(names.get(i));
        }

        @Override
        public int getItemCount() {
            return names.size();
        }
    }

    private static class ViewHolder extends RecyclerView.ViewHolder {

        Object object;

        TextView text;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.text);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    OrderedActivity.start(view.getContext());
                    /*Intent intent = new Intent(view.getContext(), OrderedActivity.class);
                    startActivity(intent);*/
                }
            });
        }

        public void bind(TableObj object) {
            object = object;
            text.setText(object.getName());
        }
    }
}