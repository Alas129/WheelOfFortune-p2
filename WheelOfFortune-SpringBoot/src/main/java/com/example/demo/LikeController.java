package com.example.demo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController

public class LikeController {
    private final LikeRepository likeRepository;

    // Constructor injection for GameRepository
    public LikeController(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    // Endpoint to find all likes of a game.
    @GetMapping("/findLikes")
    @ResponseBody
    @CrossOrigin(origins = "*")
    public int findLikes(@RequestParam long gameId) {
        return likeRepository.findAllByOrderByScoreDesc(gameId);
    }

}
