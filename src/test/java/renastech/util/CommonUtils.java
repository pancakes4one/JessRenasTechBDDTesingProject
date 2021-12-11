package renastech.util;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import java.time.Duration;
import java.util.Random;
import java.util.function.Function;

public class CommonUtils {

// Util 1:
public static void clickWithWait(WebElement webElement) {
    Wait wait = new FluentWait(Driver.getDriver())
            .withTimeout(Duration.ofSeconds(15))
            .pollingEvery(Duration.ofMillis(800))
            .ignoring(NoSuchElementException.class)
            .ignoring(ElementNotVisibleException.class)
            .ignoring(ElementClickInterceptedException.class)
            .ignoring(StaleElementReferenceException.class)
            .ignoring(WebDriverException.class);

    WebElement element = (WebElement) wait.until((Function<WebDriver, WebElement>) driver -> webElement);
    try { element.click(); } catch (WebDriverException e) { e.printStackTrace(); }
    try { Thread.sleep(1000); } catch (Exception e) { e.printStackTrace(); }
    }

 // Util 2:
    public static void selectFromDropdown(WebElement element,String text) {
        Select select = new Select(element);
        select.selectByValue(text);
        try { Thread.sleep(1000); } catch (Exception e) { e.printStackTrace(); }
    }

// Util 3:
    public static int getRandomNumBetween(int lowBound, int upBound) {
        Random random = new Random();
        return (random.nextInt(upBound) + lowBound);
    }

// Util 4:
    public static String getRandomThreeNumberString() {
        Random random = new Random();
        int num = random.nextInt(999);
        return String.format("%03d", num);
    }

//    Util 5:
    public static void moveToElement(WebElement element){
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element);
    }
}
