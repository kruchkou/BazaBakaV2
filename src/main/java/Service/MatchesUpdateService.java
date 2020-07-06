package Service;

import DAO.MatchesUpdateDao;
import Entity.DBEntity.MatchesUpdatesEntity;

import java.util.List;

public class MatchesUpdateService {

    private MatchesUpdateDao matchesUpdateDao = new MatchesUpdateDao();

    public MatchesUpdateService() {
    }

    public MatchesUpdatesEntity findMatchById(int id) {
        return matchesUpdateDao.findById(id);
    }

    public void saveUser(MatchesUpdatesEntity matchUpdate) {
        matchesUpdateDao.save(matchUpdate);
    }

    public void deleteUser(MatchesUpdatesEntity matchUpdate) {
        matchesUpdateDao.delete(matchUpdate);
    }

    public void updateUser(MatchesUpdatesEntity matchUpdate) {
        matchesUpdateDao.update(matchUpdate);
    }

    public List<MatchesUpdatesEntity> findAllUsers() {
        return matchesUpdateDao.findAll();
    }

//    public Auto findAutoById(int id) {
//        return matchDao.findAutoById(id);
//    }


}