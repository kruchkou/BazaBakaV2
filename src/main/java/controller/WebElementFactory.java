package controller;

import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WebElementFactory {

    private final ChromeDriver driver;

    private final String NASTOLKA_BUTTON_XPATH = "//*[@id=\"router_app\"]/div/div[2]/div/div/div[1]/div/section/ul/li[7]/a";
    private final String SEARCHBOX_CLASS = "//*[@id=\"searchGames\"]";
    private final String MATCHBOX_CLASS = "c-games__row_light";
    private final String CALENDAR_XPATH = "//*[@id=\"router_app\"]/div/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[1]";
    private final String BUTTON_PREV_MONTH_XPATH = "//*[@id=\"router_app\"]/div/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/header/span[1]";
    private final String APPLY_DATE_BUTTON_XPATH = "//*[@id=\"router_app\"]/div/div[2]/div/div/div[2]/div[2]/div/div/div[5]/div";
    private final String FREE_SPACE_XPATH = "//*[@id=\"router_app\"]/div/div[1]";
    private final String LEFT_DATES_XPATH = "//*[@id='router_app']/div/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/div/*[.!='' and not(starts-with(@class,'cell day-header')) and not(starts-with(@class,'cell day disabled'))]";

    public WebElement getNastolkaButton() {
        return generateWait(30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(NASTOLKA_BUTTON_XPATH)));
    }

    public void waitUntilMatchesLoaded() {
        generateWait(10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MATCHBOX_CLASS)));
    }

    public WebElement getCalendar() {
        return driver.findElement(By.xpath(CALENDAR_XPATH));
    }

    public WebElement getPrevMonthButton() {
        return driver.findElement(By.xpath(BUTTON_PREV_MONTH_XPATH));
    }

    public WebElement getApplyDateButton() {
        return driver.findElement(By.xpath(APPLY_DATE_BUTTON_XPATH));
    }

    public WebElement getFreeSpace() {
        return driver.findElement(By.xpath(FREE_SPACE_XPATH));
    }

    public WebElement getSearchBox() {
        return driver.findElement(By.xpath(SEARCHBOX_CLASS));
    }

    public List<WebElement> getMatchList() {
        return driver.findElements(By.className(MATCHBOX_CLASS));
    }

    public List<WebElement> getDayButtons() {
        return driver.findElements(By.xpath(LEFT_DATES_XPATH));
    }

    private WebDriverWait generateWait(int seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds));
    }

    //region GSC

    public WebElementFactory(ChromeDriver driver) {
        this.driver = driver;
    }

    //endregion
}
