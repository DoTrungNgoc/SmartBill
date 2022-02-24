package com.example.tolbill.app;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tolbill.R;
import com.example.tolbill.model.Item;

import java.util.LinkedList;

public class ItemAdapter extends  RecyclerView.Adapter<ItemAdapter.ItemViewHolder>  {

    private final LinkedList<Item> mList;
    private LayoutInflater mInflater;
    private String test;

    public String  getmWordList(){
        return test;
    }


    public ItemAdapter(Context context,
                       LinkedList<Item> wordList) {
        mInflater = LayoutInflater.from(context);
        this.mList = wordList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.bill_item,
                parent, false);
        return new ItemViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder,int position) {
        String a = mList.get(position).getName();
        String b = mList.get(position).getPrice();
        String c = mList.get(position).getQuantity();
        holder.wordItemView.setText(a);
        holder.wordItemView1.setText(b);
        holder.wordItemView2.setText(c);


        holder.wordItemView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

//                Log.d("log", "onTextChanged: " + position);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        public final EditText wordItemView;
        public final EditText wordItemView1;
        public final EditText wordItemView2;
        final ItemAdapter mAdapter;

        public ItemViewHolder(View itemView, ItemAdapter adapter) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.word);
            wordItemView1 = itemView.findViewById(R.id.word1);
            wordItemView2 = itemView.findViewById(R.id.word2);
            this.mAdapter = adapter;
        }
    }
}
