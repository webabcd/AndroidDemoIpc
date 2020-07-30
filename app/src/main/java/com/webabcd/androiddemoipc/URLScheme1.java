/**
 * 本例用于演示如何实现一个支持指定 scheme 的 app（即通过 URLScheme 来实现 deep link）
 *
 * 注：需要在 AndroidManifest.xml 中的相关的 activity 中配置相关的 intent-filter
 */

package com.webabcd.androiddemoipc;

import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class URLScheme1 extends AppCompatActivity {

    private TextView _textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urlscheme1);

        _textView1 = (TextView) findViewById(R.id.textView1);

        sample();
    }

    // 解析通过 deep link 启动时的参数（主要就是从 url 上获取参数）
    private void sample() {

        Intent intent = getIntent();
        String scheme = intent.getScheme();
        String dataString = intent.getDataString();

        Uri uri = intent.getData();
        if (uri != null) {

            String queryString = uri.getQuery();
            String queryString_p1 = uri.getQueryParameter("p1");
            String queryString_p2 = uri.getQueryParameter("p2");

            _textView1.append("url: " + uri.toString());
            _textView1.append("\n");
            _textView1.append("scheme: " + scheme);
            _textView1.append("\n");
            _textView1.append("dataString: " + dataString);
            _textView1.append("\n");
            _textView1.append("queryString: " + queryString);
            _textView1.append("\n");
            _textView1.append("queryString p1: " + queryString_p1);
            _textView1.append("\n");
            _textView1.append("queryString p2: " + queryString_p2);
        }
    }
}