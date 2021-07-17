package com.domain.models.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
// import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity(name = "trendings")
// @Table
public class Youtube implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    
    @NotEmpty(message = "Channel ID is required")
    @Column(name = "channelId", length = 255)
    private String channelId;

    @NotEmpty(message = "Title is required")
    @Column(name = "title", length = 255)
    private String title;
    
    @NotEmpty(message = "Channel Title is required")
    @Column(name = "channelTitle", length = 255)
    private String channelTitle;
    
    @NotEmpty(message = "Published At is required")
    @Column(name = "publishedAt", length = 255)
    private String publishedAt;

    public Youtube() {
    }

    public Youtube(long id, @NotEmpty(message = "Channel ID is required") String channelId,
            @NotEmpty(message = "Title is required") String title,
            @NotEmpty(message = "Channel Title is required") String channelTitle,
            @NotEmpty(message = "Published At is required") String publishedAt) {
        this.id = id;
        this.channelId = channelId;
        this.title = title;
        this.channelTitle = channelTitle;
        this.publishedAt = publishedAt;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getChannelTitle() {
        return channelTitle;
    }

    public void setChannelTitle(String channelTitle) {
        this.channelTitle = channelTitle;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    
}
