package com.real_time.reail_time_sports.controller;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

import org.apache.tomcat.util.threads.VirtualThreadExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.real_time.reail_time_sports.backend.NbaGameService;
import com.real_time.reail_time_sports.data.DataService;
import com.real_time.reail_time_sports.model.PlayByPlayModel;
import com.real_time.reail_time_sports.thread.VirtualThreadExecutorFactory;


@RestController
public class GamePlayByPlay {
    private static final Logger log = LoggerFactory.getLogger(GamePlayByPlay.class);

    NbaGameService nbaGameService;
    WebClient webClient;
    DataService dataService;
    VirtualThreadExecutorFactory threadExecutor;

    @Autowired
    public GamePlayByPlay(NbaGameService nbaGameService, WebClient webClient, DataService dataService, VirtualThreadExecutorFactory threadExecutor) {
        this.nbaGameService = nbaGameService;
        this.webClient = webClient;
        this.dataService = dataService;
        this.threadExecutor = threadExecutor;
    }

    public void requestMethodName(@RequestParam String gameId) throws JsonProcessingException {
        try {
            //if not an API there should be some retreival process of gameId
            CompletableFuture<PlayByPlayModel> modelObject = threadExecutor.executeNbaGameServiceTask(nbaGameService,gameId);
            PlayByPlayModel entity = modelObject.get();
            dataService.savePlayByPlayModel(entity);
        } catch (Exception e) {
            log.error("exception in requestMethodName(): {}", e);
        }
       
    }
}
