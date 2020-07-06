package Service;

import DAO.LeagueDao;
import Entity.DBEntity.LeaguesEntity;

import java.util.List;

public class LeagueService {

    private LeagueDao leagueDao = new LeagueDao();

    public LeagueService() {
    }

    public LeaguesEntity findMatchById(int id) {
        return leagueDao.findById(id);
    }

    public void saveUser(LeaguesEntity league) {
        leagueDao.save(league);
    }

    public void deleteUser(LeaguesEntity league) {
        leagueDao.delete(league);
    }

    public void updateUser(LeaguesEntity league) {
        leagueDao.update(league);
    }

    public List<LeaguesEntity> findAllUsers() {
        return leagueDao.findAll();
    }

//    public Auto findAutoById(int id) {
//        return matchDao.findAutoById(id);
//    }


}