package com.example.hobbycollection;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class CookingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cooking);

        //Toolbar를 액티비티의 App Bar로 지정
        setSupportActionBar((Toolbar) findViewById(R.id.app_toolbar));
        //Toolbar td = (Toolbar) findViewById(R.id.app_toolbar));
        //setSupportActionBar(tb);

        //툴바 타이틀 지우기
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        // 뒤로가기 버튼, 디폴트로 true만 해도 백버튼이 생김
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //뒤로가기 버튼 설정(drawable에 이미지를 등록해서 화살표 대신 사용가능, 사이즈가 충분히 작아야 함)
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.icon_back);

        //툴바 배경색
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));

        findViewById(R.id.login_btn).setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                //로그인 버튼 클릭 시
                case R.id.cook1:
                    startPayActivity();
                    break;
                case R.id.cook2:
                    startPayActivity();
                    break;
                case R.id.cook3:
                    startPayActivity();
                    break;
                case R.id.cook4:
                    startPayActivity();
                    break;
            }
        }
    };

    // 선택 액티비티 이동
    private void startPayActivity(){
        Intent intent = new Intent(this, PayActivity.class);
        // 앱이 꺼짐
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

}