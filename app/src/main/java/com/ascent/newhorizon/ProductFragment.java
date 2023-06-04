package com.ascent.newhorizon;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProductFragment extends Fragment {

    RecyclerView productList;
    List<Integer> image;
    List<String> title;
    List<String> maker;
    ProductAdapter productAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product, container, false);

        productList = view.findViewById(R.id.productRv);
        image = new ArrayList<>();
        title = new ArrayList<>();
        maker = new ArrayList<>();

        // Add each item
//        image.add(R.drawable.image1);
//        title.add("Scrunchie");
//        maker.add("Made by Zarya");
//
//        image.add(R.drawable.totebag);
//        title.add("Tote Bag");
//        maker.add("Made by Mariyam");
//
//        image.add(R.drawable.hat);
//        title.add("Cloth hat");
//        maker.add("Made by Saleha");
//
//        image.add(R.drawable.facemask);
//        title.add("Cloth face mask");
//        maker.add("Made by Bunga");
//
//        image.add(R.drawable.scarf);
//        title.add("Scarf");
//        maker.add("Made by Raya");

        image.add(R.drawable.image1);
        title.add(getString(R.string.title1));
        maker.add(getString(R.string.maker1));

        image.add(R.drawable.totebag);
        title.add(getString(R.string.title2));
        maker.add(getString(R.string.maker2));

        image.add(R.drawable.hat);
        title.add(getString(R.string.title3));
        maker.add(getString(R.string.maker3));

        image.add(R.drawable.facemask);
        title.add(getString(R.string.title4));
        maker.add(getString(R.string.maker4));

        image.add(R.drawable.scarf);
        title.add(getString(R.string.title5));
        maker.add(getString(R.string.maker5));

        productAdapter = new ProductAdapter(getContext(), image, title, maker);
        // Quick Note: spanCount - number of columns
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);
        productList.setLayoutManager(gridLayoutManager);
        productList.setAdapter(productAdapter);

        return view;
    }
}
