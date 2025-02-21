package com.real_time.reail_time_sports.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OnCourt {
    @JsonProperty("home")
    private ScoringTeam home;

    @JsonProperty("away")
    private ScoringTeam away;
}
