package com.example.footballclubapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PlayerMoreDetailsActivity extends AppCompatActivity {
    private TextView textName, textPosition, textNumber, textNationality, textTeam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_more_details);

        textName = findViewById(R.id.textMoreName);
        textPosition = findViewById(R.id.textMorePosition);
        textNumber = findViewById(R.id.textMoreNumber);
        textNationality = findViewById(R.id.textMoreNationality);
        textTeam = findViewById(R.id.textMoreTeam);
        Button buttonWiki = findViewById(R.id.buttonOpenWiki);

        Player player = (Player) getIntent().getSerializableExtra("player");

        if (player != null) {
            textName.setText(player.name);
            textPosition.setText("Poziție: " + player.position);
            textNumber.setText("Număr: " + player.number);
            textNationality.setText("Naționalitate: " + player.nationality);
            textTeam.setText("Echipă actuală: " + player.currentTeam);
        }

        buttonWiki.setOnClickListener(v -> {
            Intent intent = new Intent(PlayerMoreDetailsActivity.this, PlayerWebActivity.class);
            intent.putExtra("wikipediaUrl", player.wikipediaUrl);
            startActivity(intent);
        });
    }
}
