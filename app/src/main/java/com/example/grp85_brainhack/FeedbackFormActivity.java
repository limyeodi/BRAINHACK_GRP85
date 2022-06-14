package com.example.grp85_brainhack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Calendar;
import java.util.Date;


import com.google.firebase.database.FirebaseDatabase;

public class FeedbackFormActivity extends AppCompatActivity {

    private EditText title, location, description, name;
    private Button submitfeedbackform;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_form);
        title = findViewById(R.id.feedbackformtitle);
        location = findViewById(R.id.feedbackformlocation);
        description = findViewById(R.id.feedbackformdesc);
        name = findViewById(R.id.feedbackformname);
        submitfeedbackform = findViewById(R.id.feedbackformsubmit);


        submitfeedbackform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt_name = name.getText().toString();
                String txt_title = title.getText().toString();
                String txt_location = location.getText().toString();
                String txt_description = description.getText().toString();

                if(txt_title.isEmpty()||txt_location.isEmpty()||txt_description.isEmpty()||txt_name.isEmpty()){
                    Toast.makeText(FeedbackFormActivity.this, "Please fill up all fields.", Toast.LENGTH_SHORT).show();
                }else{
                    Date currentTime = Calendar.getInstance().getTime();
                    FirebaseDatabase.getInstance().getReference().child("data").child(currentTime.toString()).child("name").setValue(txt_name);
                    FirebaseDatabase.getInstance().getReference().child("data").child(currentTime.toString()).child("time").setValue(currentTime.toString());
                    FirebaseDatabase.getInstance().getReference().child("data").child(currentTime.toString()).child("title").setValue(txt_title);
                    FirebaseDatabase.getInstance().getReference().child("data").child(currentTime.toString()).child("location").setValue(txt_location);
                    FirebaseDatabase.getInstance().getReference().child("data").child(currentTime.toString()).child("description").setValue(txt_description);
                    FirebaseDatabase.getInstance().getReference().child("data").child(currentTime.toString()).child("solved_status").setValue("false");

                    Toast.makeText(FeedbackFormActivity.this, "Feedback form sent!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(FeedbackFormActivity.this, FeedbackSentActivity.class));
                    finish();
                }
            }
        });

    }
}