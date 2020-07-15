package Service;

import DAO.ResultDao;
import Entity.DBEntity.ResultEntity;
import Entity.MatchList;
import Entity.Result;

import java.util.List;

public class ResultService {

    private ResultDao resultDao = new ResultDao();

    public ResultService() {
    }

    public ResultEntity byId(int id) {
        return resultDao.findById(id);
    }

    public void save(ResultEntity result) {
        resultDao.save(result);
    }

    public void delete(ResultEntity result) {
        resultDao.delete(result);
    }

    public void update(ResultEntity result) {
        resultDao.update(result);
    }

    public List<ResultEntity> all() {
        return resultDao.findAll();
    }

    public ResultEntity byParams(String score, String set, String set2, String set3, String set4, String set5, String set6, String set7) {
        return resultDao.byParams(score, set, set2, set3, set4, set5, set6, set7).get(0);
    }
}