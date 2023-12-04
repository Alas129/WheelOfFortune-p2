package com.example.demo;

import com.google.cloud.spring.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

//Entity annotation to mark this class as a Datastore entity
@Entity(name = "likes")
public class Like {
    @Id
    Long id; //Unique identifier for the game
    Long gameId; //User ID associated with the game
    int likes; //Score achieved in the game

    // Constructor to initialize a Like with user ID, player name, score, and date
    public Like(Long gameId, int likes) {
        this.gameId = gameId;
        this.likes = likes;
    }

    // Getter and setter methods for each field
    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "Like{" +
                "id=" + id +
                ", gameId=" + gameId +
                ", likes=" + likes +
                '}';
    }
}
