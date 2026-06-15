package com.raghav.urlshortener.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raghav.urlshortener.model.Url;


public interface UrlRepository extends JpaRepository<Url,Long> {

    Optional<Url> findByShortCode(String shortCode);
} 
