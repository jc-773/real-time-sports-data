package com.real_time.reail_time_sports.data.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.real_time.reail_time_sports.model.PlayByPlayModel;

@Document(collection="PlayByPlayCollection")
public class PlayByPlayDocument {
    @Id
    private String gameId;

    private PlayByPlayModel playByPlayModel;

    public PlayByPlayModel getPlayByPlayModel() {
        return playByPlayModel;
    }

    public void setPlayByPlayModel(PlayByPlayModel playByPlayModel) {
        this.playByPlayModel = playByPlayModel;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }
}
