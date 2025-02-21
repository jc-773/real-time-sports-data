package com.real_time.reail_time_sports.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Period {
     @JsonProperty("type")
    private String type;

    @JsonProperty("id")
    private String id;

    @JsonProperty("number")
    private int number;

    @JsonProperty("sequence")
    private int sequence;

    @JsonProperty("scoring")
    private Scoring scoring;

    @JsonProperty("events")
    private List<Event> events;
}
