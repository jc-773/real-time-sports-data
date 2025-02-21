package com.real_time.reail_time_sports.model;

import java.time.Period;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayByPlayModel {
    @JsonProperty("id")
    private String id;
    
    @JsonProperty("status")
    private String status;
    
    @JsonProperty("coverage")
    private String coverage;
    
    @JsonProperty("scheduled")
    private String scheduled;
    
    @JsonProperty("lead_changes")
    private int leadChanges;
    
    @JsonProperty("times_tied")
    private int timesTied;
    
    @JsonProperty("track_on_court")
    private boolean trackOnCourt;
    
    @JsonProperty("reference")
    private String reference;
    
    @JsonProperty("entry_mode")
    private String entryMode;
    
    @JsonProperty("sr_id")
    private String srId;
    
    @JsonProperty("broadcasts")
    private List<Broadcast> broadcasts;
    
    @JsonProperty("time_zones")
    private Map<String, String> timeZones;
    
    @JsonProperty("season")
    private Season season;
    
    @JsonProperty("home")
    private Team home;
    
    @JsonProperty("away")
    private Team away;
    
    @JsonProperty("periods")
    private List<Object> periods;
}
