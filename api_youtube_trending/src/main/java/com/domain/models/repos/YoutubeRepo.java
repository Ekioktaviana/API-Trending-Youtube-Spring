package com.domain.models.repos;

// import java.util.List;

import com.domain.models.entities.Youtube;

import org.springframework.data.repository.CrudRepository;

public interface YoutubeRepo extends CrudRepository<Youtube, Long> {

    // List<Youtube> findByNameContains(String name);
    
}
