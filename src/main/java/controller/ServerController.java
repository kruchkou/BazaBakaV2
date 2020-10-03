package controller;

import controller.connection.ConnectionsController;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerController {
    private static final Logger logger = LogManager.getLogger(ServerController.class);
    private static ExecutorService pool;


    public static void main(String[] args) {

        logger.info("Сервер запущен.");
        pool = Executors.newFixedThreadPool(2);

        pool.execute(new ConnectionsController());
        pool.execute(new CollectingController());

    }


}
