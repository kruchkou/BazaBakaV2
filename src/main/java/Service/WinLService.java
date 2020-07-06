package Service;

import DAO.WinLDao;
import Entity.DBEntity.WinLsEntity;

import java.util.List;

public class WinLService {

    private WinLDao winLDao = new WinLDao();

    public WinLService() {
    }

    public WinLsEntity findMatchById(int id) {
        return winLDao.findById(id);
    }

    public void saveUser(WinLsEntity winL) {
        winLDao.save(winL);
    }

    public void deleteUser(WinLsEntity winL) {
        winLDao.delete(winL);
    }

    public void updateUser(WinLsEntity winL) {
        winLDao.update(winL);
    }

    public List<WinLsEntity> findAllUsers() {
        return winLDao.findAll();
    }

//    public Auto findAutoById(int id) {
//        return matchDao.findAutoById(id);
//    }


}