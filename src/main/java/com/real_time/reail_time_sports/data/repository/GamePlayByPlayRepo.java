package com.real_time.reail_time_sports.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.real_time.reail_time_sports.data.document.PlayByPlayDocument;

@Repository
public interface GamePlayByPlayRepo extends MongoRepository<PlayByPlayDocument, String> {
    
}
