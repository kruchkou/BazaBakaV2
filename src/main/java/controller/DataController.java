package controller;

import com.mysql.cj.exceptions.DataTruncationException;
import controller.entity.SeleniumMatch;
import controller.entity.SeleniumMatchList;
import dao.ResultDao;
import entity.MatchList;
import entity.StringUser;
import entity.dbEntity.*;
import entity.StringResult;
import org.apache.log4j.Logger;
import org.hibernate.exception.DataException;
import service.*;

import java.sql.DataTruncation;
import java.util.ArrayList;
import java.util.List;

public class DataController {

    private static final Logger logger = org.apache.log4j.LogManager.getLogger(DataController.class);

    private static DataController instance;
    MatchService matchService = new MatchService();
    PlayerService playerService = new PlayerService();
    ResultService resultService = new ResultService();
    LeagueService  leagueService = new LeagueService();
    AppuserService appuserService = new AppuserService();
    UnregUsersService unregUsersService = new UnregUsersService();

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

        try {

            for (SeleniumMatch seleniumMatch : seleniumMatchList.getMatchList()) {
                PlayersEntity player1Entity = playerService.getOrNewByName(seleniumMatch.getPlayer1());
                PlayersEntity player2Entity = playerService.getOrNewByName(seleniumMatch.getPlayer2());
                ResultEntity resultEntity = resultService.getOrNewByParams(seleniumMatch.getResult());
                LeaguesEntity leaguesEntity = leagueService.byName(seleniumMatch.getLeague());

                matchService.insertIgnore(player1Entity, player2Entity, resultEntity, seleniumMatch.getDate(), leaguesEntity);
            }
        } catch (DataException e) {
            logger.error("Неверные данные пришли в insertMatch", e);
        }
    }


    public boolean addUnregUser(String nickname, String android_id){
        if(unregUsersService.canWriteNick(nickname)){
            UnregUsersEntity usersEntity = new UnregUsersEntity();
            usersEntity.setNickname(nickname);
            usersEntity.setUserId(android_id);
            unregUsersService.save(usersEntity);
            return true;
        }
        else
            return false;
    }


    public List<StringUser> getUnregUsers(){
        List<StringUser> unregList = new ArrayList<>();

        List<UnregUsersEntity> dbList = unregUsersService.all();

        for(UnregUsersEntity u : dbList){
            unregList.add(new StringUser(u.getNickname(),u.getUserId()));
        }

        return unregList;


    }



}
