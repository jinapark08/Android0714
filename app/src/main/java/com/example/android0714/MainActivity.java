package com.example.android0714;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //activity를 호출하면 수행되는 메소드
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //activity의 Mainview를 설정하는 문장 - 이 밑으로 작업해야
        setContentView(R.layout.activity_main);
                //xml파일에 만든 view 를 찾아오기
        TextView txtCreed = findViewById(R.id.txtcreed);
        //charsequence는 string의 상위 인터페이스
        txtCreed.setText("Hi");
        //텍스트를 가져올때 안드로이드 에서는 tostring()을 호출해서 가져옵니다.
        String creed = txtCreed.getText().toString();
        //로그출력
        Log.e("신조어인사",creed);

    }
}