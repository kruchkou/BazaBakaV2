package Service;

import DAO.AppuserDao;
import Entity.DBEntity.AppusersEntity;

import java.util.List;

public class AppuserService {

    private AppuserDao appuserDao = new AppuserDao();

    public AppuserService() {
    }

    public AppusersEntity findAppuserById(int id) {
        return appuserDao.findById(id);
    }

    public void saveUser(AppusersEntity appuser) {
        appuserDao.save(appuser);
    }

    public void deleteUser(AppusersEntity appuser) {
        appuserDao.delete(appuser);
    }

    public void updateUser(AppusersEntity appuser) {
        appuserDao.update(appuser);
    }

    public List<AppusersEntity> findAllUsers() {
        return appuserDao.findAll();
    }

//    public Auto findAutoById(int id) {
//        return matchDao.findAutoById(id);
//    }


}