package com.redhat.summit2019.service;

import com.redhat.summit2019.model.Adjective;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AdjectiveService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String adjectiveHost = System.getProperty("adjective.host", "http://insult-adjectives:8080");

    public Adjective getAdjective() {
        return restTemplate.getForObject(adjectiveHost + "/api/adjective", Adjective.class);
    }
}
