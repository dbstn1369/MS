package com.example.jsh.helloworld.util.asynctask;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;

import com.example.jsh.helloworld.util.RecyclerViewAdapter;
import com.example.jsh.helloworld.vo.Event;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class FestAsyncTask extends BaseAsyncTask {
    private static final String url = "http://korean.visitkorea.or.kr/kor/bz15/where/festival/festival.jsp";

    public FestAsyncTask(Context context, RecyclerView recyclerView) {
        super(context, recyclerView);
    }

    @Override
    public ArrayList<Event> parsingData(ArrayList<Event> arrayList) {
        try {
            Document doc = Jsoup.connect(url).get();
            Elements tableElements = doc.select("div.news_list");
            Elements tableRowElements = tableElements.select("div.item");

            for (int i = 0; i < tableRowElements.size(); i++) {
                Element row = tableRowElements.get(i);
                Elements title = row.select("h3");
                Elements txt = row.select("p.txt");
                Elements city = row.select("span.city");
                Elements date = row.select("span.date");
                Elements link = row.select("a[href]");
                String url = link.attr("abs:href");

                String text = txt.get(0).text();
                String date2=date.get(0).text();
                String ellipsisString = "...";
                String outputString = text;

                if(text.length()>30){
                    outputString = text.substring(0, 30);
                    outputString += ellipsisString;
                }

                Event event = new Event.EventBuilder()
                            .setTitle(title.get(0).text())
                            .setContent(outputString)
                            .setLeftBottom(city.get(0).text())
                            .setRightBottom(date2.substring(7))
                            .setUrl(url)
                            .build();

                arrayList.add(event);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}
