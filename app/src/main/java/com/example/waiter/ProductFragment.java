package com.example.waiter;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.waiter.Api.Object;

import java.util.ArrayList;
import java.util.List;


public class ProductFragment extends Fragment {

    RecyclerView recyclerView;
    ProductFragment.AdapterProduct adapter;
    List<ProductGroup> values = new ArrayList<>();
    int row_index = -1;

    public ProductFragment() {
        // Required empty public constructor
    }


    public static ProductFragment newInstance(String param1, String param2) {
        ProductFragment fragment = new ProductFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product,container,false);
        recyclerView = (RecyclerView) view.findViewById(R.id.ProductList);
        setInitialData(1);
        adapter = new ProductFragment.AdapterProduct(getContext(), values);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 4);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        return view;
    }
    private void setInitialData(int eq){
        if(eq == 1){
            values.add(new ProductGroup("Борщ"));
            values.add(new ProductGroup("Грибной"));
            values.add(new ProductGroup("Гороховый"));
            values.add(new ProductGroup("Рассольник"));
        }
    }
    private static class AdapterProduct extends RecyclerView.Adapter<ProductFragment.ViewHolderProduct> {
        private final List<ProductGroup> names;
        private final LayoutInflater inflater;
        public Context context;
        AdapterProduct(Context context, List<ProductGroup> values) {
            this.names = values;
            this.inflater = LayoutInflater.from(context);
            this.context = context;
        }


        @NonNull
        @Override
        public ProductFragment.ViewHolderProduct onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new ProductFragment.ViewHolderProduct(LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.item_product, viewGroup, false));
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolderProduct holder, int position) {
            holder.bind(names.get(position));
        }


        @Override
        public int getItemCount() {
            return names.size();
        }
    }

    private static class ViewHolderProduct extends RecyclerView.ViewHolder {

        Object object;

        TextView text;

        CardView cardView;

        public ViewHolderProduct(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.it_product);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    text.setTextColor(Color.WHITE);
                    text.setBackgroundColor(Color.BLUE);
                }
            });


        }

        public void bind(ProductGroup object) {
            object = object;
            text.setText(object.getName());
        }
    }
}