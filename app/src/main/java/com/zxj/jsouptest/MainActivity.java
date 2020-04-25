package com.zxj.jsouptest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.JsonWriter;
import android.util.Log;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Socket socket = new Socket();
//        JsonWriter jsonWriter = new JsonWriter();
//        jsonWriter.
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Connection.Response hahah = Jsoup.connect("http://jhentai.cn/index.php/api/SingleCard/login")
                            .requestBody("hahah")
                            .method(Connection.Method.POST)
                            .validateTLSCertificates(false)
                            .ignoreHttpErrors(true)
                            .ignoreContentType(true)
                            .execute();
                    String body = hahah.body();
                    Log.e("zxj", "onCreate: " + body );
                } catch (Throwable e) {
                    e.printStackTrace();
                    Log.e("zxj", "IOException: " + e.getMessage() );
                }
            }
        }).start();
    }

}
