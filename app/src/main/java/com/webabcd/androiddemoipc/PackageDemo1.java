/**
 * 本例用于演示如何通过指定 package 和 activity 被启动
 *
 * 注：需要在 AndroidManifest.xml 中的相关的 activity 中配置 android:exported="true"（是否允许此 activity 被其他应用打开）
 */

package com.webabcd.androiddemoipc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class PackageDemo1 extends AppCompatActivity {

    private TextView mTextView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_packagedemo1);

        mTextView1 = findViewById(R.id.textView1);

        Intent intent = this.getIntent();
        String p1 = "";
        String p2 = "";
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            // 获取传递过来的参数
            p1 = bundle.getString("p1");
            p2 = bundle.getString("p2");
        }

        mTextView1.setText(String.format("收到参数 p1:%s, p2:%s", p1, p2));
    }
}