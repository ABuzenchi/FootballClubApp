package com.example.footballclubapp;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder> {
    private List<Player> playerList;
    private Context context;

    public PlayerAdapter(Context context, List<Player> players) {
        this.context = context;
        this.playerList = players;
    }

    @NonNull
    @Override
    public PlayerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.player_item, parent, false);
        return new PlayerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerViewHolder holder, int position) {
        Player player = playerList.get(position);
        holder.nameText.setText(player.name);
        holder.positionText.setText(player.position + " - #" + player.number);

        // Imagine din link – folosim Glide (poți adăuga Glide în Gradle)
        Glide.with(context).load(player.imageUrl).into(holder.imageView);
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, PlayerDetailActivity.class);
            intent.putExtra("player", player);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return playerList.size();
    }

    static class PlayerViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView nameText, positionText;

        public PlayerViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imagePlayer);
            nameText = itemView.findViewById(R.id.textPlayerName);
            positionText = itemView.findViewById(R.id.textPlayerPosition);
        }
    }
}