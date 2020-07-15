package Service;

import DAO.LeagueDao;
import Entity.DBEntity.LeaguesEntity;
import Entity.DBEntity.PlayersEntity;

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
        return leagueDao.byName(name).get(0);
    }
}