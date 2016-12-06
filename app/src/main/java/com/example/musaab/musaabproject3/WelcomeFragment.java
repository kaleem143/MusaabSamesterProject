package com.example.musaab.musaabproject3;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class WelcomeFragment extends Fragment {
    ListView simpleList;
    ArrayList<Item> shoppinList =new ArrayList<>();

    public WelcomeFragment() {
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_welcome, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        simpleList = (ListView)view.findViewById(R.id.simpleListView);
        shoppinList.add(new Item(1,"Mens Fashion",R.mipmap.ic_launcher));
        shoppinList.add(new Item(2,"Womans Fashion",R.mipmap.ic_launcher));
        shoppinList.add(new Item(3,"Kids",R.mipmap.ic_launcher));
        shoppinList.add(new Item(4,"Computers",R.mipmap.ic_launcher));
        shoppinList.add(new Item(5,"Gaming Consoles",R.mipmap.ic_launcher));
        shoppinList.add(new Item(6,"Mobiles Phones",R.mipmap.ic_launcher));
        MyAdapter myAdapter=new MyAdapter(getActivity(),R.layout.list_view_items, shoppinList);
        simpleList.setAdapter(myAdapter);
        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent =new Intent(getActivity(),SubCategery.class);
                intent.putExtra("position",position);
                startActivity(intent);
            }
        });

    }
}
