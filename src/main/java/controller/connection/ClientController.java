package controller.connection;

import controller.connection.command.CommandBuilder;
import controller.connection.entity.TransferObject;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientController {

    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;
    private final CommandBuilder commandBuilder = CommandBuilder.getInstance();
    private final String host = "130.193.46.131";
    private final int port = 8030;
    private Socket clientSocket;
    private TransferObject transferObject;

    private void sendTransferObject(TransferObject transferObject) throws IOException {
        objectOutputStream.writeObject(transferObject);
        objectOutputStream.flush();
    }

    private TransferObject getTransferObject() throws IOException, ClassNotFoundException {
        return (TransferObject) objectInputStream.readObject();
    }

    public void getPlayerListCommand() {
        transferObject.addCommand(commandBuilder.getPlayerListCommand());
    }

    public void getPlayersMatches(int quantity, String playerName, String league) {
        transferObject.addCommand(commandBuilder.getPlMatchCommand(quantity,playerName,league));
    }

    public void get2PlayersMatches(int quantity, String player1Name, String player2Name, String league) {
        transferObject.addCommand(commandBuilder.get2PlayersMatchesCommand(quantity,player1Name,player2Name,league));
    }

    public void getLeagues() {
        transferObject.addCommand(commandBuilder.getLeaguesCommand());
    }

    public void checkUserAccess(String user_id) {
        transferObject.addCommand(commandBuilder.checkUserAccessCommand(user_id));
    }

    public void getUsersList() {
        transferObject.addCommand(commandBuilder.getUsersListCommand());
    }

    public void getLastMatchDate() {
        transferObject.addCommand(commandBuilder.getLastMatchDate());
    }

    public void init() throws IOException {
        clientSocket = new Socket(host,port);
        objectInputStream = new ObjectInputStream(clientSocket.getInputStream());
        objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
        transferObject = new TransferObject();
    }

    private TransferObject execute() throws InterruptedException, IOException, ClassNotFoundException {
        sendTransferObject(transferObject);
        Thread.sleep(500);
        transferObject = getTransferObject();
        close();
        return transferObject;
    }

    private void close() throws IOException {
        objectInputStream.close();
        objectOutputStream.close();
        clientSocket.close();
    }
}
