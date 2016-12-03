package com.example.musaab.musaabproject3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        shoppinList.add(new Item("Mens Fashion",R.mipmap.ic_launcher));
        shoppinList.add(new Item("Womans Fashion",R.mipmap.ic_launcher));
        shoppinList.add(new Item("Kids",R.drawable.com_facebook_auth_dialog_background));
        shoppinList.add(new Item("Computers",R.drawable.com_facebook_auth_dialog_background));
        shoppinList.add(new Item("Gaming Consoles",R.drawable.com_facebook_auth_dialog_background));
        shoppinList.add(new Item("Mobiles Phones",R.drawable.com_facebook_auth_dialog_background));
        MyAdapter myAdapter=new MyAdapter(getActivity(),R.layout.list_view_items, shoppinList);
        simpleList.setAdapter(myAdapter);
    }
}
