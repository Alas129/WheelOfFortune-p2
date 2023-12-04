package com.example.demo;
import java.util.List;

import com.google.cloud.spring.data.datastore.repository.DatastoreRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommentRepository extends DatastoreRepository<Comment, Long> {

    List<Comment> findByGameId(Long gameId);
}
