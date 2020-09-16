package service;

import dao.MatchDao;
import entity.dbEntity.LeaguesEntity;
import entity.dbEntity.MatchesLEntity;
import entity.DateFormater;
import entity.MatchList;
import entity.dbEntity.PlayersEntity;
import entity.dbEntity.ResultEntity;

import java.util.List;

public class MatchService {

    private final int P1_WIN_VALUE = 1;
    private final int P2_WIN_VALUE = 2;

    private MatchDao matchDao = new MatchDao();

    public MatchService() {
    }

    public MatchesLEntity byId(int id) {
        return matchDao.findById(id);
    }

    public void save(MatchesLEntity match) {
        matchDao.save(match);
    }

    public void delete(MatchesLEntity match) {
        matchDao.delete(match);
    }

    public void update(MatchesLEntity match) {
        matchDao.update(match);
    }

    public List<MatchesLEntity> all() {
        return matchDao.findAll();
    }

    public MatchList getMatches(int quantity, String league) {
        return new MatchList(matchDao.getLastMatches(quantity, league));
    }

    public MatchList get2PlMatches(int quantity, String p1name, String p2name, String league) {
        List<MatchesLEntity> listMLEntity = matchDao.get2PlMatches(quantity, p1name, p2name, league);
        checkWinRs(listMLEntity);
        listMLEntity = matchDao.get2PlMatches(quantity, p1name, p2name, league);

        MatchList matchList = new MatchList(listMLEntity);
        matchList.sortByP1(p1name);

        return matchList;
    }

    private void checkWinRs(List<MatchesLEntity> listMLEntity) {
        for (MatchesLEntity matchEntity : listMLEntity) {
            String matchDate = DateFormater.getDate(matchEntity.getDate());

            if (matchEntity.getWinR1() == null || matchDate.equals(DateFormater.getCurrentDate())) {
                matchEntity.setWinR1(getPlMatchesForDate(matchEntity.getPlayer1().getName(), DateFormater.getDate(matchEntity.getDate()), matchEntity.getLeague().getName()).getWinR(1));
                matchDao.update(matchEntity);
            }
            if (matchEntity.getWinR2() == null || matchDate.equals(DateFormater.getCurrentDate())) {
                matchEntity.setWinR2(getPlMatchesForDate(matchEntity.getPlayer2().getName(), DateFormater.getDate(matchEntity.getDate()), matchEntity.getLeague().getName()).getWinR(1));
                matchDao.update(matchEntity);
            }
        }
    }

    public MatchList getPlMatchesForDate(String p1name, String date, String league) {
        MatchList matchList = new MatchList(matchDao.getPlMatchesByDate(p1name, date, league));
        matchList.sortByP1(p1name);
        return matchList;
    }

    public MatchList getPlMatches(int quantity, String p1name, String league) {
        MatchList matchList = new MatchList(matchDao.getPlMatches(quantity, p1name, league));
        matchList.sortByP1(p1name);
        return matchList;
    }

    public MatchesLEntity byParams(String p1name, String p2name, String score, String set1, String set2, String set3, String set4, String set5, String set6, String set7, String date, String league) {
        List<MatchesLEntity> matchesLList = matchDao.byParams(p1name, p2name, score, set1, set2, set3, set4, set5, set6, set7, date, league);
        if (matchesLList.size() == 0) {
            return null;
        }
        return matchesLList.get(0);
    }

    public MatchesLEntity byId(PlayersEntity player1, PlayersEntity player2, ResultEntity result, String date, LeaguesEntity league) {
        List<MatchesLEntity> matchesLList = matchDao.byId(player1, player2, result, date, league);
        if (matchesLList.size() == 0) {
            return null;
        }
        return matchesLList.get(0);
    }

    public void insertIgnore(PlayersEntity player1, PlayersEntity player2, ResultEntity result, String date, LeaguesEntity league) {
        //MatchesLEntity match = byId(player1, player2, result, date, league);
        MatchesLEntity match = byId(player1, player2, result, date, league);

        if (match == null) {
            MatchesLEntity newMatch = new MatchesLEntity();

            newMatch.setPlayer1(player1);
            newMatch.setPlayer2(player2);
            newMatch.setLeague(league);
            newMatch.setResult(result);
            newMatch.setDate(date);

            save(newMatch);
        }
    }
}