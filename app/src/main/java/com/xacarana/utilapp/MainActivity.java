package com.xacarana.utilapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {
    FirebaseAuth auth;
    Button button;
    TextView textView;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth = FirebaseAuth.getInstance();
        button = findViewById(R.id.logout);
        textView = findViewById(R.id.user_details);
        user = auth.getCurrentUser();
        if (user == null) {
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
            finish();
        } else {
            textView.setText(user.getEmail());
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void startCalculadoraActivity(View view) {
        Intent intent = new Intent(this, calculadora.class);
        startActivity(intent);
    }

    public void startFormulasActivity(View view) {
        Intent intent = new Intent(this, Formulas.class);
        startActivity(intent);
    }

    public void startFormulas2Activity(View view) {
        Intent intent = new Intent(this, Formulas2.class);
        startActivity(intent);

    }

    public void startAcercaDeActivity(View view) {
        Intent intent = new Intent(this, AcercaDe.class);
        startActivity(intent);
    }
}