package controller.connection.command.impl;

import controller.DataController;
import controller.connection.command.Command;
import entity.MatchList;

public class Get2PlMatchCommand extends BasicCommand {

    @Override
    public MatchList execute() {
        DataController dataController = DataController.getInstance();
        return dataController.get2PlayerMatches(
                Integer.parseInt(getParameter("quantity")),
                getParameter("player1Name"),
                getParameter("player2Name"),
                getParameter("league"));
    }
}
