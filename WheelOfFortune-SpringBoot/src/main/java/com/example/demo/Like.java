package com.example.demo;

import com.google.cloud.spring.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.List;

//Entity annotation to mark this class as a Datastore entity
@Entity(name = "likes")
public class Like {
    @Id
    Long id;
    Long gameId; //Game ID associated with the like

    String userId; // User who like this game record

    public Like(Long gameId, String userId) {
        this.gameId = gameId;
        this.userId = userId;
    }

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Like{" +
                ", gameId=" + gameId +
                ", userId='" + userId + '\'' +
                '}';
    }
}
