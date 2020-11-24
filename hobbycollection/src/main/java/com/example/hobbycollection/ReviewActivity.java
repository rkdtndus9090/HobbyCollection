package com.example.hobbycollection;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class ReviewActivity extends AppCompatActivity {
    private static final String TAG = "ReviewActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        private void myStartActivity if (user == null) {
            myStartActivity(SignUp.class);
        } else {
            FirebaseFirestore db = FirebaseFirestore.getInstance();
            DocumentReference documentReference = db.collection("user").document(user.getUid());
            View.OnClickListener onClickListener;
            documentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if (task.isSuccessful()) {
                        DocumentSnapshot document = task.getResult();

                        if (document != null) {
                            if (document.exists()) {
                                Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                            } else {

                            }
                        }
                    }
                    db.collection("posts")
                            .get()
                            .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                    if (task.isSuccessful()) {
                                        ArrayList<WriteInfo> postList = new ArrayList<>();
                                        for (QueryDocumentSnapshot document : task.getResult()) {
                                            Log.d(TAG, document.getId() + " => " + document.getData());
                                            postList.add(new WriteInfo(
                                                    document.getData().get("title").toString(),
                                                    (ArrayList<String>) document.getData().get("contents"),
                                                    document.getData().get("publisher").toString(),
                                                    new Date(document.getDate("createdAt").getTime())));
                                        }
                                        RecyclerView recyclerView = findViewById(R.id.recyclerView);
                                        recyclerView.setHasFixedSize(true);
                                        recyclerView.setLayoutManager(new LinearLayoutManager(ReviewActivity.this));
                                        RecyclerView.Adapter mAdapter = new MainAdapter(ReviewActivity.this, postList);
                                        recyclerView.setAdapter(mAdapter);
                                    } else {
                                        Log.d(TAG, "Error getting documents: ", task.getException());
                                    }
                                }
                            });
                }

                findViewById(R.id.reviwButton).

                <onClickListener> setOnClickListener(onClickListener);

                View.OnClickListener onClickListener = new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        switch (v.getId()) {
                        /*
                        case R.id.logoutButton:
                            FirebaseAuth.getInstance().signOut();
                            myStartActivity(SignUpActivity.class);
                            break;

                         */
                            case R.id.reviwButton:
                                myStartActivity(WritePostActivity.class);
                                break;
                        }
                    }
                };

                private void myStartActivity(Class c) {
                    Intent intent = new Intent(this, c);
                    startActivity(intent);
                }
            });
        }
    }
}
