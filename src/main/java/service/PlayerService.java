package service;

import dao.PlayerDao;
import entity.dbEntity.PlayersEntity;

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
        List<PlayersEntity> playerList = playerDao.byName(name);
        if (playerList.size() == 0) {
            return null;
        }
        return playerList.get(0);
    }

    public PlayersEntity getOrNewByName(String name) {
        PlayersEntity player = byName(name);
        if (player == null) {
            PlayersEntity newPlayer = new PlayersEntity();
            newPlayer.setName(name);
            save(newPlayer);

            return byName(name);
        }
        return player;
    }
}