package com.real_time.reail_time_sports.model;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayByPlayModel {
    @JsonProperty("id")
    public String id;
    
    @JsonProperty("status")
    public String status;
    
    @JsonProperty("coverage")
    public String coverage;
    
    @JsonProperty("scheduled")
    public String scheduled;
    
    @JsonProperty("lead_changes")
    public int leadChanges;
    
    @JsonProperty("times_tied")
    public int timesTied;
    
    @JsonProperty("track_on_court")
    public boolean trackOnCourt;
    
    @JsonProperty("reference")
    public String reference;
    
    @JsonProperty("entry_mode")
    public String entryMode;
    
    @JsonProperty("sr_id")
    public String srId;
    
    @JsonProperty("broadcasts")
    public List<Broadcast> broadcasts;
    
    @JsonProperty("time_zones")
    public Map<String, String> timeZones;
    
    @JsonProperty("season")
    public Season season;
    
    @JsonProperty("home")
    public Team home;
    
    @JsonProperty("away")
    public Team away;
    
    @JsonProperty("periods")
    public List<Object> periods;
}
