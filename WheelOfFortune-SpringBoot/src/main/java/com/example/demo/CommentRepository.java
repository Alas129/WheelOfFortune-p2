package com.example.demo;

import com.google.cloud.spring.data.datastore.repository.DatastoreRepository;


// Interface extending DatastoreRepository for Like entity with Long as the ID type
public interface CommentRepository extends DatastoreRepository<Comment, Long> {
    // Find comments by game id
    Comment findCommentByGameId(Long gameId);
    // Find comments by user id
    Comment findUserByGameId(String user);
}
