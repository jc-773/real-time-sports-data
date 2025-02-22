package com.real_time.reail_time_sports.data;

import org.springframework.stereotype.Service;

import com.real_time.reail_time_sports.data.document.PlayByPlayDocument;
import com.real_time.reail_time_sports.data.repository.GamePlayByPlayRepo;
import com.real_time.reail_time_sports.model.PlayByPlayModel;

@Service
public class DataService {
    private GamePlayByPlayRepo gamePlayByPlayRepo;

    public void savePlayByPlayModel(PlayByPlayModel playByPlayModel) {
        PlayByPlayDocument document = new PlayByPlayDocument();
        document.setGameId(playByPlayModel.id);
        document.setPlayByPlayModel(playByPlayModel);
        gamePlayByPlayRepo.save(document);
    }
}
