package com.example.shopflowers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText_name = findViewById(R.id.edit_text_name_user);
        final EditText editText_address = findViewById(R.id.edit_text_address_user);
        final EditText editText_phone_number = findViewById(R.id.edit_text_phone_number);

        ImageButton startOrderBtn = findViewById(R.id.btn_start_order);
        startOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = editText_name.getText().toString();
                String userAddress = editText_address.getText().toString();
                String userPhoneNumber = editText_phone_number.getText().toString();

                if(userName.matches("")&&userAddress.matches("")&&userPhoneNumber.matches("")){
                    Toast.makeText(MainActivity.this, getResources().getString(R.string.missing3_toast), Toast.LENGTH_SHORT).show();
                }else if(userName.matches("")&&userAddress.matches("")){
                    Toast.makeText(MainActivity.this, getResources().getString(R.string.missing2_toast), Toast.LENGTH_SHORT).show();
                }else if(userName.matches("")&&userPhoneNumber.matches("")){
                    Toast.makeText(MainActivity.this, getResources().getString(R.string.missing6_toast), Toast.LENGTH_SHORT).show();
                }else if(userAddress.matches("")&&userPhoneNumber.matches("")){
                    Toast.makeText(MainActivity.this, getResources().getString(R.string.missing7_toast), Toast.LENGTH_SHORT).show();
                }else if(userName.matches("")){
                    Toast.makeText(MainActivity.this, getResources().getString(R.string.missing1_toast), Toast.LENGTH_SHORT).show();
                }else if(userAddress.matches("")){
                    Toast.makeText(MainActivity.this, getResources().getString(R.string.missing4_toast), Toast.LENGTH_SHORT).show();
                }else if(userPhoneNumber.matches("")){
                    Toast.makeText(MainActivity.this, getResources().getString(R.string.missing5_toast), Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("user_name", userName);
                    intent.putExtra("user_address", userAddress);
                    intent.putExtra("user_phone_number", userPhoneNumber);
                    startActivity(intent);
                }
            }
        });

    }
}