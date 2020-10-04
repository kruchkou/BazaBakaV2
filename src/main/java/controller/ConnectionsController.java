package controller;

import controller.connection.ApplicationController;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConnectionsController implements Runnable {

    private static final Logger log = Logger.getLogger(ConnectionsController.class);
    private ServerSocket serverSocket;
    private ExecutorService pool;
    private final int poolSize = 15;
    private int port = 8030;

    public void turnOn() throws IOException {
        serverSocket = new ServerSocket(port);
        pool = Executors.newFixedThreadPool(poolSize);

        while (true) {
            Socket socket = serverSocket.accept();
            pool.execute(new ApplicationController(socket));
        }
    }

    @Override
    public void run() {
        try {
            turnOn();
        } catch (IOException e) {
            log.error("Cant turn on connections controller");
            e.printStackTrace();

        }
    }
}
