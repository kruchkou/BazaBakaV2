package controller;

import controller.entity.SeleniumMatchBuilder;
import controller.entity.WebElementFactory;
import controller.exception.SeleniumInitException;
import controller.entity.SeleniumMatch;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class SeleniumController {

    private List<String> leagues;

    public List<SeleniumMatch> getNewMatches() throws SeleniumInitException, InterruptedException {
        ChromeDriver driver = init();

        List<SeleniumMatch> seleniumMatchList = new ArrayList<>();
        WebElementFactory webElementFactory = new WebElementFactory(driver);
        SeleniumMatchBuilder seleniumMatchBuilder = new SeleniumMatchBuilder();

        driver.get("https://1xstavka.ru/results/");

        WebElement nastolkaButton = webElementFactory.getNastolkaButton();
        WebElement searchBox = webElementFactory.getSearchBox();

        nastolkaButton.click();

        for (String leagueName : leagues) {

            searchBox.sendKeys(leagueName);
            searchBox.sendKeys(Keys.ENTER);

            List<WebElement> matchList = webElementFactory.getMatchList();
            seleniumMatchList.addAll(seleniumMatchBuilder.getSeleniumMatch(matchList, leagueName));

            sleep(1000);

            searchBox.sendKeys("\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b");
        }

        System.out.printf("Отсканированно %d матчей", seleniumMatchList.size());

        driver.quit();
        return seleniumMatchList;
    }

    private ChromeDriver init() throws SeleniumInitException {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        ChromeOptions options = new ChromeOptions();

        //options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--lang=ru");

        try {
            return new ChromeDriver(options);
        }
        catch (RuntimeException e) {
            throw new SeleniumInitException("Error init chrome",e);
        }
    }

    //region GSC

    public void setLeagues(List<String> leagues) {
        this.leagues = leagues;
    }

    //endregion
}
