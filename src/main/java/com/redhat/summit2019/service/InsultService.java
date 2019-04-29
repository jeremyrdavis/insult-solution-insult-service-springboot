package com.redhat.summit2019.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.redhat.summit2019.model.Adjective;
import com.redhat.summit2019.model.Insult;
import com.redhat.summit2019.model.Noun;

@Path("/insult")
@Component
public class InsultService {

    @Autowired
    AdjectiveService adjectiveService;

    @Autowired
    NounService nounService;

    @GET
    @Produces("application/json")
    public String insult() {

        Adjective adjective1 = adjectiveService.getAdjective();
        Adjective adjective2 = adjectiveService.getAdjective();
        Noun noun = nounService.getNoun();

        return new Insult(adjective1, adjective2, noun).toString();
    }
}
