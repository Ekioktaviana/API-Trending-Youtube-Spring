package com.domain.controllers;

import javax.validation.Valid;

import com.domain.dto.ResponseData;
import com.domain.dto.SearchData;
import com.domain.models.entities.Youtube;
import com.domain.services.YoutubeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/youtube")
public class YoutubeController {
    
    @Autowired
    private YoutubeService youtubeService;

    @PostMapping
    public ResponseEntity<ResponseData<Youtube>> create(@Valid @RequestBody Youtube youtube, Errors errors){

        ResponseData<Youtube> responseData = new ResponseData<>();

        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(youtubeService.save(youtube));
        return ResponseEntity.ok(responseData);
    }

    @GetMapping
    public Iterable<Youtube> findAll(){
        return youtubeService.findAll();
    }

    @GetMapping("/{id}")
    public Youtube findOne(@PathVariable("id") long id){
        return youtubeService.findOne(id);
    }

    @PutMapping
    public ResponseEntity<ResponseData<Youtube>> update(@Valid @RequestBody Youtube youtube, Errors errors){

        ResponseData<Youtube> responseData = new ResponseData<>();

        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(youtubeService.save(youtube));
        return ResponseEntity.ok(responseData);
    }

    @DeleteMapping("/{id}")
    public void removeOne(@PathVariable("id") long id){
        youtubeService.deleteById(id);
    }

    @PostMapping("search/bytitle")
    public java.util.List<Youtube> findByTitle(@RequestBody SearchData searchData){
        return youtubeService.findByTitle(searchData.getSearchKey());
    }

    @PostMapping("findall/{size}/{page}/{sort}")
    public Iterable<Youtube> findByPublishedAtContains(@RequestBody SearchData searchData, @PathVariable("size") int size, @PathVariable("page") int page, @PathVariable("sort") String sort){
        Pageable pageable = PageRequest.of(page, size, Sort.by("publishedAt").descending());
            if (sort.equalsIgnoreCase("desc")) {
                pageable = PageRequest.of(page, size, Sort.by("publishedAt").descending());
            }
        return youtubeService.findByPublishedAtContains(searchData.getSearchKey(), pageable);
    }
}
