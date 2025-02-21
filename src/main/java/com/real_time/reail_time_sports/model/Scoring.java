package com.real_time.reail_time_sports.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Scoring {
    @JsonProperty("times_tied")
    private int timesTied;

    @JsonProperty("lead_changes")
    private int leadChanges;

    @JsonProperty("home")
    private ScoringTeam home;

    @JsonProperty("away")
    private ScoringTeam away;
}
