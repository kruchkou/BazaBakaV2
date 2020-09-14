import controller.DataController;
import entity.StringResult;
import service.*;

public class Main {

    public static void main(final String[] args) throws Exception {

        MatchService matchService = new MatchService();
//
////        MatchList last10ML = matchService.getMatches(10,"Мастерс");
//        MatchList plML = matchService.get2PlMatches(33,"Алексей Попов","Максим Боков","");
//
//        //MatchList test = matchService.getPlMatches(30,"Алексей Попов","Мастерс");
//        Delimiter del = plML.getDelimiter(3);
//
//        List<MatchList> byDate = del.getMatchListByDate();
//        List<MatchList> byTen = del.getMatchListByQuantity();

//        System.out.println(plML);

//        for(MatchList ml : byDate) {
//            System.out.printf("%s | WinR: %.0f\n",ml.getMatch(0).getDate(),ml.getWinR(1));
//            System.out.println(ml);
//        }

//        for(MatchList ml : byTen) {
//            System.out.printf("%d | %d\n",ml.playerWins(1),ml.playerWins(2));
//            System.out.println(ml);
//        }

//        PlayerService playerService = new PlayerService();

//        System.out.println(playerService.byName("Олег Косых").getIdplayers());

//        for (PlayersEntity playersEntity : playerService.all()) {
//            System.out.println(playersEntity.getName());
//        }

//        ResultService resultService = new ResultService();
//        ResultEntity re = resultService.byParams("4:2","14:12","7:11","11:9","11:6","5:11","11:9","null");
//        System.out.println(re.getIdresult());

//        LeagueService leagueService = new LeagueService();
//        System.out.println(leagueService.byName("Мастерс").getName());

        //20366 441 667 5021 2020-07-15 21:00 6
//        Андрей Мошкутело
//        Григорий Служенко
//        1:3 9:11 11:6 10:12 5:11 null null null



//MatchesLEntity ml = matchService.byParams("Григорий Служенко","Андрей Мошкутело","1:3","9:11","11:6","10:12","5:11","null","null","null","2020-07-15 21:00","Pro Spin Series");
//        System.out.println(ml.getDate());

        DataController ds = new DataController();
        ds.insertMatch("Алишер Каримжанов","",new StringResult(),"","");

    }
}