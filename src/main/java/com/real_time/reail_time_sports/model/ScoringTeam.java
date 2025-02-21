package com.real_time.reail_time_sports.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ScoringTeam {
    @JsonProperty("name")
    private String name;

    @JsonProperty("market")
    private String market;

    @JsonProperty("id")
    private String id;

    @JsonProperty("points")
    private int points;

    @JsonProperty("reference")
    private String reference;

    @JsonProperty("players")
    private List<Player> players;
}
