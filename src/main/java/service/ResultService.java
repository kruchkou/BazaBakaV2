package service;

import controller.CollectingController;
import dao.ResultDao;
import entity.dbEntity.ResultEntity;
import entity.StringResult;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;

public class ResultService {

    private ResultDao resultDao = new ResultDao();
    private static final Logger logger = LogManager.getLogger(ResultService.class);

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
            logger.info(params);
            save(newResult);

            return byParams(params);
        }
        return result;
    }
}