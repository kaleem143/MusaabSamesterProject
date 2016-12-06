package com.example.musaab.musaabproject3;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailFragment extends Fragment {
private String itemName;
    private String itemPrice;
    public DetailFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent=getActivity().getIntent();
        Bundle extras = intent.getExtras();
         itemName = extras.getString("productname");
        itemPrice = extras.getString("productprice");
//        itemName = intent.getStringExtra("productname");
//        itemPrice=intent.getStringExtra("productprice");



    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView=(TextView)view.findViewById(R.id.product_name);
        TextView pricetextView=(TextView)view.findViewById(R.id.priceText);
        textView.setText(itemName);
        pricetextView.setText("Price: " +itemPrice +" $");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }
}
