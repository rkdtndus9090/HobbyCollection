package com.example.hobbycollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class LogoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);

        // 이미지 등록
        ImageView imageView = findViewById(R.id.imageView);
        // 이미지를 클릭했을 경우
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 선택 액티비티로 이동
                startSelectActivity();
            }
        });


    }

    // 선택 액티비티 이동
    private void startSelectActivity(){
        Intent intent = new Intent(this, LoginActivity.class);
        // 앱이 꺼짐
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
