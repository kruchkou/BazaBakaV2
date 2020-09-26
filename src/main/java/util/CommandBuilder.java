package util;

import entity.Command;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CommandBuilder {

    private static CommandBuilder instance;

    private CommandBuilder() {
    }

    public static CommandBuilder getInstance() {
        if (instance == null) {
            instance = new CommandBuilder();
        }
        return instance;
    }

    public Command getAllPlayersCommand() {
        Command command = new Command();
        command.setCommand("getALlPlayersNames");
        return command;
    }

    public Command getPlayersMatchesCommand(int quantity, String playerName, String league) {
        Command command = new Command();
        command.setCommand("getPlayersMatches");
        command.putParameter("quantity",String.valueOf(quantity));
        command.putParameter("playerName",playerName);
        command.putParameter("league",league);

        return command;
    }

    public Command get2PlayersMatchesCommand(int quantity, String player1Name, String player2Name, String league) {
        Command command = new Command();
        command.setCommand("get2PlayersMatches");
        command.putParameter("quantity",String.valueOf(quantity));
        command.putParameter("player1Name",player1Name);
        command.putParameter("player2Name",player2Name);
        command.putParameter("league",league);

        return command;
    }

    public Command getLeaguesCommand() {
        Command command = new Command();
        command.setCommand("getLeagues");
        return command;
    }

    public Command checkUserAccessCommand(String user_id) {
        Command command = new Command();
        command.setCommand("checkUserAccess");
        command.putParameter("user_id",user_id);
        return command;
    }

    public Command getUsersListCommand() {
        Command command = new Command();
        command.setCommand("getUsersList");
        return command;
    }

    public Command getLastMatchDate() {
        Command command = new Command();
        command.setCommand("getLastMatchDate");
        return command;
    }

}
