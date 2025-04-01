package com.example.footballclubapp;

import java.io.Serializable;

public class Player implements Serializable {
    public int id;
    public String name;
    public String position;
    public int number;
    public String nationality;
    public String currentTeam;
    public String imageUrl;
    public String wikipediaUrl;

    public Player() {}

    public Player(int id, String name, String position, int number, String nationality, String currentTeam, String imageUrl, String wikipediaUrl) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.number = number;
        this.nationality = nationality;
        this.currentTeam = currentTeam;
        this.imageUrl = imageUrl;
        this.wikipediaUrl = wikipediaUrl;
    }
}
