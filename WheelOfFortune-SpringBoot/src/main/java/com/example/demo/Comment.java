package com.example.demo;

import com.google.cloud.spring.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

//Entity annotation to mark this class as a Datastore entity
@Entity(name = "comments")
public class Comment {
    @Id
    Long id; //Unique identifier for the comment
    Long gameId; //Unique identifier for the game record
    String playerName; //Commenter name
    String content; //Comment content
    LocalDate date; //Date when the comment created

    // Constructor to initialize a comment
    public Comment(Long gameId, String playerName, String content, LocalDate date) {
        this.gameId = gameId;
        this.playerName = playerName;
        this.content = content;
        this.date = date;
    }

    // Getter and setter methods for each field

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", gameId=" + gameId +
                ", playerName='" + playerName + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                '}';
    }
}
