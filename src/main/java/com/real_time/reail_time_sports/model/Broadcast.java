package com.real_time.reail_time_sports.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Broadcast {
    @JsonProperty("type")
    private String type;
    
    @JsonProperty("locale")
    private String locale;
    
    @JsonProperty("network")
    private String network;
    
    @JsonProperty("channel")
    private String channel;
}
