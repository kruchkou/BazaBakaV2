package Service;

import DAO.ResultDao;
import Entity.DBEntity.ResultEntity;

import java.util.List;

public class ResultService {

    private ResultDao resultDao = new ResultDao();

    public ResultService() {
    }

    public ResultEntity findMatchById(int id) {
        return resultDao.findById(id);
    }

    public void saveUser(ResultEntity result) {
        resultDao.save(result);
    }

    public void deleteUser(ResultEntity result) {
        resultDao.delete(result);
    }

    public void updateUser(ResultEntity result) {
        resultDao.update(result);
    }

    public List<ResultEntity> findAllUsers() {
        return resultDao.findAll();
    }

    public int getWinner() {
        return 0;
    }
//    public Auto findAutoById(int id) {
//        return matchDao.findAutoById(id);
//    }


}