package controller;

import controller.exception.SeleniumInitException;

import java.util.Timer;
import java.util.TimerTask;

public class ServerController {

    SeleniumController seleniumController = new SeleniumController();
    DataController dataController = new DataController();

    SeleniumTask task = new SeleniumTask();

    public void turnOnCollecting() {
        task.turnOnCollecting();
    }

    public void turnOffCollecting() {
        task.turnOffCollecting();
    }

    public class SeleniumTask extends TimerTask {

        Timer timer = new Timer();

        public void turnOnCollecting() {
            timer.schedule(task, 0, 20 * 60 * 1000);
        }

        public void turnOffCollecting() {
            timer.purge();
        }

        @Override
        public void run() {
            System.out.println("Запуск...");
            try {
                seleniumController.setLeagues(dataController.getLeagues());
                dataController.insertMatches(seleniumController.getNewMatches());
            } catch (SeleniumInitException seleniumInitException) {
                System.out.println("Хром не был запущен. Ожидание следующей итерации..");
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ServerController serverController = new ServerController();
        serverController.turnOnCollecting();
    }


}
