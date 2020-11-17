package controller.connection.command.impl;

import controller.DataController;
import controller.connection.entity.impl.TransferBoolean;

public class SendNickNameCommand extends BasicCommand{
    @Override
    public TransferBoolean execute() {
        DataController dataController = DataController.getInstance();
        return new TransferBoolean(dataController.addUnregUser(getParameter("nickname"),getParameter("user_id")));
    }
}
