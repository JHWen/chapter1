package chapter.android.aweme.ss.com.homework;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import chapter.android.aweme.ss.com.homework.model.Message;
import chapter.android.aweme.ss.com.homework.model.PullParser;
import chapter.android.aweme.ss.com.homework.util.MyAdapter;

/**
 * 大作业:实现一个抖音消息页面,所需资源已放在res下面
 */
public class Exercises3 extends AppCompatActivity implements MyAdapter.ListItemClickListener {

    private static final String TAG = "wenjiahao";
    private static final String DATA_PATH = "data.xml";

    private int num_list_items;

    private MyAdapter myAdapter;
    private RecyclerView messageListView;

    private Toast mToast;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "Exercises3 onCreate");
        setContentView(R.layout.activity_message);
        messageListView = findViewById(R.id.rv_list);

        //设置布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        messageListView.setLayoutManager(layoutManager);


        try {
            //读取data.xml文件
            List<Message> messages = PullParser.pull2xml(getResources().getAssets().open(DATA_PATH));
            Log.d(TAG, messages.toString());
            num_list_items = messages.size();
            myAdapter = new MyAdapter(num_list_items, messages, this);
            messageListView.setAdapter(myAdapter);
        } catch (Exception e) {
            Log.d(TAG, e.toString());
            e.printStackTrace();
        }
    }

    @Override
    public void onListItemClick(String title) {
        Log.d(TAG, "onListItemClick: " + title);
        //携带数据，跳转到chatActivity
        Intent intent = new Intent(this, ChatActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        intent.putExtra("user", bundle);
        startActivity(intent);
    }
}
