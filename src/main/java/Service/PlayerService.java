package Service;

import DAO.PlayerDao;
import Entity.DBEntity.PlayersEntity;
import Entity.DBEntity.ResultEntity;

import java.util.List;

public class PlayerService {

    private PlayerDao playerDao = new PlayerDao();

    public PlayerService() {
    }

    public PlayersEntity byId(int id) {
        return playerDao.findById(id);
    }

    public void save(PlayersEntity player) {
        playerDao.save(player);
    }

    public void delete(PlayersEntity player) {
        playerDao.delete(player);
    }

    public void update(PlayersEntity player) {
        playerDao.update(player);
    }

    public List<PlayersEntity> all() {
        return playerDao.findAll();
    }

    public PlayersEntity byName(String name) {
        return playerDao.byName(name).get(0);
    }
}