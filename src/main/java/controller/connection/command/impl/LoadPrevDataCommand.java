package controller.connection.command.impl;

import controller.CollectingController;
import controller.connection.entity.TransferBoolean;
import controller.connection.entity.TransferInterface;

public class LoadPrevDataCommand extends BasicCommand {

    @Override
    public TransferInterface execute() {
        CollectingController collectingController = CollectingController.getInstance();
        collectingController.collectPrevious(3);

        return null;
    }
}
