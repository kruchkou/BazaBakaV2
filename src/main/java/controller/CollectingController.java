package controller;

import controller.exception.SeleniumInitException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Timer;
import java.util.TimerTask;

public class CollectingController implements Runnable {

    private static final CollectingController instance = new CollectingController();
    private static final Logger logger = LogManager.getLogger(CollectingController.class);
    private final SeleniumController seleniumController = new SeleniumController();
    private final DataController dataController = DataController.getInstance();
    private final CollectingController.SeleniumTask task = new CollectingController.SeleniumTask();

    public static CollectingController getInstance() {
        return instance;
    }

    private CollectingController() {
    }

    public void collectPrevious(int month) {
        turnOffCollecting();

        seleniumController.setLeagues(dataController.getLeagues());
        try {
            seleniumController.getMatchesByDate(month);
            logger.info("Успешная сброка данных");
        } catch (SeleniumInitException e) {
                logger.error("Хром не был запущен. Ожидание следующей итерации",e);
        } catch (InterruptedException e) {
                logger.error("Ошибка прерывания потока",e);
        }
        finally {
            turnOnCollecting();
        }
    }

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
            try {
                seleniumController.setLeagues(dataController.getLeagues());
                dataController.insertMatches(seleniumController.getNewMatches());
            } catch (SeleniumInitException seleniumInitException) {
                logger.error("Хром не был запущен. Ожидание следующей итерации", seleniumInitException);
            } catch (InterruptedException interruptedException) {
                logger.error("Ошибка прерывания потока", interruptedException);
            }
        }
    }

}
