package com.real_time.reail_time_sports.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.real_time.reail_time_sports.backend.NbaGameService;
import com.real_time.reail_time_sports.model.PlayByPlayModel;


@RestController
public class GamePlayByPlay {
    
    NbaGameService nbaGameService;

    @Autowired
    public GamePlayByPlay(NbaGameService nbaGameService) {
        this.nbaGameService = nbaGameService;
    }

    @RequestMapping(value="/game/playbyplay", method=RequestMethod.GET)
    public PlayByPlayModel requestMethodName(@RequestParam String gameId) throws JsonProcessingException {
        HashMap<String, PlayByPlayModel> map = castResponseFromGameService(gameId);
        PlayByPlayModel entity = flattenMap(map);
        return entity;
    }

    private <T> PlayByPlayModel flattenMap(HashMap<String, PlayByPlayModel> map) throws JsonProcessingException  {
        ObjectMapper mapper = new ObjectMapper();
        String playerStatsJsonString = new ObjectMapper().writeValueAsString(map);
        return mapper.readValue(playerStatsJsonString, PlayByPlayModel.class);
    }
    
    private <T> T castResponseFromGameService(String gameId) {
        //TODO: Create a model for the response
        return (T) nbaGameService.gamePlayByPlayRequest(null, gameId);
    }
}
