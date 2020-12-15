package entity;

import java.io.Serializable;
import java.util.ArrayList;

public class Delimiter implements Serializable {

    ArrayList<MatchList> matchListByDate;
    ArrayList<MatchList> matchListByQuantity;

    private int delimQuantity;

    private void initMatchListByQuantity(MatchList matchList) {
        int matchesLeft = matchList.size(); //49 / 10 = 4

        int steps = matchesLeft / delimQuantity;
        int offsetIndex;
        int endIndex;

        for (int index = 0; index < steps; index++) {
            offsetIndex = delimQuantity * index; //0 10 20 30
            endIndex = offsetIndex + delimQuantity - 1; //9 19 29 39
            matchListByQuantity.add(new MatchList(matchList, offsetIndex, endIndex));
        }
        int left = matchesLeft % delimQuantity; //9

        if(left>0) {
            offsetIndex = delimQuantity * steps;
            endIndex = offsetIndex+left-1;
            matchListByQuantity.add(new MatchList(matchList, offsetIndex, endIndex));
        }
    }


//    private void initMatchListByQuantity(MatchList matchList) {
//        int matchesLeftQ = matchList.size();
//        int offsetIndex = 0;
//        int endIndex;
//        do {
//            endIndex = delimQuantity - 1 + offsetIndex;
//
//            matchListByQuantity.add(new MatchList(matchList, offsetIndex, endIndex));
//
//            offsetIndex += delimQuantity;
//            matchesLeftQ -= delimQuantity;
//        } while (matchesLeftQ > 0);
//    }

    private void initMatchListByDate(MatchList matchList) {
        String prevDate = matchList.getList().get(0).getDate();
        matchListByDate.add(new MatchList(matchList, prevDate));

        for (Match match : matchList.getList()) {
            if (!match.getDate().equals(prevDate)) {
                matchListByDate.add(new MatchList(matchList, match.getDate()));

                prevDate = match.getDate();
            }
        }
    }
    //region GSC

    public Delimiter(MatchList matchList) {
        delimQuantity = 10;
        initLists();

        initMatchListByQuantity(matchList);
        initMatchListByDate(matchList);
    }

    public Delimiter(MatchList matchList, int delimQuantity) {
        this.delimQuantity = delimQuantity;
        initLists();

        initMatchListByQuantity(matchList);
        initMatchListByDate(matchList);
    }

    private void initLists() {
        matchListByDate = new ArrayList<>();
        matchListByQuantity = new ArrayList<>();
    }

    public ArrayList<MatchList> getMatchListByDate() {
        return matchListByDate;
    }

    public ArrayList<MatchList> getMatchListByQuantity() {
        return matchListByQuantity;
    }

    //endregion
}
