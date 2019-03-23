package com.example.admin.firebaselogin;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {
    EditText e1, e2, e3, e4, e5;
    DatabaseReference databasestudent;
    String uname;
    String uemail;
    String upass;
    String udate;
    String upnumber;
    Button btn;
    FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btn = (Button) findViewById(R.id.reg);
        databasestudent = FirebaseDatabase.getInstance().getReference("Student");
        e1 = (EditText) findViewById(R.id.username);
        e2 = (EditText) findViewById(R.id.email);
        e3 = (EditText) findViewById(R.id.password);
        e4 = (EditText) findViewById(R.id.date);
        e5 = (EditText) findViewById(R.id.phone);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    store();
                }
            });

    }

    private void store() {
        uname=e1.getText().toString().trim();
        uemail=e2.getText().toString().trim();
        upass=e3.getText().toString().trim();
        udate=e4.getText().toString().trim();
        upnumber=e5.getText().toString().trim();

        if(uname.isEmpty() || uemail.isEmpty() || upass.isEmpty() || udate.isEmpty() || upnumber.isEmpty()){
            Toast.makeText(Register.this,"Enter All Details ",Toast.LENGTH_LONG).show();
            return;

        }
        else {

            firebaseAuth.createUserWithEmailAndPassword(uemail,upass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(!task.isSuccessful()){
                        Toast.makeText(Register.this, "Registration failed! " + "\n" + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        return;
                    }
                    FirebaseUser user =firebaseAuth.getCurrentUser();
                    String id=user.getUid();
                    data dt=new data(id,uname,uemail,upass,udate,upnumber);
                    databasestudent.child(id).setValue(dt);
                    Toast.makeText(Register.this,"Details Added",Toast.LENGTH_LONG).show();
                    Intent i=new Intent(Register.this,MainActivity.class);
                    startActivity(i);
                }
            });
        }
    }
}
