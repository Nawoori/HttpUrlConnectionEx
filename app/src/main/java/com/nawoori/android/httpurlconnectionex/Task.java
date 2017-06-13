package com.nawoori.android.httpurlconnectionex;

import android.os.AsyncTask;

import static com.nawoori.android.httpurlconnectionex.R.id.textView;
import static com.nawoori.android.httpurlconnectionex.Remote.getData;

/**
 * Created by User on 2017-06-13.
 */

public class Task {

    //thread를 생성
    public static void newTask(final TaskInterface taskInterface) {
        //thread와 AsyncTask는 return을 할 수 없다.
        new AsyncTask<String, Void, String>() {
            //백그라운드 처리 함수
            @Override
            protected String doInBackground(String... params) { //...과 []의 차이는?
                String result = "";
                try {
                    //getData 함수로 데이터를 가져온다.
                    result = getData(params[0]);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return result;
            }

            @Override
            protected void onPostExecute(String result) {
                //결과처리
                taskInterface.postExecute(result);

            }
        }.execute(taskInterface.getUrl());
    }
}
