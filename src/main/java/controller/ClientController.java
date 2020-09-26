package controller;

import entity.Command;
import entity.Match;
import entity.MatchList;
import util.CommandBuilder;

import java.io.*;
import java.net.Socket;
import java.util.List;

public class ClientController {

    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;
    private CommandBuilder commandBuilder = CommandBuilder.getInstance();
    private String host = "130.193.46.131";
    private int port = 8030;
    private Socket clientSocket;

    private void sendCommand(Command command) throws IOException {
        objectOutputStream.writeObject(command);
        objectOutputStream.flush();
    }

    private Object getObject() throws IOException, ClassNotFoundException {
        return objectInputStream.readObject();
    }

    public List<String> getAllPlayers() throws IOException, ClassNotFoundException, InterruptedException {
        init();
        sendCommand(commandBuilder.getAllPlayersCommand());
        Thread.sleep(1000);
        List<String> result = (List<String>) getObject();
        close();
        return result;
    }

    public MatchList getPlayersMatches(int quantity, String playerName, String league) throws IOException, ClassNotFoundException, InterruptedException {
        init();
        sendCommand(commandBuilder.getPlayersMatchesCommand(quantity, playerName, league));
        Thread.sleep(1000);
        MatchList result = (MatchList) getObject();
        close();
        return result;
    }

    public MatchList get2PlayersMatches(int quantity, String player1Name, String player2Name, String league) throws IOException, ClassNotFoundException, InterruptedException{
        init();
        sendCommand(commandBuilder.get2PlayersMatchesCommand(quantity,player1Name,player2Name,league));
        Thread.sleep(500);
        MatchList result = (MatchList) getObject();
        close();
        return result;
    }

    public List<String> getLeagues() throws IOException, ClassNotFoundException, InterruptedException {
        init();
        sendCommand(commandBuilder.getLeaguesCommand());
        Thread.sleep(1000);
        List<String> result = (List<String>) getObject();
        close();
        return result;
    }

    public boolean checkUserAccess(String user_id) throws IOException, ClassNotFoundException, InterruptedException{
        init();
        sendCommand(commandBuilder.checkUserAccessCommand(user_id));
        Thread.sleep(1000);
        boolean result = (boolean) getObject();
        close();
        return result;
    }

    public List<String> getUsersList() throws IOException, ClassNotFoundException, InterruptedException {
        init();
        sendCommand(commandBuilder.getUsersListCommand());
        Thread.sleep(1000);
        List<String> result = (List<String>) getObject();
        close();
        return result;
    }

    public String getLastMatchDate() throws IOException, ClassNotFoundException, InterruptedException {
        init();
        sendCommand(commandBuilder.getLastMatchDate());
        Thread.sleep(1000);
       String result = (String) getObject();
        close();
        return result;
    }

    private void init() throws IOException {
        clientSocket = new Socket(host,port);
        objectInputStream = new ObjectInputStream(clientSocket.getInputStream());
        objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
    }

    private void close() throws IOException {
        objectInputStream.close();
        objectOutputStream.close();
        clientSocket.close();
    }
}
