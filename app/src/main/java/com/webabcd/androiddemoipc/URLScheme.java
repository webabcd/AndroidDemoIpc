package com.webabcd.androiddemoipc;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class URLScheme extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urlscheme);

        Intent intent = getIntent();
        String scheme = intent.getScheme();
        String dataString = intent.getDataString();
        Uri uri = intent.getData();
        if (uri != null) {
            //完整的url信息
            String url = uri.toString();
            //scheme部分
            String schemes = uri.getScheme();
            //host部分
            String host = uri.getHost();
            //port部分
            int port = uri.getPort();
            //访问路径
            String path = uri.getPath();
            //编码路径
            String path1 = uri.getEncodedPath();
            //query部分
            String queryString = uri.getQuery();
            //获取参数值
            String systemInfo = uri.getQueryParameter("tool_id");
    }
}