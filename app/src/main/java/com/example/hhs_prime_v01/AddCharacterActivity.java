package com.example.hhs_prime_v01;

import com.example.hhs_prime_v01.models.Character;
import com.example.hhs_prime_v01.models.Show;


import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * TODO: Zorg dat de buttons in AddShowActivity en AddCharacterActivity het volgende doen:
 * Save: maakt een object van de klasse Show danwel Character aan.
 * Let op input validatie
 * Voor de geboortedatum heb je een formatter nodig (literatuur)
 * Zorg dat daarna de activity gesloten (finish) wordt
 * Cancel: finisht de huidige activity. Heeft verder geen logica nodig.
 */


public class AddCharacterActivity extends AppCompatActivity {
    private ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_character);

        Button save = findViewById(R.id.save_character_btn_id);
        Button cancel = findViewById(R.id.cancel_character_btn_id);

//        Intent intent = getIntent();
//        Character character = (Character) intent.getSerializableExtra("CHARACTER");
//
//        if (character != null) {
//           // EditText nameET = findViewById(R.id.add_character_name_et_id);
//           // nameET.setText(Character.getName(this));
//        }

        save.setOnClickListener(this::save);
        cancel.setOnClickListener(this::cancel);

        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        System.out.println("The AddCharacter activity is done");
                        System.out.println(result.getData().getStringExtra("MESSAGE"));
                    }
                });
    }

    public void save(View view) {
        EditText nameET = findViewById(R.id.add_character_name_et_id);
        EditText dobEt = findViewById(R.id.add_character_date_et_id);

        if (Validator.inputValidString(nameET.getText().toString())) {
            String name = nameET.getText().toString();

            @SuppressLint("SimpleDateFormat") SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date date = null;
            try {
                date = formatter.parse(dobEt.getText().toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }

            Character character = new Character(name, date);
            Character.add(character, this);
            //Character.add(character);

            Intent intent = new Intent(this, OverviewActivity.class);
            launcher.launch(intent);

            finish();

        } else {
            System.out.println("Me");
        }
    }


    public void cancel(View view) {
        finish();
    }

}