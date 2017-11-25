package com.example.jsh.helloworld.fragment;


import android.support.v7.widget.RecyclerView;
import com.example.jsh.helloworld.util.asynctask.FestAsyncTask;

public class FestFragment extends BaseFragment {

    public void runAsyncTask(RecyclerView recyclerView){
        new FestAsyncTask(getActivity(), recyclerView).execute((Void) null);
    }
}