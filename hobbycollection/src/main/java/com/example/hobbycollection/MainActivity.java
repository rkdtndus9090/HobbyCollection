package com.example.hobbycollection;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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


        //요리을 눌렀을 시
        Button cooking = (Button)findViewById(R.id.cooking);
        cooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent1 = new Intent(MainActivity.this,Cooking.class);
                startActivity(myintent1);
                finish();
            }
        });

        //미술을 눌렀을 시
        Button art = (Button)findViewById(R.id.art);
        art.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent1 = new Intent(MainActivity.this,Art.class);
                startActivity(myintent1);
                finish();
            }
        });

        //공예을 눌렀을 시
        Button crafts = (Button)findViewById(R.id.crafts);
        crafts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent1 = new Intent(MainActivity.this,Crafts.class);
                startActivity(myintent1);
                finish();
            }
        });

        //Room을 눌렀을 시
        Button user = (Button)findViewById(R.id.user);
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent1 = new Intent(MainActivity.this,Room.class);
                startActivity(myintent1);
                finish();
            }
        });

        //review을 눌렀을 시
        Button review = (Button)findViewById(R.id.review);
        review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent1 = new Intent(MainActivity.this,Review.class);
                startActivity(myintent1);
                finish();
            }
        });



    }

    // 옵션 메뉴 구현
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:{
                startActivity(new Intent(this, Login.class));
            }
        }
        return super.onOptionsItemSelected(item);
    }
}