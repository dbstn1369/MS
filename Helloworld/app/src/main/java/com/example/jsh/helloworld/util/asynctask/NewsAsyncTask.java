package com.example.jsh.helloworld.util.asynctask;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;


import com.example.jsh.helloworld.vo.Event;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class NewsAsyncTask extends BaseAsyncTask {
    private static final String url = "http://contests.saramin.co.kr/contests";

    public NewsAsyncTask(Context context, RecyclerView recyclerView) {
        super(context, recyclerView);
    }

    @Override
    public ArrayList<Event> parsingData(ArrayList<Event> arrayList) {
        try {
            Map<String, String> data1 = new HashMap<String, String>();//로그인하기 위한 data 값들.
            data1.put("user_id", "201302494");
            data1.put("user_password", "cys5808hi!");
            data1.put("group_cd", "UN");
            data1.put("sub_group_cd", "");
            data1.put("sso_url","http://portal.cnu.ac.kr/enview/portal/");
            data1.put("schedule_selected_date", new Date().toString());
            data1.put("fnc_return","");

            Connection.Response loginPageResponse1 = Jsoup.connect("http://e-learn.cnu.ac.kr/login/doLogin.dunet")//세션유지를 위한 사이트 연결
                    .timeout(60000)//header 값들은 구글 크롬개발자로 구하면 됩니다.
                    .header("Origin", "http://e-learn.cnu.ac.kr")
                    .header("Referer", "http://e-learn.cnu.ac.kr/login/doLogin.dunet")
                    .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .header("Accept-Encoding", "gzip, deflate, br")
                    .header("Accept-Language", "ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4")
                    .data(data1)
                    .method(Connection.Method.POST)
                    .ignoreContentType(true)
                    .execute();
            Log.d("test","testprint1 "+ loginPageResponse1.body());

            Map<String, String> loginTryCookie1 = loginPageResponse1.cookies();//로그인을 하여 얻은 쿠키 아래에서 사용함.
            Log.d("test","testprint4 "+ loginTryCookie1.toString());

            String userAgent5 = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36";
            Map<String, String> data2 = new HashMap<String, String>();
            String time = new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));
            Log.d("test","testprint5 "+ time);

            data2.put("schedule_dt",  time);

            Connection.Response response6 = Jsoup.connect("http://e-learn.cnu.ac.kr/lms/mypage/schedule/doListMySchedule.dunet")
                    .userAgent(userAgent5)
                    .timeout(60000)
                    .header("Origin", "http://e-learn.cnu.ac.kr")
                    .header("Referer","http://e-learn.cnu.ac.kr/main/MainView.dunet")
                    .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .header("Accept-Encoding", "gzip, deflate")
                    .header("Accept-Language", "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7")
                    .data(data2)
                    .cookies(loginTryCookie1)
                    .method(Connection.Method.POST)
                    .ignoreContentType(true)
                    .execute();

            Document loginPageDocument5 = response6.parse();
            Log.d("test","testprint2 "+response6.body());
            Log.d("test","testprint3 "+loginPageDocument5.body());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}
