package util;

import entity.Analize;
import entity.Match;
import entity.MatchList;
import entity.dbEntity.MatchesLEntity;

import java.util.List;

public class StatAnalizer {

    int winsDifference = 3;
    int allowedSkip = 2;

    public Analize analize(MatchesLEntity matchesLEntity, MatchList matchList) {
        Match checkedMatch = new Match(matchesLEntity);
        List<Match> listMatches= matchList.getList();
        int matchesQuantity = matchList.size();
        int goodTotal;
        int goodFora;
        int goodWinner = getGoodWinner(matchList);

        int[] foras = new int[matchList.size()];
        int[] totals = new int[matchList.size()];

        for (int index = 0; index < matchesQuantity; index++) {
            foras[index] = listMatches.get(index).getResult().getP1Fora();

        }

        return new Analize(0, 0, 0);
    }

    public int getGoodWinner(MatchList matchList) {
        int p1Wins = matchList.playerWins(1);
        int p2Wins = matchList.playerWins(2);

        if (p1Wins - p2Wins >= winsDifference) {
            return 1;
        } else if (p2Wins - p1Wins >= winsDifference) {
            return 2;
        }
        return 0;
    }

    //region GSC

    public StatAnalizer() {
    }

    public StatAnalizer(int winsDifference, int allowedSkip) {
        this.winsDifference = winsDifference;
        this.allowedSkip = allowedSkip;
    }
    //endregion
}
