package Service;

import DAO.MatchDao;
import Entity.DBEntity.MatchesLEntity;
import Entity.DateFormater;
import Entity.Match;
import Entity.MatchList;

import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MatchService {

    private final int P1_WIN_VALUE = 1;
    private final int P2_WIN_VALUE = 2;

    private MatchDao matchDao = new MatchDao();

    public MatchService() {
    }

    public MatchesLEntity findMatchById(int id) {
        return matchDao.findById(id);
    }

    public void saveUser(MatchesLEntity match) {
        matchDao.save(match);
    }

    public void deleteUser(MatchesLEntity match) {
        matchDao.delete(match);
    }

    public void updateUser(MatchesLEntity match) {
        matchDao.update(match);
    }

    public List<MatchesLEntity> findAllUsers() {
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
        final double NULL_WINR_VALUE = 0.123;
        for (MatchesLEntity matchEntity : listMLEntity) {
            String matchDate = DateFormater.getDate(matchEntity.getDate());

            if (matchEntity.getWinR1() == NULL_WINR_VALUE || matchDate.equals(DateFormater.getCurrentDate())) {
                matchEntity.setWinR1(getPlMatchesForDate(matchEntity.getPlayer1().getName(), DateFormater.getDate(matchEntity.getDate()), matchEntity.getLeague().getName()).getWinR(1));
                matchDao.update(matchEntity);
            }
            if (matchEntity.getWinR2() == NULL_WINR_VALUE || matchDate.equals(DateFormater.getCurrentDate())) {
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


//    public Auto findAutoById(int id) {
//        return matchDao.findAutoById(id);
//    }


}