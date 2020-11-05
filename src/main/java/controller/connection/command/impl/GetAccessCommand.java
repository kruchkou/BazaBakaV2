package controller.connection.command.impl;

import controller.DataController;
import controller.connection.entity.impl.TransferBoolean;

public class GetAccessCommand extends BasicCommand {
    @Override
    public TransferBoolean execute() {
        DataController dataController = DataController.getInstance();
        return new TransferBoolean(dataController.checkUserAccess(getParameter("user_id")));
    }
}
