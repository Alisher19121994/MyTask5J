package com.best.mytask5j;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.best.mytask5j.Users.Member;
import com.best.mytask5j.Users.User;

public class SecondActivity2 extends AppCompatActivity {
 String TAG = SecondActivity2.class.toString();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);
        accept();

    }
    public void accept(){
        Button button = findViewById(R.id.btn2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Member member = new Member("Abbos",7777);
                getData(member);
            }
        });

        TextView textView = findViewById(R.id.textBtn2);
        User user = (User) getIntent().getParcelableExtra("member");
        Log.d(TAG,user.toString());
        textView.setText(user.toString());
    }

    public void getData(Member member){
        Intent intent = new Intent();
        intent.putExtra("member",member);
        setResult(RESULT_OK,intent);
        finish();
    }
}