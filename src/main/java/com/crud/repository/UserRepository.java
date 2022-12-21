package com.crud.repository;

import com.crud.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String>{
    User findUserByUserId(String userId);

    void deleteByUserId(String userId);
}