package controller.entity;

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

    public WebElement getNastolkaButton() {
        return generateWait(30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(NASTOLKA_BUTTON_XPATH)));
    }

    public WebElement getSearchBox() {
        return driver.findElement(By.xpath(SEARCHBOX_CLASS));
    }

    public List<WebElement> getMatchList() {
        return driver.findElements(By.className(MATCHBOX_CLASS));
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
