package controller.connection.command.impl;

import controller.DataController;
import controller.connection.entity.impl.TransferBoolean;

public class WriteUnregisteredUserCommand extends BasicCommand{
    @Override
    public TransferBoolean execute() {
        DataController dataController = DataController.getInstance();
        return new TransferBoolean(dataController.addUnregisteredUser(getParameter("nickname"),getParameter("user_id")));
    }
}
