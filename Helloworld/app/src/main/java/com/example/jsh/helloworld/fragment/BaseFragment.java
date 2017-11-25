package com.example.jsh.helloworld.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jsh.helloworld.R;
import com.example.jsh.helloworld.util.VerticalSpaceItemDecoration;

public abstract class BaseFragment extends Fragment {
    private RecyclerView recyclerView;

    private LinearLayoutManager layoutManager;
    private VerticalSpaceItemDecoration decoration;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        decoration = new VerticalSpaceItemDecoration(48);
        recyclerView.addItemDecoration(decoration);

        runAsyncTask(recyclerView);

        return view;
    }

    public abstract void runAsyncTask(RecyclerView recyclerView);
}

