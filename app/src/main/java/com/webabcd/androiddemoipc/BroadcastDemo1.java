/**
 * 本例用于演示如何实现一个 BroadcastReceiver
 *
 * 注：本例演示如何通过静态注册（即在 AndroidManifest.xml 中注册）的方式注册 BroadcastReceiver（参见 AndroidManifest.xml 中的 receiver 节点）
 */

package com.webabcd.androiddemoipc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BroadcastDemo1 extends BroadcastReceiver {

    private final String LOG_TAG = "BroadcastDemo1";

    @Override
    public void onReceive(Context context, Intent intent) {

        // 这里不要做耗时操作（会 anr），也不要新开线程（容易被杀死）

        // 获取接收到的广播的名称
        String actionName = intent.getAction();
        // 获取传递过来的参数
        String p1 = intent.getStringExtra("p1");
        String p2 = intent.getStringExtra("p2");

        Log.d(LOG_TAG, String.format("action:%s, p1:%s, p2:%s", actionName, p1, p2));
    }
}
