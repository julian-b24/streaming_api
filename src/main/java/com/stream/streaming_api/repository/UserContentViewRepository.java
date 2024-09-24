package com.stream.streaming_api.repository;

import com.stream.streaming_api.model.UserContentView;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserContentViewRepository extends CrudRepository<UserContentView, UUID> {

    @Query
    List<UserContentView> findByContentId(UUID contentId);

}
