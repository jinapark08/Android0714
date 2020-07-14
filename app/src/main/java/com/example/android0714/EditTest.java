package com.example.android0714;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditTest extends AppCompatActivity {
    //뷰 변수
    EditText edit;
    TextView text;
    Button btnshow;
    Button btnhide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_test);

        //뷰 객체 가져오기
        edit = (EditText)findViewById(R.id.edit);
        text = (TextView)findViewById(R.id.text);
        btnshow = (Button)findViewById(R.id.btnshow);
        btnhide = (Button)findViewById(R.id.btnhide);

        btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //키보드 관리 객체 가져오기
                //getSystemService => 중요! 모두 이것으로 시스템을 가져옴!!
                InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                //키보드 출력 : 키보드를 누리면 edit에 입력
                imm.showSoftInput(edit,0);
            }
        });
        //람다를 이용하여 작성 - 이것을 사용하려면 java 버전 설정이 필요함
        //[file]-[project structure]-[module]-source와 target을 1.8로 버전 변경
        btnhide.setOnClickListener((View view)->{
            //키보드 관리객체 가져오기
            InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(edit.getWindowToken(),0);
        });

        //edit에 입력제한 - 글자수제한, 소문자입력시 대문자로 변환
        edit.setFilters(new InputFilter[]{
                new InputFilter.LengthFilter(3),
                new InputFilter.AllCaps()
        });


        //edit에 문자열이 변경되면 처리
        edit.addTextChangedListener(new TextWatcher() {
            //키보드는 눌렀고 누른 키보드의 값을 edit text에 표시되기 전  (=이벤트는 발생했으나 적용이 아직안됐을 때)
           @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //edit의 문자열을 text에 출력
                text.setText(edit.getText());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }
}