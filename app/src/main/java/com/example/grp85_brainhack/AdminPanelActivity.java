package com.example.grp85_brainhack;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AdminPanelActivity extends AppCompatActivity {

    private TextView feedbacktoptxt;
    private ListView adminlistview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_panel);
        adminlistview = findViewById(R.id.adminlistview);

        ArrayList<String> list = new ArrayList<>();
        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.list_item, list);

        adminlistview.setAdapter(adapter);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("data");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                for(DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Data data = snapshot.getValue(Data.class);
                    String txt = "Title: " + data.getTitle() + "Urgency: "+ data.getUrgency() +" \nLocation: "+ data.getLocation()+" \nDescription: "+ data.getDescription()+"\nSent in by: "+data.getName()+" At: "+data.getTime()+"\nStatus: "+data.getSolved_status();
                    list.add(txt);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}