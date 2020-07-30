/**
 * 本例用于演示如何实现一个 ContentProvider
 *
 * ContentProvider 是支持数据的增删改查，和数据变化通知的，本例只演示如何查询数据
 *
 * 注：需要在 AndroidManifest.xml 中注册 ContentProvider（参见 AndroidManifest.xml 中的 provider 节点）
 */

package com.webabcd.androiddemoipc;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ContentProviderDemo1 extends ContentProvider {

    // ContentProvider 的 url 成功匹配时的匹配码
    private static final int MATCH_CODE = 1;

    // 用于判断是否匹配 ContentProvider 的 url
    private static UriMatcher mUriMatcher;

    static {
        // 如果 url 匹配不成功则返回 UriMatcher.NO_MATCH（也就是说当调用 match(uri) 时，如果 url 匹配不成功则返回 -1）
        mUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

        // 第 1 个参数：代表 url 的 host，与 AndroidManifest.xml 中的 provider 的 authorities 一致
        // 第 2 个参数：代表 url 的 path
        // 第 3 个参数：代表当调用 match(uri) 时，如果 url 匹配成功则返回此值
        // 注：本例匹配的 ContentProvider url 为 content://cn.webabcd.contentProviderDemo1/api
        mUriMatcher.addURI("cn.webabcd.contentProviderDemo1", "api", MATCH_CODE);
    }

    @Override
    public boolean onCreate() {
        return true;
    }

    // 当有人通过 url 查询此 ContentProvider 数据时，则执行此方法
    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        int match = mUriMatcher.match(uri);
        // 判断 url 是否与 content://cn.webabcd.contentProviderDemo1/api 相匹配
        if (match == MATCH_CODE) {
            // 通过 MatrixCursor 构造自定义 cursor 对象（如果是 sqlite 的话，其本身就是可以返回 cursor 的）
            // 自定义的 cursor 对象，指定其需要有两个字段，分别是 key 和 value
            MatrixCursor cursor = new MatrixCursor(new String[] {"key", "value"});
            for (int i = 0; i < 10; i++) {
                // 添加自定义 cursor 对象的值，位置 0 代表 key 字段的值，位置 1 代表 value 字段的值
                Object[] values = new Object[2];
                values[0] = "key" + i;
                values[1] = "value" + i;

                // 为自定义 cursor 对象添加 1 条数据
                cursor.addRow(values);
            }
            return cursor;
        }
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}