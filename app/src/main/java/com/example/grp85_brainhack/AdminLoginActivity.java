package com.example.grp85_brainhack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class AdminLoginActivity extends AppCompatActivity {

    private EditText adminemail, adminpassword;
    private Button adminlogin;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        adminemail = findViewById(R.id.adminemail);
        adminpassword = findViewById(R.id.adminpassword);
        adminlogin = findViewById(R.id.adminlogin);

        auth = FirebaseAuth.getInstance();
        adminlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt_email = adminemail.getText().toString();
                String txt_password = adminpassword.getText().toString();
                loginUser(txt_email, txt_password);
            }
        });
    }

    private void loginUser(String txt_email, String txt_password) {
        auth.signInWithEmailAndPassword(txt_email, txt_password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(AdminLoginActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(AdminLoginActivity.this,AdminPanelActivity.class));
                finish();
            }
        });
    }
}