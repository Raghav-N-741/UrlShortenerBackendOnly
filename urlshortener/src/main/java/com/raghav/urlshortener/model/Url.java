package com.raghav.urlshortener.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
public class Url {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String shortCode;
    private String originalUrl;

    
    public Url(String shortCode, String originalUrl) {
        this.shortCode = shortCode;
        this.originalUrl = originalUrl;
    }


    public String getShortCode() {
        return shortCode;
    }


    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }


    public String getOriginalUrl() {
        return originalUrl;
    }


    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }
   
    
}
