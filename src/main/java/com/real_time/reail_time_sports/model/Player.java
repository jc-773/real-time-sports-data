package com.real_time.reail_time_sports.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Player {
    @JsonProperty("full_name")
    private String fullName;

    @JsonProperty("jersey_number")
    private String jerseyNumber;

    @JsonProperty("id")
    private String id;

    @JsonProperty("sr_id")
    private String srId;

    @JsonProperty("reference")
    private String reference;
}
