package com.example.demo;

import com.google.cloud.spring.data.datastore.repository.DatastoreRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;


// Interface extending DatastoreRepository for Like entity with Long as the ID type
public interface LikeRepository extends DatastoreRepository<Like, Long> {
    // Find likes number by game id
    int  countByGameId(Long gameId);

    Optional<Like> findByGameIdAndUserId(Long gameId, String userId);


    void deleteByGameIdAndUserId(Long gameId, String userId);
}
