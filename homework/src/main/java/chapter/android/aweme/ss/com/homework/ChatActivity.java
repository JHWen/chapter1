package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class ChatActivity extends AppCompatActivity {
    private final static String TAG = "wenjiahao";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"ChatActivity onCreate");
        setContentView(R.layout.activity_chatroom);

        TextView textView = findViewById(R.id.tv_with_name);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Bundle bundle = extras.getBundle("user");
            if (bundle != null) {
                textView.setText("我和" + bundle.getString("title") + "的对话");
            }
        }
    }
}
