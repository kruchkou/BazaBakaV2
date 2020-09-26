package controller;

import entity.Command;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ApplicationController implements Runnable {

    private final Socket socket;
    private ObjectInputStream requestStream;
    private ObjectOutputStream responseStream;
    private DataController dataController;

    public ApplicationController(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {

            responseStream = new ObjectOutputStream(socket.getOutputStream());
            requestStream = new ObjectInputStream(socket.getInputStream());
            dataController = DataController.getInstance();

            Command command = readCommand();

            handleRequest(command);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                requestStream.close();
                responseStream.close();
                socket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Client disconnected");
        }
    }

    private Command readCommand() throws IOException, ClassNotFoundException {
        return (Command) requestStream.readObject();
    }

    public void handleRequest(Command command) throws IOException {
        switch (command.getCommand()) {
            case "getALlPlayersNames": {
                responseStream.writeObject(dataController.getAllPlayerNames()); //return List<String>
                responseStream.flush();
                break;
            }
            case "getPlayersMatches": {
                responseStream.writeObject(dataController.getPlayerMatches(
                        Integer.parseInt(command.getParameter("quantity")),
                        command.getParameter("playerName"),
                        command.getParameter("league")));
                responseStream.flush();
                break;
            }
            case "get2PlayersMatches": {
                responseStream.writeObject(dataController.get2PlayerMatches(
                        Integer.parseInt(command.getParameter("quantity")),
                        command.getParameter("player1Name"),
                        command.getParameter("player2Name"),
                        command.getParameter("league")));
                responseStream.flush();
                break;
            }
            case "getLeagues": {
                responseStream.writeObject(dataController.getLeagues()); //return Leagues
                responseStream.flush();
                break;
            }
            case "checkUserAccess": {
                responseStream.writeObject(dataController.checkUserAccess(command.getParameter("user_id"))); //return Boolean
                responseStream.flush();
                break;
            }
            case "getUsersList": {
                responseStream.writeObject(dataController.getUsers()); //return HashMap<String,String>
                responseStream.flush();
                break;
            }
            case "getLastMatchDate": {
                responseStream.writeObject(dataController.getLastMatchDate());
                responseStream.flush();
                break;
            }
        }
    }
}
