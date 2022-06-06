package com.example.hhs_prime_v01;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.hhs_prime_v01.models.Character;
import com.example.hhs_prime_v01.models.Show;

import java.util.ArrayList;

public class AddShowActivity extends AppCompatActivity {

    private ActivityResultLauncher<Intent> launcher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_show);

        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        System.out.println("The AddCharacter activity is done");
                        System.out.println(result.getData().getStringExtra("MESSAGE"));
                    }
                });


        Spinner spinner = findViewById(R.id.add_show_character_sp_id);

        ArrayAdapter<Character> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                Character.getAll(this));
                //Character.getAll());
        spinner.setAdapter(adapter);
    }


    public void save(View view) {
        EditText nameET = findViewById(R.id.add_show_name_et_id);
        EditText seasonsET = findViewById(R.id.add_show_seasons_et_id);
        Spinner spinner = findViewById(R.id.add_show_character_sp_id);

        if (Validator.inputValidString(nameET.getText().toString())) {

            String nameString = nameET.getText().toString();
            String seasonsString = seasonsET.getText().toString();



            if (Validator.isNumeric(seasonsString)) {
                int seasonsInt = Integer.parseInt(seasonsString); /** This is a int not an Integer  */
                Show show = new Show(nameString, seasonsInt); //TODO add character

                // using the selected item from the spinner
                Character character = (Character) spinner.getSelectedItem();
               show.setCharacterId(character.getId());


                Show.add(show, this);

                Toast.makeText(this, "Binnenste element added", Toast.LENGTH_LONG).show();


                Intent intent = new Intent(this, OverviewActivity.class);
                launcher.launch(intent);



            } else {
                Toast.makeText(this, R.string.invalid, Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, "Buitenste else statement in AddShowActivity", Toast.LENGTH_LONG).show();
        }
    }

    public void cancel(View view) {

        EditText characterET = findViewById(R.id.add_show_name_et_id); /** is it show or character that needs to be placed here??*/
        Intent intent = new Intent(this, OverviewActivity.class);
                launcher.launch(intent);

        finish();
    }


}

