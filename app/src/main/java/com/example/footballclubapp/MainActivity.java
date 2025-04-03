package com.example.footballclubapp;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private PlayerAdapter adapter;
    private List<Player> playerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerViewPlayers);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        if (PlayerStorageHelper.dataExists(this)) {
            playerList = PlayerStorageHelper.loadPlayers(this);
        } else {
            playerList = PlayerStorageHelper.loadInitialPlayersFromAssets(this);
            PlayerStorageHelper.savePlayers(this, new ArrayList<>(playerList));
        }

        adapter = new PlayerAdapter(this, playerList);
        recyclerView.setAdapter(adapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (playerList != null) {
            playerList.clear();
            playerList.addAll(PlayerStorageHelper.loadPlayers(this));
            adapter.notifyDataSetChanged();
        }
    }
}
