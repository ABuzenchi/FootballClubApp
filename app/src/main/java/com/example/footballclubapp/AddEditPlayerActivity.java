package com.example.footballclubapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddEditPlayerActivity extends AppCompatActivity {

    private EditText editName, editPosition, editNumber, editNationality, editTeam, editImageUrl, editWikiUrl;
    private int editingPosition = -1;
    private Player existingPlayer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_player);

        editName = findViewById(R.id.editName);
        editPosition = findViewById(R.id.editPosition);
        editNumber = findViewById(R.id.editNumber);
        editNationality = findViewById(R.id.editNationality);
        editTeam = findViewById(R.id.editTeam);
        editImageUrl = findViewById(R.id.editImageUrl);
        editWikiUrl = findViewById(R.id.editWikiUrl);
        Button buttonSave = findViewById(R.id.buttonSave);

        Intent intent = getIntent();
        if (intent.hasExtra("player")) {
            existingPlayer = (Player) intent.getSerializableExtra("player");
            editingPosition = intent.getIntExtra("position", -1);

            // Pre-populează câmpurile
            editName.setText(existingPlayer.name);
            editPosition.setText(existingPlayer.position);
            editNumber.setText(String.valueOf(existingPlayer.number));
            editNationality.setText(existingPlayer.nationality);
            editTeam.setText(existingPlayer.currentTeam);
            editImageUrl.setText(existingPlayer.imageUrl);
            editWikiUrl.setText(existingPlayer.wikipediaUrl);
        }

        buttonSave.setOnClickListener(v -> {
            String name = editName.getText().toString();
            String position = editPosition.getText().toString();
            int number = Integer.parseInt(editNumber.getText().toString());
            String nationality = editNationality.getText().toString();
            String team = editTeam.getText().toString();
            String imageUrl = editImageUrl.getText().toString();
            String wikiUrl = editWikiUrl.getText().toString();

            Player newPlayer = new Player(0, name, position, number, nationality, team, imageUrl, wikiUrl);

            Intent resultIntent = new Intent();
            resultIntent.putExtra("player", newPlayer);
            resultIntent.putExtra("position", editingPosition);
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}
