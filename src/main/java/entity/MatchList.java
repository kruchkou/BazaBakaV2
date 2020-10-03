package entity;

import controller.connection.entity.TransferInterface;
import entity.dbEntity.MatchesLEntity;
import util.WinR;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MatchList implements TransferInterface {

    private ArrayList<Match> matchList;
    private Delimiter delimiter;

    public void sortByP1(String p1name) {
        for (Match match : matchList) {
            if (!(match.getPlayer1().equals(p1name))) {
                match.reverse();
            }
        }
    }

    public int size() {
        return matchList.size();
    }

    public int playerWins(int playerNum) {
        int playerWinsQuantity = 0;
        for (Match match : matchList) {
            if (match.getResult().winner() == playerNum) {
                playerWinsQuantity++;
            }
        }
        return playerWinsQuantity;
    }

    public double getWinR(int playerNum) {
        return WinR.calc(playerWins(playerNum), size());
    }

    //region GSC

    public Delimiter getDelimiter() {
        delimiter = new Delimiter(this);
        return delimiter;
    }

    public Delimiter getDelimiter(int delimNum) {
        delimiter = new Delimiter(this, delimNum);
        return delimiter;
    }

    public Match getMatch(int index) {
        return matchList.get(index);
    }

    public List<Match> getList() {
        return matchList;
    }

    public MatchList(List<MatchesLEntity> listMatchEntity) {
        matchList = new ArrayList<>();
        for (MatchesLEntity matchEntity : listMatchEntity) {
            matchList.add(new Match(matchEntity));
        }
    }

    public MatchList(MatchList matchList, int startIndex, int endIndex) {
        this.matchList = new ArrayList<>();
        if (endIndex > matchList.size()) {
            endIndex = matchList.size() - 1;
        }
        for (int index = startIndex; index <= endIndex; index++) {
            this.matchList.add(matchList.getMatch(index));
        }
    }

    public MatchList(MatchList matchList, String date) {
        this.matchList = new ArrayList<>();
        for (Match matchEntity : matchList.getList()) {
            if (matchEntity.getDate().equals(date)) {
                this.matchList.add(matchEntity);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder resultSB = new StringBuilder();
        if (size() != 0) {
            Match firstMatch = getMatch(0);

            String line = String.format("%s - %d | %d - %s\n", firstMatch.getPlayer1(), playerWins(1), playerWins(2), firstMatch.getPlayer2());
            resultSB.append(line);
            for (Match match : matchList) {
                line = match.toStringWinR();
                resultSB.append(line);
            }
        }
        return resultSB.toString();
    }
    //endregion
}
