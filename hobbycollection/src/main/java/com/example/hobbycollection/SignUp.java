package com.example.hobbycollection;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


// 회원가입 Activity
public class SignUp extends AppCompatActivity {
    private static final String TAG = "SignUp";
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);

        mAuth = FirebaseAuth.getInstance();

        findViewById(R.id.signup_btn).setOnClickListener(onClickListener);
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.signup_btn:
                    Log.e("클릭", "회원가입");
                    signUp();
                    break;
            }
        }
    };

    private void signUp(){
        String email = ((EditText)findViewById(R.id.email_input)).getText().toString();
        String password = ((EditText)findViewById(R.id.password_input)).getText().toString();
        String passwordCheck = ((EditText)findViewById(R.id.passwordcheck)).getText().toString();
        if(email.length() > 0 && password.length() > 0 && passwordCheck.length() > 0){ // 이메일과 패스워드가 적혀져있지 않을 경우
            if(password.equals(passwordCheck)){ // 패스워드와 패스워드 확인이 같을 경우
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()) { // 성공 시
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Toast.makeText(SignUp.this, "회원가입에 성공하셨습니다!", Toast.LENGTH_LONG).show();
                                    startLoginActivity(); // 로그인 창으로 이동
                                } else { // 실패 시
                                    if(task.getException() != null){
                                        Toast.makeText(SignUp.this, "회원가입을 다시 시도해주세요", Toast.LENGTH_LONG).show();
                                    }
                                }
                            }
                        });

            } else { // 패스워드와 패스워드 확인이 다를 경우
                Toast.makeText(this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
            }

        } else { // 이메일과 비밀번호를 입력하지 않았을 경우
            Toast.makeText(SignUp.this, "이메일 또는 비밀번호를 입력해주세요", Toast.LENGTH_LONG).show();
        }
    }


    private void startLoginActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

}