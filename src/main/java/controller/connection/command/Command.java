package controller.connection.command;

import controller.connection.entity.impl.TransferElement;

import java.io.Serializable;

public interface Command extends Serializable {

    TransferElement execute();

}
