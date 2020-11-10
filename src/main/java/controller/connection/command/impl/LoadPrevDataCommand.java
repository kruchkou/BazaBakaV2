package controller.connection.command.impl;

import controller.CollectingController;
import controller.connection.entity.impl.TransferElement;

public class LoadPrevDataCommand extends BasicCommand {

    @Override
    public TransferElement execute() {
        CollectingController collectingController = CollectingController.getInstance();
        collectingController.collectPrevious(3);

        return null;
    }
}
