package com.example.demo;

import com.google.cloud.spring.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;

@Entity(name = "users")
public class User {
    @Id
    String userId;// Unique identifier for the user
    String playerName;// Player name associated with the user

    // Constructor to initialize User with userId and playerName
    public User(String userId, String playerName) {
        this.userId = userId;
        this.playerName = playerName;
    }

    // Getter and setter methods for each field

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    // Override toString() method to provide a string representation of the User object
    @Override
    public String toString() {
        return "User{" +
                ", userId='" + userId + '\'' +
                ", playerName='" + playerName + '\'' +
                '}';
    }
}
