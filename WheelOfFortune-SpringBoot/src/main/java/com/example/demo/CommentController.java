package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class CommentController {

    private final CommentRepository commentRepository;

    public CommentController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
    @PostMapping("/saveComment")
    @CrossOrigin(origins = "*")
    public String saveComment(@RequestBody Comment comment) {
        if (comment == null) {
            return "The comment is invalid";
        }
        comment.setDate(LocalDate.now());
        this.commentRepository.save(comment);
        return "success";
    }

    @GetMapping("/findByGameId")
    @CrossOrigin(origins = "*")
    public List<Comment> findByGameId(@RequestParam Long gameId){
        return this.commentRepository.findByGameId(gameId);
    }
}
