package com.example.demo;
import java.util.List;

import com.google.cloud.spring.data.datastore.repository.DatastoreRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GameRepository extends PagingAndSortingRepository<Game, Long >, DatastoreRepository<Game, Long > {

    // Find all games with pagination and sorting by score in descending order
    Page<Game> findAllByOrderByScoreDesc(Pageable pageable);

    // Find games by user ID with pagination and sorting by score in descending order
    Page<Game> findAllByUserIdOrderByScoreDesc(String userId, Pageable pageable);

    // Find games by user ID without pagination
    List<Game> findByUserId(String userId);

    void deleteByUserId(String userId);
}