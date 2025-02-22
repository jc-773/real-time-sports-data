package com.real_time.reail_time_sports.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.real_time.reail_time_sports.backend.NbaGameService;
import com.real_time.reail_time_sports.data.DataService;
import com.real_time.reail_time_sports.model.PlayByPlayModel;

import reactor.core.publisher.Mono;


@RestController
public class GamePlayByPlay {
    
    NbaGameService nbaGameService;
    WebClient webClient;
    DataService dataService;

    @Autowired
    public GamePlayByPlay(NbaGameService nbaGameService, WebClient webClient, DataService dataService) {
        this.nbaGameService = nbaGameService;
        this.webClient = webClient;
        this.dataService = dataService;
    }

    @RequestMapping(value="/game/playbyplay", method=RequestMethod.GET)
    public PlayByPlayModel requestMethodName(@RequestParam String gameId) throws JsonProcessingException {
        HashMap<String, PlayByPlayModel> map = castResponseFromGameService(gameId);
        //Mono<PlayByPlayModel> modelObject = makeAsynchronousFetch(gameId);
        PlayByPlayModel entity = flattenMap(map);
        dataService.savePlayByPlayModel(entity);
        return entity;
    }

    private <T> PlayByPlayModel flattenMap(HashMap<String, PlayByPlayModel> map) throws JsonProcessingException  {
        ObjectMapper mapper = new ObjectMapper();
        String playerStatsJsonString = new ObjectMapper().writeValueAsString(map);
        return mapper.readValue(playerStatsJsonString, PlayByPlayModel.class);
    }

    private Mono<PlayByPlayModel> makeAsynchronousFetch(String gameId) {
        return nbaGameService.gamePlayByPlayRequest(gameId);
    }
    
    private <T> T castResponseFromGameService(String gameId) {
        //TODO: Create a model for the response
        return (T) nbaGameService.gamePlayByPlayRequest(null, gameId);
    }
}
