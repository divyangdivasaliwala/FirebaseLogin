package com.example.admin.firebaselogin;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    EditText username,password,edittext;
    Button btnlogin,btnregister;

    String u,p,uname,upass,id,uid;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnlogin=(Button) findViewById(R.id.login);
        btnregister=(Button) findViewById(R.id.register);
        username=(EditText)findViewById(R.id.u);
        password=(EditText)findViewById(R.id.p);
        firebaseAuth=FirebaseAuth.getInstance();

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
            }

        });
        btnregister.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick (View v){
                Intent i = new Intent(getApplicationContext(), Register.class);
                startActivity(i);
            }
            });

    }

    private void check() {

        uname=username.getText().toString().trim();
        upass=password.getText().toString().trim();
        firebaseAuth.signInWithEmailAndPassword(uname,upass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    startActivity(new Intent(MainActivity.this,Profile.class));

                }
                else {
                    Toast.makeText(MainActivity.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}

