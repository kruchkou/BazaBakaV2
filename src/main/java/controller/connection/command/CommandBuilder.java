package controller.connection.command;

import controller.connection.command.impl.BasicCommand;

public class CommandBuilder {

    private static CommandBuilder instance;
    private CommandProvider commandProvider = new CommandProvider();

    private CommandBuilder() {
    }

    public static CommandBuilder getInstance() {
        if (instance == null) {
            instance = new CommandBuilder();
        }
        return instance;
    }

    public BasicCommand getPlayerListCommand() {
        BasicCommand command = commandProvider.getCommand("get_player_list_command");
        return command;
    }

    public BasicCommand getPlMatchCommand(int quantity, String playerName, String league) {
        BasicCommand command = commandProvider.getCommand("get_pl_match_command");
        command.putParameter("quantity",String.valueOf(quantity));
        command.putParameter("playerName",playerName);
        command.putParameter("league",league);

        return command;
    }

    public BasicCommand getPlMatch2Command(int quantity, String playerName, String league) {
        BasicCommand command = commandProvider.getCommand("get_pl_match2_command");
        command.putParameter("quantity",String.valueOf(quantity));
        command.putParameter("playerName",playerName);
        command.putParameter("league",league);

        return command;
    }

    public BasicCommand getPlMatch3Command(int quantity, String playerName, String league) {
        BasicCommand command = commandProvider.getCommand("get_pl_match3_command");
        command.putParameter("quantity",String.valueOf(quantity));
        command.putParameter("playerName",playerName);
        command.putParameter("league",league);

        return command;
    }
    public BasicCommand getPlMatch4Command(int quantity, String playerName, String league) {
        BasicCommand command = commandProvider.getCommand("get_pl_match4_command");
        command.putParameter("quantity",String.valueOf(quantity));
        command.putParameter("playerName",playerName);
        command.putParameter("league",league);

        return command;
    }

    public BasicCommand get2PlayersMatchesCommand(int quantity, String player1Name, String player2Name, String league) {
        BasicCommand command = commandProvider.getCommand("get_2_pl_match_command");
        command.putParameter("quantity",String.valueOf(quantity));
        command.putParameter("player1Name",player1Name);
        command.putParameter("player2Name",player2Name);
        command.putParameter("league",league);

        return command;
    }
    public BasicCommand get2PlayersMatchesCommand2(int quantity, String player1Name, String player2Name, String league) {
        BasicCommand command = commandProvider.getCommand("get_2_pl_match_command2");
        command.putParameter("quantity",String.valueOf(quantity));
        command.putParameter("player1Name",player1Name);
        command.putParameter("player2Name",player2Name);
        command.putParameter("league",league);

        return command;
    }
    public BasicCommand get2PlayersMatchesCommand3(int quantity, String player1Name, String player2Name, String league) {
        BasicCommand command = commandProvider.getCommand("get_2_pl_match_command3");
        command.putParameter("quantity",String.valueOf(quantity));
        command.putParameter("player1Name",player1Name);
        command.putParameter("player2Name",player2Name);
        command.putParameter("league",league);

        return command;
    }
    public BasicCommand get2PlayersMatchesCommand4(int quantity, String player1Name, String player2Name, String league) {
        BasicCommand command = commandProvider.getCommand("get_2_pl_match_command4");
        command.putParameter("quantity",String.valueOf(quantity));
        command.putParameter("player1Name",player1Name);
        command.putParameter("player2Name",player2Name);
        command.putParameter("league",league);

        return command;
    }
    public BasicCommand get2PlayersMatchesCommand5(int quantity, String player1Name, String player2Name, String league) {
        BasicCommand command = commandProvider.getCommand("get_2_pl_match_command5");
        command.putParameter("quantity",String.valueOf(quantity));
        command.putParameter("player1Name",player1Name);
        command.putParameter("player2Name",player2Name);
        command.putParameter("league",league);

        return command;
    }
    public BasicCommand get2PlayersMatchesCommand6(int quantity, String player1Name, String player2Name, String league) {
        BasicCommand command = commandProvider.getCommand("get_2_pl_match_command6");
        command.putParameter("quantity",String.valueOf(quantity));
        command.putParameter("player1Name",player1Name);
        command.putParameter("player2Name",player2Name);
        command.putParameter("league",league);

        return command;
    }

    public BasicCommand getLeaguesCommand() {
        BasicCommand command = commandProvider.getCommand("get_league_list_command");
        return command;
    }

    public BasicCommand checkUserAccessCommand(String user_id) {
        BasicCommand command = commandProvider.getCommand("get_access_command");
        command.putParameter("user_id",user_id);
        return command;
    }

    public BasicCommand getUsersListCommand() {
        BasicCommand command = commandProvider.getCommand("get_user_list_command");
        return command;
    }

    public BasicCommand getLastMatchDate() {
        BasicCommand command = commandProvider.getCommand("get_last_match_date_command");
        return command;
    }

    public BasicCommand sendNicknameCommand(String nickname,String android_id){
        BasicCommand command = commandProvider.getCommand("SEND_NICKNAME_COMMAND");
        command.putParameter("nickname",nickname);
        command.putParameter("android_id",android_id);
        return command;
    }

}
