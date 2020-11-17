package service;

import dao.AppuserDao;
import dao.UnregUsersDAO;
import entity.dbEntity.AppusersEntity;
import entity.dbEntity.UnregUsersEntity;

import java.util.List;

public class UnregUsersService {

    private UnregUsersDAO unregUsersDao = new UnregUsersDAO();

    public UnregUsersService() {
    }

    public UnregUsersEntity byId(int id) {
        return unregUsersDao.findById(id);
    }

    public void save(UnregUsersEntity appuser) {
        unregUsersDao.save(appuser);
    }

    public void delete(UnregUsersEntity appuser) {
        unregUsersDao.delete(appuser);
    }

    public void update(UnregUsersEntity appuser) {
        unregUsersDao.update(appuser);
    }

    public List<UnregUsersEntity> all() {
        return unregUsersDao.findAll();
    }

    public boolean canWriteNick(String name){
        List<UnregUsersEntity> list = unregUsersDao.findAll();
        if(list.isEmpty()){
            return true;
        }
        for(UnregUsersEntity u: list){
            if(u.getNickname().equals(name)){
                return false;
            }
        }
        return true;
    }


}
