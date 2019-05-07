package com.mylove.mia;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends BaseActivity {

    private TextView textView;
    private EditText editText;
    private String[] text = null;
    private String[] input = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tv);
        editText = findViewById(R.id.et);
        String index = textView.getText().toString();
        int len = index.length();
        text = new String[len];
        text = fenge(index);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String word = s.toString();
                int len = word.length();
                input = new String[len];
                input = fenge(word);
                int i = 0;
                for (; i < len; i++) {
                    if (!input[i].equals(text[i])) {
                        editText.setTextColor(Color.RED);
                        break;
                    }
                }
                if (i == len) {
                    editText.setTextColor(Color.BLACK);
                }

            }
        });
    }

    private String[] fenge(String index) {
        if (index != null && !index.isEmpty()) {
            int length = index.length();
            Log.d("zzc:", "length:" + length);
            String[] txt = new String[length];
            for (int i = 0; i < length; i++) {
                txt[i] = index.substring(i, i + 1);
            }
            return txt;
        }
        return null;
    }
}
