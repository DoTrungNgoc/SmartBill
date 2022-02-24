package com.example.tolbill.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.example.tolbill.R;
import com.example.tolbill.app.ItemAdapter;
import com.example.tolbill.model.Bill;
import com.example.tolbill.model.Item;

import java.util.LinkedList;

public class Activity_update extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private Bill bill;
    private EditText edtAdress, edtDate, edtTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        edtAdress = findViewById(R.id.editTextAdress);
        edtDate = findViewById(R.id.editTextDate);
        edtTotal = findViewById(R.id.editTextTotal);

        bill = (Bill) getIntent().getSerializableExtra("bill");

//        edtAdress.setText(bill.getAddress());
//        edtDate.setText(bill.getDateTime());
//        edtTotal.setText(bill.getTotal());

        Log.d("bill", bill.toString());

        LinkedList<Item> list = new LinkedList<>();
  //      list = (LinkedList<Item>) bill.getItems();



        mRecyclerView = findViewById(R.id.recycleview);

        ItemAdapter adapter = new ItemAdapter(this,list);

        mRecyclerView.setAdapter(adapter);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}