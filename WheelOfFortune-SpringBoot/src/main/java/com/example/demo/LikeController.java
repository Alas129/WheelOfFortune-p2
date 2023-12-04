package com.example.demo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController

public class LikeController {
    private final LikeRepository likeRepository;

    // Constructor injection for GameRepository
    public LikeController(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }


    @PostMapping("/saveLike")
    @CrossOrigin(origins = "*")
    public String saveLike(@RequestBody Like like) {
        Optional<Like> foundLike =  this.likeRepository.findByGameIdAndUserId(like.gameId, like.userId);
        if(foundLike.isPresent()) {
            System.out.println("Enter the delete function");
            this.likeRepository.deleteByGameIdAndUserId(like.gameId, like.userId);
            return "delete";
        }else{
            this.likeRepository.save(like);
        }
        return "success";
    }

    @PostMapping("/getLikesByGameIds")
    @ResponseBody
    @CrossOrigin(origins = "*")
    public  List<Integer> getLikesByGameId (@RequestBody List<Long> gameIds) {
        List<Integer> list = new ArrayList<>();
        for (Long gameId: gameIds) {
            list.add(this.likeRepository.countByGameId(gameId));
        }
        return list;
    }

}
