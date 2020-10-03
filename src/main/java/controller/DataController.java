package controller;

import controller.entity.SeleniumMatch;
import controller.entity.SeleniumMatchList;
import entity.MatchList;
import entity.dbEntity.*;
import entity.StringResult;
import service.*;

import java.util.ArrayList;
import java.util.List;

public class DataController {

    private static DataController instance;
    MatchService matchService = new MatchService();
    PlayerService playerService = new PlayerService();
    ResultService resultService = new ResultService();
    LeagueService  leagueService = new LeagueService();
    AppuserService appuserService = new AppuserService();

    public static DataController getInstance() {
        if (instance == null) {
            instance = new DataController();
        }

        return instance;
    }

    private DataController() {
    }

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

    public MatchList getPlayerMatches(int quantity, String name, String league){
        return matchService.getPlMatches(quantity,name,league);
    }

    public  MatchList get2PlayerMatches(int quantity, String p1name, String p2name, String league){
        return matchService.get2PlMatches(quantity, p1name, p2name, league);
    }

    public List<String> getAllPlayerNames(){
        return playerService.all();
    }

    public List<String> getUsers(){
        List<String> userList = new ArrayList<>();

        List<AppusersEntity> appUserList = appuserService.all();
        for(AppusersEntity appusersEntity: appUserList) {
            userList.add(appusersEntity.getUsername());
        }
        return userList;
    }

    public boolean checkUserAccess(String mac){
        return appuserService.checkAccess(mac);
    }

    public String getLastMatchDate(){
        return matchService.getMatches(1,"").getMatch(0).getDateAndTime();
    }


    public void insertMatches(SeleniumMatchList seleniumMatchList) {

        for(SeleniumMatch seleniumMatch : seleniumMatchList.getMatchList()) {
            PlayersEntity player1Entity = playerService.getOrNewByName(seleniumMatch.getPlayer1());
            PlayersEntity player2Entity = playerService.getOrNewByName(seleniumMatch.getPlayer2());
            ResultEntity resultEntity = resultService.getOrNewByParams(seleniumMatch.getResult());
            LeaguesEntity leaguesEntity = leagueService.byName(seleniumMatch.getLeague());

            matchService.insertIgnore(player1Entity, player2Entity, resultEntity, seleniumMatch.getDate(), leaguesEntity);
        }
    }

    public void insertLastMatchDate(String date) {


    }



}
