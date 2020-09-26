import controller.ClientController;
import controller.DataController;
import entity.Match;
import entity.MatchList;
import entity.StringResult;
import service.*;

public class Main {

    public static void main(final String[] args) throws Exception {

        ClientController clientController = new ClientController();

        System.out.println(clientController.getLeagues());
        System.out.println(clientController.get2PlayersMatches(5,"Олег Косых","Анатолий Пчелинцев",""));
        System.out.println(clientController.getAllPlayers());
        System.out.println(clientController.getLastMatchDate());
        MatchList matchList = clientController.getPlayersMatches(5,"Олег Косых","");
        for(Match match : matchList.getList()) {
            System.out.println(match+" " + match.getPlayer1()+ " " + match.getPlayer2());
        }

    }
}