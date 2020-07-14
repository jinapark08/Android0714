package com.example.android0714;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class CommonViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_view);

        //TextView 가져오기
        TextView txtmsg = (TextView)findViewById(R.id.txtmsg);

        //assects에 있는 폰트파일을 이용해서 폰트를 생성
        Typeface tf = Typeface.createFromAsset(getAssets(),"nanumgothic.ttf");
        txtmsg.setTypeface(tf);

    }
}