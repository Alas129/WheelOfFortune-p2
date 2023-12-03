package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
public class UserController {
    private final UserRepository userRepository;

    // Constructor injection for userRepository dependency
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Endpoint to save a user
    @PostMapping("/saveUser")
    @CrossOrigin(origins = "*")
    public String saveUser(@RequestBody User user) {
        if (user == null) {
            return "The user is invalid";
        }

        // Save the user in the repository
        this.userRepository.save(user);
        return "success";
    }

    // Endpoint to find the player name by user ID
    @GetMapping("/findPlayerNameByUserId")
    @ResponseBody
    @CrossOrigin(origins = "*")
    public String findPlayerNameByUserId(@RequestParam String userId){
        Optional<User> user = this.userRepository.findById(userId);
        if (user.isPresent()) {

            // If user is present, return the player name
            return user.get().getPlayerName();
        }

        //If user is not present, return an empty string
        return "";
    }

}
