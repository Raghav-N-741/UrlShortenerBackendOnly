package com.raghav.urlshortener.controller;

import org.springframework.web.bind.annotation.RestController;

import com.raghav.urlshortener.service.UrlService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class UrlController {

    private final UrlService urlService;
    public UrlController(UrlService urlService)
    {
        this.urlService=urlService;
    }

    @PostMapping("/shorten")
    public String shorten(@RequestBody String originalUrl) {
        return urlService.shorten(originalUrl);
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> getOriginalUrl(@PathVariable String shortCode) {
        String originalUrl=urlService.getOriginalUrl(shortCode);
        if(originalUrl==null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(302).location(URI.create(originalUrl)).build();
    }
    
    
}
