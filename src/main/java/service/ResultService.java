package service;

import dao.ResultDao;
import entity.dbEntity.ResultEntity;
import entity.StringResult;

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

    public ResultEntity byParams(StringResult params) {
        List<ResultEntity> resultList = resultDao.byParams(params);
        if (resultList.size() == 0) {
            return null;
        }
        return resultList.get(0);
    }

    public ResultEntity getOrNewByParams(StringResult params) {
        ResultEntity result = byParams(params);

        if (result == null) {
            ResultEntity newResult = new ResultEntity();

            newResult.setAll(params);

            save(newResult);

            return byParams(params);
        }
        return result;
    }
}