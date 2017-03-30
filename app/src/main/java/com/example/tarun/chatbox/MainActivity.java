package com.example.tarun.chatbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    public static final int IMAGE_PICK = 1;

    private ListView mMessageListView;
    private ImageButton mGalleryButton;
    private EditText mMessageEditText;
    private ImageButton mSendButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMessageListView = (ListView) findViewById(R.id.messagesList);
        mGalleryButton = (ImageButton) findViewById(R.id.gallery_button);
        mMessageEditText = (EditText) findViewById(R.id.message_text);
        mSendButton = (ImageButton) findViewById(R.id.send_button);

        mGalleryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/jpeg");
                intent.putExtra(Intent.EXTRA_LOCAL_ONLY, true);
                startActivityForResult(Intent.createChooser(intent, "Complete action using"),IMAGE_PICK);
            }
        });

        mMessageEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().trim().length() > 0) {
                    mSendButton.setEnabled(true);
                } else {
                    mSendButton.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });


    }
}
