package com.real_time.reail_time_sports.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Team {
    @JsonProperty("name")
    private String name;

    @JsonProperty("alias")
    private String alias;

    @JsonProperty("market")
    private String market;

    @JsonProperty("id")
    private String id;

    @JsonProperty("points")
    private int points;

    @JsonProperty("sr_id")
    private String srId;

    @JsonProperty("remaining_timeouts")
    private int remainingTimeouts;

    @JsonProperty("reference")
    private String reference;
}
