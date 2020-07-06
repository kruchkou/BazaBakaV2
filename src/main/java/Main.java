import Entity.Delimiter;
import Entity.Match;
import Entity.MatchList;
import Service.MatchService;

import java.util.List;

public class Main {

    public static void main(final String[] args) throws Exception {

        MatchService matchService = new MatchService();

//        MatchList last10ML = matchService.getMatches(10,"Мастерс");
        MatchList plML = matchService.get2PlMatches(33,"Алексей Попов","Максим Боков","");

        //MatchList test = matchService.getPlMatches(30,"Алексей Попов","Мастерс");
        Delimiter del = plML.getDelimiter(3);

        List<MatchList> byDate = del.getMatchListByDate();
        List<MatchList> byTen = del.getMatchListByQuantity();

//        System.out.println(plML);

//        for(MatchList ml : byDate) {
//            System.out.printf("%s | WinR: %.0f\n",ml.getMatch(0).getDate(),ml.getWinR(1));
//            System.out.println(ml);
//        }

        for(MatchList ml : byTen) {
            System.out.printf("%d | %d\n",ml.playerWins(1),ml.playerWins(2));
            System.out.println(ml);
        }

    }
}