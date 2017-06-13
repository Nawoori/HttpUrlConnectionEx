package com.nawoori.android.httpurlconnectionex;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by User on 2017-06-13.
 */

public class Remote {

        //인자를 받은 url로 네트웍을 통해 데이터를 가져오는 함수
        //가져오는 순간 무조건 String
    public static String getData(String url) throws Exception { // <- 요청한 곳에서 Exception 처리를 해준다.
        String result = "";

        //네트웍 처리
        // 1. 요청처리 Request
        // 1.1 URL 객체 만들기
        URL serverUrl = new URL(url);
        //1.2 연결객체 생성
        HttpURLConnection con = (HttpURLConnection) serverUrl.openConnection(); //url 객체에서 연결을 꺼낸다.
        //1.3 http method 결정
        con.setRequestMethod("GET");

        //2. 응답처리 Response
        //2.1 응답코드 분석
        int responseCode = con.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) { //정상적인 코드처리


            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String temp = null;
            while ((temp = br.readLine()) != null) {
                result += temp;
            }
            //2.3 오류에 대한 응답처리
        } else {
            // 각자 호출측으로 Exception을 만들어서 넘겨 출력~~~
            Log.e("Network", "erro_code" + responseCode);
        }


        return result;
    }

}
