package com.example.footballclubapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class PlayerDetailActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView nameText, positionText, nationalityText;
    private Button buttonMoreDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_detail);

        imageView = findViewById(R.id.imagePlayerDetail);
        nameText = findViewById(R.id.textNameDetail);
        positionText = findViewById(R.id.textPositionDetail);
        nationalityText = findViewById(R.id.textNationalityDetail);
        buttonMoreDetails = findViewById(R.id.buttonMoreDetails);

        Player player = (Player) getIntent().getSerializableExtra("player");

        if (player != null) {
            nameText.setText(player.name);
            positionText.setText(player.position + " - #" + player.number);
            nationalityText.setText("Naționalitate: " + player.nationality);

            Glide.with(this).load(player.imageUrl).into(imageView);

            buttonMoreDetails.setOnClickListener(v -> {
                Intent intent = new Intent(PlayerDetailActivity.this, PlayerMoreDetailsActivity.class);
                intent.putExtra("player", player);
                startActivity(intent);
            });
        }
    }
}
