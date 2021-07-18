package com.domain.models.repos;

// import java.util.List;   

// import java.util.List;

import com.domain.models.entities.Youtube;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface YoutubeRepo extends PagingAndSortingRepository<Youtube, Long> {
    java.util.List<Youtube> findByTitleContains(String publishedAt);
    Page<Youtube> findByPublishedAtContains(String publishedAt, Pageable pageable);
}
