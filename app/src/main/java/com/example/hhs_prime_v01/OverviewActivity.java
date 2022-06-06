package com.example.hhs_prime_v01;
/**TODO Maak een nieuwe OverviewActivity aan.
 * Plaats twee buttons en een titel
 * De buttons starten middels een Intent de AddShowActivity en AddCharacterActivity
 * Wijs logische strings en id’s toe.
 * De list hoef je nog niet te plaatsen
 * De buttons starten middels een Intent de AddShowActivity en AddCharacterActivity
 * */
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import com.example.hhs_prime_v01.adapters.ShowAdapter;
import com.example.hhs_prime_v01.models.Show;

import java.util.List;
import java.util.Objects;

public class OverviewActivity extends AppCompatActivity {

    private ActivityResultLauncher<Intent> launcher;
    private RecyclerView recyclerView;
    private List<Show> shows;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);
        shows = Show.getAll(this);

        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {

                    @Override
                    public void onActivityResult(ActivityResult result) {
                        shows.clear();
                        shows.addAll(Show.getAll(getApplicationContext()));
                        recyclerView.getAdapter().notifyDataSetChanged();

                        System.out.println("The addCharacter activity is done");
                        if(result.getData() == null) return;

                        System.out.println(result.getData().getStringExtra("MESSAGE"));
                    }
                });

        shows = Show.getAll(this);

        recyclerView = findViewById(R.id.overview_list_rv_id);
        ShowAdapter adapter = new ShowAdapter(shows);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }


    public void showButton(View view) {

        Intent intent = new Intent(this,AddShowActivity.class);
        launcher.launch(intent);
        //startActivity(intent);
        System.out.println("Clicked on SHOW button");
    }

    public void characterButton(View view){
        Intent intent = new Intent(this,AddCharacterActivity.class);
        launcher.launch(intent);
        //startActivity(intent);
        System.out.println("Clicked ont CHARACTER button");
    }

}