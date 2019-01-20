package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ChatActivity extends AppCompatActivity {
    private final static String TAG = "wenjiahao";

    private TextView tvWithName;
    private TextView tvContentInfo;
    private EditText edSay;
    private ImageView btnSendInfo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "ChatActivity onCreate");
        setContentView(R.layout.activity_chatroom);

        tvWithName = findViewById(R.id.tv_with_name);
        edSay = findViewById(R.id.ed_say);
        tvContentInfo = findViewById(R.id.tv_content_info);
        btnSendInfo = findViewById(R.id.btn_send_info);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Bundle bundle = extras.getBundle("user");
            if (bundle != null) {
                tvWithName.setText("我和" + bundle.getString("title") + "的对话");
            }
        }

        edSay.setText("");
        btnSendInfo.setEnabled(false);

        edSay.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                btnSendInfo.setEnabled(true);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        btnSendInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取editText消息内容
                String message = edSay.getText().toString();
                edSay.setText("");
                tvContentInfo.append(message + "\n");
                message = message.replace("你", "我");
                message = message.replace("吗", "");
                message = message.replace("？", "");
                message = message.replace("?", "");
                tvContentInfo.append(message + "\n");
                btnSendInfo.setEnabled(false);
            }
        });


    }
}
