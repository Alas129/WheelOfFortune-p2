package com.example.demo;

import com.google.cloud.spring.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

//Entity annotation to mark this class as a Datastore entity
@Entity(name = "comments")
public class Comment {
    @Id
    Long id; //Unique identifier for the comment
    Long gameId; //Game ID associated with the comment
    String userId; //User ID associated with the comment
    String comments; //comments in the game
    LocalDate date; //Date of the comment

    // Constructor to initialize a Like with user ID, player name, score, and date
    public Comment(Long gameId, String userId, String comments, LocalDate date) {
        this.gameId = gameId;
        this.userId = userId;
        this.comments = comments;
        this.date = date;
    }

    // Getter and setter methods for each field
    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
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
                ", userId='" + userId + '\'' +
                ", comments='" + comments + '\'' +
                ", date=" + date +
                '}';
    }
}
