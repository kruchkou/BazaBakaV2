package service;

import dao.WinLDao;
import entity.dbEntity.WinLsEntity;

import java.util.List;

public class WinLService {

    private WinLDao winLDao = new WinLDao();

    public WinLService() {
    }

    public WinLsEntity byId(int id) {
        return winLDao.findById(id);
    }

    public void save(WinLsEntity winL) {
        winLDao.save(winL);
    }

    public void delete(WinLsEntity winL) {
        winLDao.delete(winL);
    }

    public void update(WinLsEntity winL) {
        winLDao.update(winL);
    }

    public List<WinLsEntity> all() {
        return winLDao.findAll();
    }

}