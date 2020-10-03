package controller.connection.command.impl;

import controller.DataController;
import controller.connection.command.Command;
import controller.connection.entity.TransferBoolean;
import controller.connection.entity.TransferInterface;

public class GetAccessCommand implements Command {
    @Override
    public TransferBoolean execute() {
        DataController dataController = DataController.getInstance();
        return new TransferBoolean(dataController.checkUserAccess(getParameter("user_id")));
    }
}
