package controller.connection.command.impl;

import controller.DataController;
import controller.connection.command.Command;
import controller.connection.entity.TransferStringList;

public class GetUserListCommand extends BasicCommand {

    @Override
    public TransferStringList execute() {
        DataController dataController = DataController.getInstance();
        return new TransferStringList(dataController.getUsers());
    }

}
