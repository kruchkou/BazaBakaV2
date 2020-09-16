package controller;

import controller.entity.SeleniumMatch;
import entity.dbEntity.LeaguesEntity;
import entity.dbEntity.MatchesLEntity;
import entity.dbEntity.PlayersEntity;
import entity.dbEntity.ResultEntity;
import entity.StringResult;
import service.LeagueService;
import service.MatchService;
import service.PlayerService;
import service.ResultService;

import java.util.ArrayList;
import java.util.List;

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

    public List<String> getLeagues() {
        List<String> leagueList = new ArrayList<>();

        List<LeaguesEntity> leaguesEntityList = leagueService.all();
        for(LeaguesEntity leaguesEntity: leaguesEntityList) {
            leagueList.add(leaguesEntity.getName());
        }
        return leagueList;
    }

    public void insertMatches(List<SeleniumMatch> seleniumMatchList) {

        for(SeleniumMatch seleniumMatch : seleniumMatchList) {
            PlayersEntity player1Entity = playerService.getOrNewByName(seleniumMatch.getPlayer1());
            PlayersEntity player2Entity = playerService.getOrNewByName(seleniumMatch.getPlayer2());
            ResultEntity resultEntity = resultService.getOrNewByParams(seleniumMatch.getResult());
            LeaguesEntity leaguesEntity = leagueService.byName(seleniumMatch.getLeague());

            matchService.insertIgnore(player1Entity, player2Entity, resultEntity, seleniumMatch.getDate(), leaguesEntity);
        }
    }

}
