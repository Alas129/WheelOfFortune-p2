package com.example.demo;

import com.google.cloud.spring.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

//Entity annotation to mark this class as a Datastore entity
@Entity(name = "games")
public class Game {
    @Id
    Long id; //Unique identifier for the game
    String userId; //User ID associated with the game
    String playerName; //Player name associated with the game
    int score; //Score achieved in the game
    LocalDate date; //Date when the game wa played

    // Constructor to initialize a game with user ID, player name, score, and date
    public Game(String userId, String playerName, int score, LocalDate date) {
        this.userId = userId;
        this.playerName = playerName;
        this.score = score;
        this.date = date;
    }

    // Getter and setter methods for each field

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    // toString method to provide a string representation of the Game object
    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", playerName='" + playerName + '\'' +
                ", score=" + score +
                ", date=" + date +
                '}';
    }
}
