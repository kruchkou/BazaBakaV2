package controller;

import controller.entity.SeleniumMatchBuilder;
import controller.entity.SeleniumMatchList;
import controller.exception.SeleniumInitException;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class SeleniumController {

    private static final Logger logger = Logger.getLogger(SeleniumController.class);
    private List<String> leagues;

    public SeleniumMatchList getNewMatches() throws SeleniumInitException, InterruptedException {
        ChromeDriver driver = init();
        SeleniumMatchList seleniumMatchList = new SeleniumMatchList();
        WebElementFactory webElementFactory = new WebElementFactory(driver);
        driver.get("https://1xstavka.ru/results/");

        WebElement nastolkaButton = webElementFactory.getNastolkaButton();
        WebElement searchBox = webElementFactory.getSearchBox();
        nastolkaButton.click();

            seleniumMatchList = loadLeagues(webElementFactory);
            Thread.sleep(500);
        driver.quit();
        return seleniumMatchList;
    }

    public void getMatchesByDate(int monthQuantity) throws SeleniumInitException, InterruptedException {
        ChromeDriver driver = init();
        SeleniumMatchList seleniumMatchList = new SeleniumMatchList();
        WebElementFactory webElementFactory = new WebElementFactory(driver);
        DataController dataController = DataController.getInstance();

        driver.get("https://1xstavka.ru/results/");
        WebElement nastolkaButton = webElementFactory.getNastolkaButton();
        nastolkaButton.click();

        boolean firstMonth = true;

        while (monthQuantity >= 0) {
            WebElement calendar = webElementFactory.getCalendar();
            WebElement freeSpace = webElementFactory.getFreeSpace();
            WebElement prevMonth = webElementFactory.getPrevMonthButton();
            WebElement applyDate = webElementFactory.getApplyDateButton();
            List<WebElement> daysToGet = webElementFactory.getDayButtons();

            if (firstMonth) {
                daysToGet.remove(daysToGet.size() - 1); //убрать нажатие на сегодняшний день
                firstMonth = false;
            }

            performClick(freeSpace, driver);
            for (int index = daysToGet.size(); index > 0; index--) { //загрузить все дни выбранного месяца

                WebElement lastDay = daysToGet.remove(index - 1);
                performClick(calendar, driver);
                performClick(lastDay, driver);
                //try-catch в случае, если произойдет ошибка иксбета. Рефреш страницы-возврат к текущему дню. Дописать на другие месяцы. Сработает только на 1 ошибку подряд.
                try {
                    webElementFactory.waitUntilMatchesLoaded(); //just wait, baby
                } catch (TimeoutException e) {
                    performClick(applyDate, driver);
                    performClick(applyDate, driver);

                }
                performClick(applyDate, driver);
                performClick(applyDate, driver);

                seleniumMatchList = loadLeagues(webElementFactory);
                dataController.insertMatches(seleniumMatchList);
                logger.trace("Вставлено " + seleniumMatchList.size() + " матчей");
            }

            performClick(calendar, driver);
            performClick(prevMonth, driver);
            monthQuantity--;
        }

        driver.quit();
    }

    private SeleniumMatchList loadLeagues(WebElementFactory webElementFactory) throws InterruptedException {
        SeleniumMatchBuilder seleniumMatchBuilder = new SeleniumMatchBuilder();
        SeleniumMatchList seleniumMatchList = new SeleniumMatchList();

        for (String leagueName : leagues) {
            WebElement searchBox = webElementFactory.getSearchBox();
            searchBox.sendKeys(leagueName);
            searchBox.sendKeys(Keys.ENTER);
            List<WebElement> matchList = webElementFactory.getMatchList();
            seleniumMatchList.addAll(seleniumMatchBuilder.getSeleniumMatchList(matchList, leagueName));
            sleep(1000);

            searchBox.sendKeys("\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b");
        }

        logger.info("Отсканированно матчей: " + seleniumMatchList.size());

        return seleniumMatchList;
    }

    public static void performClick(WebElement element, WebDriver driver) {
        Actions builder = new Actions(driver);
        Actions action = builder
                .moveToElement(element)
                .click();
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        action.perform();
    }

    private ChromeDriver init() throws SeleniumInitException {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        ChromeOptions options = new ChromeOptions();

//        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--lang=ru");

        try {
            return new ChromeDriver(options);
        } catch (RuntimeException e) {
            throw new SeleniumInitException("Error init chrome", e);
        }
    }
    //region GSC

    public void setLeagues(List<String> leagues) {
        this.leagues = leagues;
    }

    //endregion

    public static void main(String[] args) {
        SeleniumController seleniumController = new SeleniumController();
        try {
            seleniumController.getNewMatches();
        } catch (SeleniumInitException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
