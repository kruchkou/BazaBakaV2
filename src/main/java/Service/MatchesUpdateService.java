package Service;

import DAO.MatchesUpdateDao;
import Entity.DBEntity.MatchesUpdatesEntity;

import java.util.List;

public class MatchesUpdateService {

    private MatchesUpdateDao matchesUpdateDao = new MatchesUpdateDao();

    public MatchesUpdateService() {
    }

    public MatchesUpdatesEntity byId(int id) {
        return matchesUpdateDao.findById(id);
    }

    public void save(MatchesUpdatesEntity matchUpdate) {
        matchesUpdateDao.save(matchUpdate);
    }

    public void delete(MatchesUpdatesEntity matchUpdate) {
        matchesUpdateDao.delete(matchUpdate);
    }

    public void update(MatchesUpdatesEntity matchUpdate) {
        matchesUpdateDao.update(matchUpdate);
    }

    public List<MatchesUpdatesEntity> all() {
        return matchesUpdateDao.findAll();
    }

}