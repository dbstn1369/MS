package com.example.jsh.helloworld.util;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jsh.helloworld.AlarmActivity;
import com.example.jsh.helloworld.BroadcastD;
import com.example.jsh.helloworld.MainActivity;
import com.example.jsh.helloworld.R;
import com.example.jsh.helloworld.vo.Event;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private ArrayList<Event> arrayList;
    private Context context;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public View v;

        public TextView leftTop;
        public TextView rightTop;

        public TextView title;
        public TextView content;

        public TextView leftBottom;
        public TextView rightBottom;

        public ImageView addButton;

        public ViewHolder(View v) {
            super(v);
            this.v = v;

            leftTop = (TextView) v.findViewById(R.id.event_viewholder_leftTop);
            rightTop = (TextView) v.findViewById(R.id.event_viewholder_rightTop);

            title = (TextView) v.findViewById(R.id.event_viewholder_title);
            content = (TextView) v.findViewById(R.id.event_viewholder_content);

            leftBottom = (TextView) v.findViewById(R.id.event_viewholder_leftBottom);
            rightBottom = (TextView) v.findViewById(R.id.event_viewholder_rightBottom);

            addButton = (ImageView) v.findViewById(R.id.event_viewholder_addButton);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public RecyclerViewAdapter(Context context, ArrayList<Event> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_viewholder, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final Event event = arrayList.get(position);

        if (event.getLeftTop() != null) {
            holder.leftTop.setText(event.getLeftTop());
        }

        if (event.getRightTop() != null) {
            holder.rightTop.setText(event.getRightTop());
        }

        if (event.getTitle() != null) {
            holder.title.setText(event.getTitle());
        }

        if (event.getContent() != null) {
            holder.content.setText(event.getContent());
        }

        if (event.getLeftBottom() != null) {
            holder.leftBottom.setText(event.getLeftBottom());
        }

        if (event.getRightBottom() != null) {
            holder.rightBottom.setText(event.getRightBottom());
        }

        if (event.getUrl() != null) {
            holder.v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(event.getUrl()));
                    context.startActivity(intent);
                }
            });
        }

        holder.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("알람 추가");
                builder.setMessage("알람을 추가하시겠습니까?");
                builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ((MainActivity) context).addToList(event);

                        AlarmManager am = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
                        Intent intent = new Intent(context, BroadcastD.class);

                        PendingIntent sender = PendingIntent.getBroadcast(context, 0, intent, 0);

                        Calendar calendar = Calendar.getInstance();

                        SimpleDateFormat form= new SimpleDateFormat("yyyy.MM.dd");
                        Date d = new Date();
                        try {
                            d=form.parse(event.getRightBottom().substring(13));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        calendar.set(d.getYear(),d.getMonth(),d.getDate()-1, 0, 0, 0);
                        //calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 16, 6, 0);
                        am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), sender);

                    }
                });
                builder.setNegativeButton("취소", null);
                AlertDialog alertDialog = builder.show();
            }
        });


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}