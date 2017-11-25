package com.example.jsh.helloworld.fragment;


import android.support.v7.widget.RecyclerView;
import com.example.jsh.helloworld.util.asynctask.NewsAsyncTask;

public class NewsFragment extends BaseFragment {

    public void runAsyncTask(RecyclerView recyclerView){
        new NewsAsyncTask(getActivity(), recyclerView).execute((Void) null);
    }
}


