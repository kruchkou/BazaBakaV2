package controller;

import controller.exception.SeleniumInitException;

import java.util.Timer;
import java.util.TimerTask;

public class CollectingController implements Runnable {

    SeleniumController seleniumController = new SeleniumController();
    DataController dataController = DataController.getInstance();

    CollectingController.SeleniumTask task = new CollectingController.SeleniumTask();

    public void turnOnCollecting() {
        task.turnOnCollecting();
    }

    public void turnOffCollecting() {
        task.turnOffCollecting();
    }

    @Override
    public void run() {
        CollectingController collectingController = new CollectingController();
        collectingController.turnOnCollecting();
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

}
