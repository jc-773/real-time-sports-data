package com.real_time.reail_time_sports.model;

import com.fasterxml.jackson.annotation.JsonProperty;

//TODO:There are dozens of event types, map out all of the event types and their fields to this file. Then mark ignore if null
public class Event {
    @JsonProperty("id")
    private String id;

    @JsonProperty("clock")
    private String clock;

    @JsonProperty("updated")
    private String updated;

    @JsonProperty("description")
    private String description;

    @JsonProperty("wall_clock")
    private String wallClock;

    @JsonProperty("sequence")
    private long sequence;

    @JsonProperty("home_points")
    private int homePoints;

    @JsonProperty("away_points")
    private int awayPoints;

    @JsonProperty("clock_decimal")
    private String clockDecimal;

    @JsonProperty("created")
    private String created;

    @JsonProperty("number")
    private int number;

    @JsonProperty("event_type")
    private String eventType;

    @JsonProperty("duration")
    private int duration;

    @JsonProperty("attribution")
    private Team attribution;

    @JsonProperty("on_court")
    private OnCourt onCourt;
}
