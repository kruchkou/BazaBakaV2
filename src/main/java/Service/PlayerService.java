package Service;

import DAO.PlayerDao;
import Entity.DBEntity.PlayersEntity;

import java.util.List;

public class PlayerService {

    private PlayerDao playerDao = new PlayerDao();

    public PlayerService() {
    }

    public PlayersEntity findMatchById(int id) {
        return playerDao.findById(id);
    }

    public void saveUser(PlayersEntity player) {
        playerDao.save(player);
    }

    public void deleteUser(PlayersEntity player) {
        playerDao.delete(player);
    }

    public void updateUser(PlayersEntity player) {
        playerDao.update(player);
    }

    public List<PlayersEntity> findAllUsers() {
        return playerDao.findAll();
    }

//    public Auto findAutoById(int id) {
//        return matchDao.findAutoById(id);
//    }


}