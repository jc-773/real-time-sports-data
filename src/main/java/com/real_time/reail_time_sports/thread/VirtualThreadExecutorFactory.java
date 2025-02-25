package com.real_time.reail_time_sports.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Semaphore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.real_time.reail_time_sports.backend.NbaGameService;
import com.real_time.reail_time_sports.model.PlayByPlayModel;


public class VirtualThreadExecutorFactory {
    private static final Logger log = LoggerFactory.getLogger(VirtualThreadExecutorFactory.class);
    public static Semaphore semaphore;

    public VirtualThreadExecutorFactory(int n) {
        semaphore = new Semaphore(n);
    }

    public CompletableFuture<PlayByPlayModel> executeNbaGameServiceTask(NbaGameService nbaGameService, String gameId) throws InterruptedException {
        semaphore.acquire();
        try {
            return nbaGameService.gamePlayByPlayRequestAsynchronous(gameId).toFuture();
        } catch (Exception e) {
            log.error("Exception: {}", e);
            return CompletableFuture.failedFuture(e);
        }
        finally {
            semaphore.release();
        } 
    }
}
