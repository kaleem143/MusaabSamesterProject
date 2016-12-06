package com.example.musaab.musaabproject3;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class SubCategeryFragment extends Fragment {
    ListView subList;
    int position;
    ArrayList<Item> shoppinList =new ArrayList<>();

    public SubCategeryFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sub_categery, container, false);



    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent=getActivity().getIntent();
        position = intent.getIntExtra("position",0);
        Log.d("postion", String.valueOf(position));

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        switch (position){
            case 0:
                shoppinList.add(new Item(7,"T-Shirts",R.mipmap.ic_launcher,120));
                shoppinList.add(new Item(8,"Polo",R.mipmap.ic_launcher,123));
                shoppinList.add(new Item(7,"Shirts",R.mipmap.ic_launcher,34));
                shoppinList.add(new Item(8,"Sweat & Loungepants",R.mipmap.ic_launcher,13));
                shoppinList.add(new Item(8,"Trousers & pants",R.mipmap.ic_launcher,1324));
                break;
            case 1:
                shoppinList.add(new Item(9,"Unstitched Fabric",R.mipmap.ic_launcher,234));
                shoppinList.add(new Item(10,"Kurtas & Shalwar Kameez",R.mipmap.ic_launcher,23));
                shoppinList.add(new Item(9,"Formal Wear",R.mipmap.ic_launcher,34));
                shoppinList.add(new Item(10,"Abayas & Hijabs",R.mipmap.ic_launcher,45));
                shoppinList.add(new Item(9,"Dupattas, Stoles & Shawls",R.mipmap.ic_launcher,23));
                shoppinList.add(new Item(10,"Pants & Trousers",R.mipmap.ic_launcher,23));
                break;
            case 2:

                shoppinList.add(new Item(11,"LEARNING & EDUCATION",R.mipmap.ic_launcher,12));
                shoppinList.add(new Item(12,"BUILDING TOYS & LEGO",R.mipmap.ic_launcher,213));

                shoppinList.add(new Item(12,"CARS & REMOTE CONTROL TOYS",R.mipmap.ic_launcher,343));
                shoppinList.add(new Item(12,"PRETEND PLAY",R.mipmap.ic_launcher,343));
                break;
            case 3:

                shoppinList.add(new Item(13,"LAPTOPS",R.mipmap.ic_launcher,23));
                shoppinList.add(new Item(14,"Notebooks",R.mipmap.ic_launcher,45));
                shoppinList.add(new Item(13,"Macbooks",R.mipmap.ic_launcher,55));
                shoppinList.add(new Item(14,"Refurbished Laptops",R.mipmap.ic_launcher,23));
                shoppinList.add(new Item(13,"Tablet PCs",R.mipmap.ic_launcher,23));
                shoppinList.add(new Item(14,"Mini & Netbooks",R.mipmap.ic_launcher,12));
                break;
            case 4:

                shoppinList.add(new Item(15,"Playstation2",R.mipmap.ic_launcher,77));
                shoppinList.add(new Item(16,"Playstation3",R.mipmap.ic_launcher,23));
                shoppinList.add(new Item(15,"Playstation4",R.mipmap.ic_launcher,90));
                shoppinList.add(new Item(16,"Playstation4 pro",R.mipmap.ic_launcher,12));
                shoppinList.add(new Item(15,"xbox one",R.mipmap.ic_launcher,53));
                shoppinList.add(new Item(16,"xbox 360",R.mipmap.ic_launcher,89));
                break;
            case 5:

                shoppinList.add(new Item(17,"Nokia",R.mipmap.ic_launcher,65));
                shoppinList.add(new Item(18,"Samsung",R.mipmap.ic_launcher,64));
                shoppinList.add(new Item(17,"iPhone",R.mipmap.ic_launcher,334));
                shoppinList.add(new Item(18,"Q Mobile",R.mipmap.ic_launcher,23));
                shoppinList.add(new Item(17,"HTC",R.mipmap.ic_launcher,233));
                shoppinList.add(new Item(18,"Black Berry",R.mipmap.ic_launcher,123));
                break;

        }
        subList = (ListView)view.findViewById(R.id.sub_ListView);
        subList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Item itemValue= (Item) parent.getItemAtPosition(position);
                String productname=  itemValue.getItemName();
                double price=itemValue.getPrice();
                Toast.makeText(getActivity(), ""+price, Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getContext(),Detail.class);
                Bundle extras = new Bundle();
                extras.putString("productname",productname);
                extras.putString("productprice", String.valueOf(price));
                intent.putExtras(extras);
//                intent.putExtra("productname",productname);
//                intent.putExtra("productprice",price);
                startActivity(intent);
            }
        });



        MyAdapter myAdapter=new MyAdapter(getActivity(),R.layout.list_view_subitems, shoppinList);
        subList.setAdapter(myAdapter);

    }
}
