package com.example.marketapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements ItemClickListener {
    RecyclerView myrecyclerview;
    List<ItemClass> itemlist;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        myrecyclerview=findViewById(R.id.recycleView);
        itemlist=new ArrayList<>();
        itemlist.add(new ItemClass(R.drawable.fruits,"Fruits","Fresh fruits from the garden"));
        itemlist.add(new ItemClass(R.drawable.vegetables,"Vegetables","Delicious vegetables from the farm"));
        itemlist.add(new ItemClass(R.drawable.bread,"Bread","Freshly Baked Bread"));
        itemlist.add(new ItemClass(R.drawable.beverage,"Beverages","Chilling Beverages from the farm"));
        itemlist.add(new ItemClass(R.drawable.milk,"Milk","Freshly extracted milk"));
        itemlist.add(new ItemClass(R.drawable.popcorn,"Popcorn","Popcorn, Donuts, Soft Drinks"));

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        myrecyclerview.setLayoutManager(layoutManager);

        RecycleAdapter adapter = new RecycleAdapter(itemlist);
        myrecyclerview.setAdapter(adapter);

        adapter.setOnItemClickListener(this);


    }

    @Override
    public void onClick(View v, int position) {
        Toast.makeText(this,"You Choose "+ itemlist.get(position).getItemname(),Toast.LENGTH_LONG).show();

    }
}