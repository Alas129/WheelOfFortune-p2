package com.example.demo;

import com.google.cloud.spring.data.datastore.repository.DatastoreRepository;


// Interface extending DatastoreRepository for User entity with String as the ID type
public interface UserRepository extends DatastoreRepository<User, String> {
}
