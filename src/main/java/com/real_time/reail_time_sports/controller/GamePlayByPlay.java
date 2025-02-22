package com.real_time.reail_time_sports.controller;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger log = LoggerFactory.getLogger(GamePlayByPlay.class);

    NbaGameService nbaGameService;
    WebClient webClient;
    DataService dataService;

    @Autowired
    public GamePlayByPlay(NbaGameService nbaGameService, WebClient webClient, DataService dataService) {
        this.nbaGameService = nbaGameService;
        this.webClient = webClient;
        this.dataService = dataService;
    }

    public void requestMethodName(@RequestParam String gameId) throws JsonProcessingException {
        try {
            CompletableFuture<PlayByPlayModel> modelObject = executeVirtualTask(gameId);
            PlayByPlayModel entity = modelObject.get();
            dataService.savePlayByPlayModel(entity);
        } catch (Exception e) {
            log.error("exception in requestMethodName(): {}", e);
        }
       
    }

    /*
     * 1. There is no semaphore in place for a thread to acquire access to a resource 
     * 2. Put this somewhre else
     */
    private CompletableFuture<PlayByPlayModel> executeVirtualTask(String gameId) {
        try(var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            executor.submit(()  -> {
                return nbaGameService.gamePlayByPlayRequestAsynchronous(gameId);
            });
        }
        return null;
    }
}
