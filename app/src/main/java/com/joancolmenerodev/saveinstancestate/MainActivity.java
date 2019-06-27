package com.joancolmenerodev.saveinstancestate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.content.res.Configuration.ORIENTATION_PORTRAIT;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "WhateverTag";
    private boolean signaturePadIsEmpty = true;
    private TextView tvState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnState = findViewById(R.id.button);
        tvState = findViewById(R.id.textView);
        btnState.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signaturePadIsEmpty = !signaturePadIsEmpty;
                tvState.setText(String.valueOf(signaturePadIsEmpty));
            }
        });
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        signaturePadIsEmpty = savedInstanceState.getBoolean("SignaturePadIsEmpty");
        tvState.setText(String.valueOf(signaturePadIsEmpty));

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("SignaturePadIsEmpty", signaturePadIsEmpty);
    }
}