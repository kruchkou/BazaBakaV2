package controller.connection.entity;

import controller.connection.command.Command;
import controller.connection.exception.TransferException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TransferObject implements Serializable {

    private final List<Command> commandList = new ArrayList<>();
    private final List<TransferInterface> resultList = new ArrayList<>();

    public void addCommand(Command command) {
        commandList.add(command);
    }

    public void execute() {
        for (Command command : commandList) {
            resultList.add(command.execute());
        }
    }

    public TransferInterface get(int index) {
        if (resultList.size() != 0 && resultList.size() > index) {
            return resultList.get(index);
        } else {
            throw new TransferException("Tried to use index, that not exists");
        }
    }

}
