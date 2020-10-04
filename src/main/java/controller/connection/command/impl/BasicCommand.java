package controller.connection.command.impl;

import controller.connection.command.Command;
import controller.connection.entity.TransferInterface;

import java.util.HashMap;

public class BasicCommand implements Command {

    HashMap<String, String> parameters = new HashMap<>();

    public void putParameter(String key, String value) {
        parameters.put(key,value);
    }

    public  String getParameter(String key) {
        return parameters.get(key);
    }

    public TransferInterface execute() {return null;}

}
