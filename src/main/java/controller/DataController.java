package controller;

import entity.dbEntity.LeaguesEntity;
import entity.dbEntity.MatchesLEntity;
import entity.dbEntity.PlayersEntity;
import entity.dbEntity.ResultEntity;
import entity.StringResult;
import service.LeagueService;
import service.MatchService;
import service.PlayerService;
import service.ResultService;

public class DataController {
    MatchService matchService = new MatchService();
    PlayerService playerService = new PlayerService();
    ResultService resultService = new ResultService();
    LeagueService leagueService = new LeagueService();

    public void insertMatch(String player1, String player2, StringResult result, String date, String league) {
        PlayersEntity player1Entity = playerService.getOrNewByName(player1);
        PlayersEntity player2Entity = playerService.getOrNewByName(player2);
        ResultEntity resultEntity = resultService.getOrNewByParams(result);
        LeaguesEntity leaguesEntity = leagueService.byName(league);

        matchService.insertIgnore(player1Entity, player2Entity, resultEntity, date, leaguesEntity);

    }

}
