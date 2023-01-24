package com.tatvic.ecommercetraining;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Cart extends AppCompatActivity {
    private RecyclerView recyclerView_cart;
    private CartAdapter cartAdapter;
    private ArrayList<ItemModel> item_list;
    private Button begin_checkout;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        recyclerView_cart = findViewById(R.id.rv_cart);
        begin_checkout = findViewById(R.id.begin_checkout);

        item_list = new ArrayList<>();
        item_list.add(new ItemModel("Mobile", "$ 299", R.drawable.iphone));
        item_list.add(new ItemModel("TV", "$ 1099", R.drawable.tv));
        item_list.add(new ItemModel("AC", "$ 299", R.drawable.ac));
        item_list.add(new ItemModel("Fridge", "$ 299", R.drawable.fridge));
        item_list.add(new ItemModel("Washing Machine", "$ 299", R.drawable.kindpng_2085518));


        cartAdapter = new CartAdapter(this, item_list);
        recyclerView_cart.setHasFixedSize(true);
        recyclerView_cart.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false));
        recyclerView_cart.setAdapter(cartAdapter);


        begin_checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Cart.this, ShippingAddress.class));
            }
        });

    }
}