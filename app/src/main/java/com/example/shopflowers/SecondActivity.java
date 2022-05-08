package com.example.shopflowers;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    String countWhichFlower[] = {"0","0","0"};
    String extebsions[] = {"",""};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activiy);
        getWindow().setBackgroundDrawableResource(R.drawable.pp);

        String userName = getIntent().getStringExtra("user_name");
        String userAddress = getIntent().getStringExtra("user_address");
        String userPhone = getIntent().getStringExtra("user_phone_number");
        TextView text_user_details = findViewById(R.id.user_details_output);
        text_user_details.setText(userName + " " + userAddress + " " + userPhone);

        Button btn_change_quantity1 = findViewById(R.id.btn_change_flower1);
        Button btn_change_quantity2 = findViewById(R.id.btn_change_flower2);
        Button btn_change_quantity3 = findViewById(R.id.btn_change_flower3);
        btn_change_quantity1.setOnClickListener(this);
        btn_change_quantity2.setOnClickListener(this);
        btn_change_quantity3.setOnClickListener(this);

        final Spinner spinner = findViewById(R.id.spinner);
        String options[] = {getString(R.string.spinner_option_1), getString(R.string.spinner_option_2), getString(R.string.spinner_option_3)};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, options);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView textView= findViewById(R.id.choose_option);
                textView.setText(parent.getItemAtPosition(position).toString());
                extebsions[0] = (parent.getItemAtPosition(position).toString());
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        final CheckBox checkBoxWine =findViewById(R.id.check_box1_wine);
        checkBoxWine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RelativeLayout relativeLayout =findViewById(R.id.wine_view);
                if(checkBoxWine.isChecked()){
                    relativeLayout.setVisibility(View.VISIBLE);
                    extebsions[0] = (getString(R.string.spinner_option_1));
                }else{
                    TextView textView =findViewById(R.id.choose_option);
                    textView.setText(getString(R.string.spinner_option_1));
                    spinner.setSelection(0);
                    relativeLayout.setVisibility(View.GONE);
                    extebsions[0] = "";
                }
            }
        });
        final CheckBox checkBoxballon =findViewById(R.id.check_box2_ballon);
        checkBoxballon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RelativeLayout relativeLayout =findViewById(R.id.ballon_view);
                if(checkBoxballon.isChecked()){
                    relativeLayout.setVisibility(View.VISIBLE);
                }else{
                    TextView textView =findViewById(R.id.choose_option_ballon);
                    textView.setText("");
                    RadioGroup radioGroup = findViewById(R.id.group_radio_button_ballon);
                    radioGroup.clearCheck();
                    relativeLayout.setVisibility(View.GONE);
                    extebsions[1]="";
                }
            }
        });
        RadioButton radio_button_heart = findViewById(R.id.radio_button_heart);
        RadioButton radio_button_regular = findViewById(R.id.radio_button_reguler);
        RadioButton radio_button_happy_birthday = findViewById(R.id.radio_button_happy_birthday);
        TextView textViewBallon = findViewById(R.id.choose_option_ballon);
        radio_button_happy_birthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewBallon.setText(getString(R.string.radio_button_1));
                extebsions[1]= getString(R.string.radio_button_1);
            }
        });
        radio_button_heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewBallon.setText(getString(R.string.radio_button_2));
                extebsions[1]= getString(R.string.radio_button_2);
            }
        });
        radio_button_regular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewBallon.setText(getString(R.string.radio_button_3));
                extebsions[1]= getString(R.string.radio_button_3);
            }
        });
        ImageButton endButton = findViewById(R.id.btn_end_order);
        endButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean existsExtensions = true;
                for (int j=0;(j<2)&&existsExtensions;j++){
                    if(!(extebsions[j].matches("")))
                        existsExtensions=false;
                }
                Boolean found=true;
                for(int i=0;(i<3)&&(found);i++){
                    if(!(countWhichFlower[i].matches("0"))){
                        Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                        intent.putExtra("string_count",countWhichFlower);
                        intent.putExtra("string_extebsions",extebsions);
                        intent.putExtra("string_details_customer",userName+" "+userAddress+" "+userPhone);
                        intent.putExtra("exists_extension",(!existsExtensions));
                        startActivity(intent);
                        found =false;
                    }
                }
                if(found){
                    Toast.makeText(SecondActivity.this, getString(R.string.note_to_the_end_button_order), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void change(TextView textView,String numberOfChoose,int place){
        if (numberOfChoose.matches("")) {
            textView.setText("0");
            countWhichFlower[place] = "0";
        } else {
            textView.setText(numberOfChoose + "");
            countWhichFlower[place] = numberOfChoose;

        }
    }
    @Override
    public void onClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(SecondActivity.this);
        final View customLayout = getLayoutInflater().inflate(R.layout.cunstom_layout, null);
        builder.setView(customLayout);
        if(v.getId() == R.id.btn_change_flower1){
            builder.setTitle(getString(R.string.alert_dialog_text_quantity)+" "+getString(R.string.first_flower)+":");
        }else if (v.getId() == R.id.btn_change_flower2){
            builder.setTitle(getString(R.string.alert_dialog_text_quantity)+" "+getString(R.string.second_flower)+":");
        }else{
            builder.setTitle(getString(R.string.alert_dialog_text_quantity)+" "+getString(R.string.third_flower)+":");
        }
        builder.setPositiveButton(getString(R.string.confirmation_of_quantity), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EditText editText = customLayout.findViewById(R.id.ed_text);
                String numberOfChoose = editText.getText().toString();
                switch (v.getId()){
                    case R.id.btn_change_flower1:{
                        TextView textView1 = findViewById(R.id.quantity_flower1_number);
                        change(textView1,numberOfChoose,0);
                        break;
                    }
                    case R.id.btn_change_flower2:{
                        TextView textView2 = findViewById(R.id.quantity_flower2_number);
                        change(textView2,numberOfChoose,1);
                        break;
                    }
                    case R.id.btn_change_flower3:{
                        TextView textView3 = findViewById(R.id.quantity_flower3_number);
                        change(textView3,numberOfChoose,2);
                        break;
                    }
                }
            }
        });
        builder.setCancelable(false);
        builder.show();
    }
}

