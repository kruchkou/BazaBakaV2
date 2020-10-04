package controller.connection.command;

import controller.connection.entity.TransferInterface;

import java.io.Serializable;
import java.util.HashMap;

public interface Command extends Serializable {

    TransferInterface execute();

}
