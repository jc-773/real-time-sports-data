package com.real_time.reail_time_sports.backend;

import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.real_time.reail_time_sports.model.PlayByPlayModel;

import reactor.core.publisher.Mono;

@Service
public class NbaGameService {

    RestTemplateService restTemplateService;

    @Value("${api.key}")
    private String apiKey;

    @Autowired
    public NbaGameService(RestTemplateService restTemplateService) {
        this.restTemplateService = restTemplateService;
    }

    public Mono<PlayByPlayModel> gamePlayByPlayRequestAsynchronous(String gameId) {
        WebClient webClient = WebClient.create();
        return webClient.get()
            .uri("https://api.sportradar.com/nba/trial/v8/en/games/\"+ gameID +\"/pbp.json?api_key=")
            .header(null, null)
            .retrieve()
            .bodyToMono(PlayByPlayModel.class);
    }

    //Using the HTTP client -RestTemplate- is synchronous and therefor its blocking calls would contradict the whole implementation of virtual threads
    @Deprecated
    public <T> T gamePlayByPlayRequest(Class<T> clazz, String gameID) {
        String url = "https://api.sportradar.com/nba/trial/v8/en/games/"+ gameID +"/pbp.json?api_key=" + apiKey;//add api key to secret
        Hashtable<String, String> customHeaders = new Hashtable<String, String>();
        customHeaders.put("Accept", "*/*");
        customHeaders.put("User-Agent", "PostmanRuntime/7.31.3");
        customHeaders.put("Referer", "https://www.nba.com/");
        return (T) restTemplateService.getForObjectResponse(clazz, url, customHeaders);
    }
}
