package com.redhat.summit2019.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.redhat.summit2019.model.Noun;

@Service
public class NounService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String nounHost = System.getProperty("noun.host", "http://insult-nouns:8080");

    public Noun getNoun() {
        return restTemplate.getForObject(nounHost + "/api/noun", Noun.class);
    }
}