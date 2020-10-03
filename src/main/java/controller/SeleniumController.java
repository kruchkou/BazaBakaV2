package controller;

import controller.entity.SeleniumMatchBuilder;
import controller.entity.SeleniumMatchList;
import controller.entity.WebElementFactory;
import controller.exception.SeleniumInitException;
import controller.entity.SeleniumMatch;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

import static java.lang.Thread.sleep;

public class SeleniumController {

    private List<String> leagues;

    public SeleniumMatchList getNewMatches() throws SeleniumInitException, InterruptedException {
        ChromeDriver driver = init();

        SeleniumMatchList seleniumMatchList = new SeleniumMatchList();
        WebElementFactory webElementFactory = new WebElementFactory(driver);
        SeleniumMatchBuilder seleniumMatchBuilder = new SeleniumMatchBuilder();

        driver.get("https://betwinner.com/results/");

        WebElement nastolkaButton = webElementFactory.getNastolkaButton();
        WebElement searchBox = webElementFactory.getSearchBox();

        nastolkaButton.click();

        for (String leagueName : leagues) {

            searchBox.sendKeys(leagueName);
            searchBox.sendKeys(Keys.ENTER);

            List<WebElement> matchList = webElementFactory.getMatchList();
            seleniumMatchList.addAll(seleniumMatchBuilder.getSeleniumMatchList(matchList, leagueName));

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
