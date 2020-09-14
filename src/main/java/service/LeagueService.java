package service;

import dao.LeagueDao;
import entity.dbEntity.LeaguesEntity;

import java.util.List;

public class LeagueService {

    private LeagueDao leagueDao = new LeagueDao();

    public LeagueService() {
    }

    public LeaguesEntity byId(int id) {
        return leagueDao.findById(id);
    }

    public void save(LeaguesEntity league) {
        leagueDao.save(league);
    }

    public void delete(LeaguesEntity league) {
        leagueDao.delete(league);
    }

    public void update(LeaguesEntity league) {
        leagueDao.update(league);
    }

    public List<LeaguesEntity> all() {
        return leagueDao.findAll();
    }

    public LeaguesEntity byName(String name) {
        List<LeaguesEntity> leaguesList = leagueDao.byName(name);
        if (leaguesList.size() == 0) {
            return null;
        }
        return leaguesList.get(0);
    }
}