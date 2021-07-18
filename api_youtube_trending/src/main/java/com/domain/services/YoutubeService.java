package com.domain.services;

import java.util.Optional;

import javax.transaction.Transactional;

import com.domain.models.entities.Youtube;
import com.domain.models.repos.YoutubeRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

// import antlr.collections.List;

// import net.bytebuddy.TypeCache.Sort;

@Service
@Transactional
public class YoutubeService {
    
    @Autowired
    private YoutubeRepo youtubeRepo;

    public Iterable<Youtube> findAll(){
        return youtubeRepo.findAll();
    }

    public Youtube findOne(long id){
        Optional<Youtube> youtube = youtubeRepo.findById(id);
        if (!youtube.isPresent()) {
            return null;
        }
        return youtube.get();
    }

    public Youtube save(Youtube youtube){
        return youtubeRepo.save(youtube);
    }

    public void deleteById(long id){
        youtubeRepo.deleteById(id);
    }

    public java.util.List<Youtube> findByTitle(String title){
        return youtubeRepo.findByTitleContains(title);
    }

    public Iterable<Youtube> findByPublishedAtContains(String publishedAt, Pageable pageable){
        return youtubeRepo.findByPublishedAtContains(publishedAt, pageable);
    }

}
