package PageTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {
    //This method is used to click any element in the project
    public void clickElement(By locator) throws Exception {
        getWebElement(locator).click();
    }

    //This method is used to click any element in the project
    public WebElement findElement(By locator) throws Exception {
        getWebElement(locator);
        return null;
    }


    //This method is used to send keys to element in the project
    public void sendKeysToElement(By locator, String text) throws Exception {
        getWebElement(locator).sendKeys(text);
    }
    //This method is used to clear text in a text box
    public void clearText(By locator) throws Exception {
        getWebElement(locator).clear();
    }

    //this method is used to get the text that is inside a text box, used mainly in assertion tests
    public static String getValue(By locator) throws Exception {
        return DriverSingleton.getDriverInstance().findElement(locator).getAttribute("value");
    }

    //this method is used to get the text that is inside a text box, used mainly in assertion tests
    public static String getLink(By locator) throws Exception {
        return DriverSingleton.getDriverInstance().findElement(locator).getAttribute("href");
    }

    //this method is used to get an elements text
    public static String getText(By locator) throws Exception {
        return DriverSingleton.getDriverInstance().findElement(locator).getText();
    }

    //this method get the pages URL
    public static String getPageURL() throws Exception {
        return DriverSingleton.getDriverInstance().getCurrentUrl();
    }

    //this method get the pages meta title
    public static String getTitle() throws Exception {
        return DriverSingleton.getDriverInstance().getTitle();
    }

    //this method creates the web-element using the PageTests.DriverSingleton class, all the other methods in this class use it to call the "driver." commend
    private WebElement getWebElement(By locator) throws Exception {
        return DriverSingleton.getDriverInstance().findElement(locator);
    }
}
