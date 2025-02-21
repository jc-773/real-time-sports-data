package com.real_time.reail_time_sports.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Season {
    @JsonProperty("id")
    private String id;

    @JsonProperty("year")
    private int year;

    @JsonProperty("type")
    private String type;

    @JsonProperty("name")
    private String name;
}
