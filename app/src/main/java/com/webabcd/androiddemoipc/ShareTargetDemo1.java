/**
 * 本例用于演示“分享目标”
 *
 * 注：
 * 1、请参见 AndroidManifest.xml 中的相关配置
 * 2、关于“分享源”请参见 AndroidDemo 项目中的 ipc/ShareSourceDemo1.java
 */

package com.webabcd.androiddemoipc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ShareTargetDemo1 extends AppCompatActivity {

    private TextView mTextView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharetargetdemo1);

        mTextView1 = findViewById(R.id.textView1);

        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();

        // 获取分享过来的纯文本内容
        if (action != null && action.equals(Intent.ACTION_SEND) && type != null && type.equalsIgnoreCase("text/plain")){
            String data = intent.getStringExtra(Intent.EXTRA_TEXT);
            mTextView1.setText(String.format("接收到的分享文本内容：%s", data));
        }
    }
}