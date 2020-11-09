package com.example.hobbycollection;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Cooking extends AppCompatActivity {

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

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:{
                startActivity(new Intent(this, MainActivity.class));
            }
        }
        return super.onOptionsItemSelected(item);
    }
}