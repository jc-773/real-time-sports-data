package com.real_time.reail_time_sports.backend;

import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NbaGameService {

    RestTemplateService restTemplateService;

    @Autowired
    public NbaGameService(RestTemplateService restTemplateService) {
        this.restTemplateService = restTemplateService;
    }

    public <T> T gamePlayByPlayRequest(Class<T> clazz, String gameID) {
        String url = "https://api.sportradar.com/nba/trial/v8/en/games/"+ gameID +"/pbp.json?api_key=";//add api key to secret
        Hashtable<String, String> customHeaders = new Hashtable<String, String>();
        customHeaders.put("Accept", "*/*");
        customHeaders.put("User-Agent", "PostmanRuntime/7.31.3");
        customHeaders.put("Referer", "https://www.nba.com/");
        return (T) restTemplateService.getForObjectResponse(clazz, url, customHeaders);
    }
}
