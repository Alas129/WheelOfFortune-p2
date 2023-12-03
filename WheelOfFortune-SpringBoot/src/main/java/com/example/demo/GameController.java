package com.example.demo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RestController

public class GameController {
    private final GameRepository gameRepository;

    // Constructor injection for GameRepository
    public GameController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    // Endpoint to save a game record
    @PostMapping("/saveGame")
    @CrossOrigin(origins = "*")
    public String saveGame(@RequestBody Game game) {
        if (game == null) {
            return "The game is invalid";
        }
        game.setDate(LocalDate.now());
        this.gameRepository.save(game);
        return "success";
    }


    // Endpoint to find all games with pagination and sorting by score in descending order
    @GetMapping("/findAllGames")
    @ResponseBody
    @CrossOrigin(origins = "*")
    public Page<Game> findAllGames(@RequestParam int page, @RequestParam int size) {
        PageRequest pageable = PageRequest.of(page, size);
        return gameRepository.findAllByOrderByScoreDesc(pageable);
    }

    // Endpoint to find games by user ID with pagination and sorting by score in descending order
    @GetMapping("/findGameByUserId")
    @ResponseBody
    @CrossOrigin(origins = "*")
    public Page<Game> findGameByUserId(@RequestParam String userId, @RequestParam int page, @RequestParam int size){
        PageRequest pageable = PageRequest.of(page, size);
        return this.gameRepository.findAllByUserIdOrderByScoreDesc(userId,pageable);
    }

    // Endpoint to delete a game by its ID
    @GetMapping("/deleteGameById")
    @ResponseBody
    @CrossOrigin(origins = "*")
    public String deleteGameById(@RequestParam Long id){
        this.gameRepository.deleteById(id);
        return "success";
    }

    // Endpoint to update player name for games associated with a specific user ID
    @GetMapping("/updatePlayerNameByUserId")
    @ResponseBody
    @CrossOrigin(origins = "*")
    public void updatePlayerNameByUserId(@RequestParam String userId, @RequestParam String newPlayerName){
        Iterable<Game> games = this.gameRepository.findByUserId(userId);
        for(Game game: games){
            game.setPlayerName(newPlayerName);
        }
        this.gameRepository.saveAll(games);
    }

}
