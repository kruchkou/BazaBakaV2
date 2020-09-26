package controller;

import controller.exception.SeleniumInitException;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerController {

    private static ExecutorService pool;


    public static void main(String[] args) {

        pool = Executors.newFixedThreadPool(2);

        pool.execute(new ConnectionsController());
        pool.execute(new CollectingController());

    }


}
