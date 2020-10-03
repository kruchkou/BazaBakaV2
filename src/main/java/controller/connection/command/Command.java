package controller.connection.command;

import controller.DataController;
import controller.connection.entity.TransferInterface;

import java.util.HashMap;

public interface Command {

    HashMap<String, String> parameters = new HashMap<>();

    default void putParameter(String key, String value) {
        parameters.put(key,value);
    }

    default String getParameter(String key) {
        return parameters.get(key);
    }

    TransferInterface execute();

}
