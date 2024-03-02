package com.ms.posts.repositories;

import com.ms.posts.documents.PostDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepository extends MongoRepository<PostDocument, String> {
}
