package com.ascent.newhorizon;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;




import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements HomeAdapter.OnItemClickListener {

    List<String> featureTitle;
    List<String> featureBtn;
    List<String> featureDesc;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        featureTitle = new ArrayList<>();
        featureBtn = new ArrayList<>();
        featureDesc = new ArrayList<>();

//        featureTitle.add("Product Catalogue");
//        featureTitle.add("Commission Space");
//        featureTitle.add("Journey Story Time");

        featureTitle.add(getString(R.string.text_catalogue));
        featureTitle.add(getString(R.string.text_commission));
        featureTitle.add(getString(R.string.blogTitle));

//        featureBtn.add("Browse Products");
//        featureBtn.add("Find out More");
//        featureBtn.add("Read More");

        featureBtn.add(getString(R.string.featureBtn1));
        featureBtn.add(getString(R.string.featureBtn2));
        featureBtn.add(getString(R.string.featureBtn3));

//        featureDesc.add("Go through a wide range of handcrafted products, " +
//                "specially made by the community :)");
//        featureDesc.add("Interested in getting a unique piece? \nHave a look at what our talents have to offer!");
//        featureDesc.add("Gain insights on the life of a refugee,\nfrom their journey to their daily lives.");

        featureDesc.add(getString(R.string.featureDesc1));
        featureDesc.add(getString(R.string.featureDesc2));
        featureDesc.add(getString(R.string.featureDesc3));

        HomeAdapter homeAdapter =  new HomeAdapter(getContext(),featureTitle, featureDesc, featureBtn,this);
        recyclerView.setAdapter(homeAdapter);

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        TextView userEmail = view.findViewById(R.id.userEmail);


       if (currentUser != null) {
            String email = currentUser.getEmail();
            //userEmail.setText("Currently logged in: " + email);
           userEmail.setText(getString(R.string.txtEmailStatus) + email);
       } else {
           // userEmail.setText("You are currently logged in as guest");
           userEmail.setText(R.string.txtGuestStatus);
           //  userEmail.setVisibility(View.GONE);
       }

        return view;
    }

    @Override
    public void onItemClick(int position) {
        switch (position) {
            case 0:
                Fragment productFragment = new ProductFragment();
                Bundle args = new Bundle();
                args.putInt("position", position);
                productFragment.setArguments(args);
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.container, new ProductFragment())
                        .addToBackStack(null)
                        .commit();
                break;

            case 1:
                Fragment commisionFragment = new CommisionFragment();
                Bundle args1 = new Bundle();
                args1.putInt("position", position);
                commisionFragment.setArguments(args1);
                FragmentManager fragmentManager1 = requireActivity().getSupportFragmentManager();
                fragmentManager1.beginTransaction()
                        .replace(R.id.container, new CommisionFragment())
                        .addToBackStack(null)
                        .commit();
                break;

            case 2:
                Fragment blogFragment = new BlogFragment();
                Bundle args2 = new Bundle();
                args2.putInt("position", position);
                blogFragment.setArguments(args2);
                FragmentManager fragmentManager2 = requireActivity().getSupportFragmentManager();
                fragmentManager2.beginTransaction()
                        .replace(R.id.container, new BlogFragment())
                        .addToBackStack(null)
                        .commit();
                break;
        }
    }
}


