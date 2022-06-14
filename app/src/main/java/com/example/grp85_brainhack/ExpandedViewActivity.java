package com.example.grp85_brainhack;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ExpandedViewActivity extends AppCompatActivity {
    private TextView expandedtitle, expandedlocation, expandeddescription, expandeddescriptioncontent, expandedstatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expanded_view);
        expandedtitle = findViewById(R.id.expandedtitle);
        expandedlocation = findViewById(R.id.expandedlocation);
        expandeddescription = findViewById(R.id.expandeddescription);
        expandeddescriptioncontent = findViewById(R.id.expandeddescriptioncontent);
        expandedstatus = findViewById(R.id.expandedstatus);


           /* Data data = snapshot.getValue(Data.class);
            DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child(data.getTime());
            expandedtitle.setText();

*/


    }
}