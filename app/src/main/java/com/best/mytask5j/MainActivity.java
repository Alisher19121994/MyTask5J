package com.best.mytask5j;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.best.mytask5j.Users.Member;
import com.best.mytask5j.Users.User;

public class MainActivity extends AppCompatActivity {

    public String TAG = MainActivity.class.toString();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        views();
    }

    ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    TextView textView = findViewById(R.id.textBtn1);
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent intent = result.getData();
                        Member member = intent.getParcelableExtra("member");
                        Log.d(TAG,member.toString());
                        textView.setText(member.toString());
                    }
                }
            }
    );

    public void views() {
        Button button = findViewById(R.id.btn1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User("Alisher", 1234);
                openNewPage(user);
            }
        });
    }

    public void openNewPage(User user) {
        Intent intent = new Intent(this, SecondActivity2.class);
        intent.putExtra("member", user);
        launcher.launch(intent);
    }
}