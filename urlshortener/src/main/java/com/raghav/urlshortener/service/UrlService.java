package com.raghav.urlshortener.service;

import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.raghav.urlshortener.model.Url;
import com.raghav.urlshortener.repository.UrlRepository;

@Service
public class UrlService {

    private final UrlRepository urlRepository;
    public UrlService(UrlRepository urlRepository)
    {
        this.urlRepository=urlRepository;
    }

    private String generateCode()
    {
        String chars="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder code = new StringBuilder();
        Random rand=new Random();
        for(int i=0;i<6;i++)
        {
            code.append(chars.charAt(rand.nextInt(chars.length())));
        }
        return code.toString();
    }
    
    public String shorten(String originalUrl)
    {
        while(true)
        {
            String shortCode=generateCode();
            if(urlRepository.findByShortCode(shortCode).isEmpty())
            {
                Url url=new Url(shortCode,originalUrl);
                urlRepository.save(url);
                return shortCode;
            }
        }
    }

    public String getOriginalUrl(String shortCode)
    {
        Optional<Url> url=urlRepository.findByShortCode(shortCode);
        if(url.isEmpty())return null;
        return  url.get().getOriginalUrl();
    }
}
