package common;

import exception.FrameworkException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtil {
    private final WebDriver driver;
    private final JavaScriptUtil jsUtil ;

    public ElementUtil(WebDriver driver){

        this.driver=driver;
        jsUtil = new JavaScriptUtil(driver);

    }



    public WebElement getElement(By locator){

        WebElement element=driver.findElement(locator);
        isHighlight(element);
        return element;

    }
    private void isHighlight(WebElement element) {
        if (Boolean.parseBoolean(DriverFactory.highlight)) {
            jsUtil.flash(element);
        }
    }
    public By getBy(String locatorType, String locatorValue) {
        By by = null;

        switch (locatorType.toLowerCase().trim()) {
            case "id":
                by = By.id(locatorValue);
                break;
            case "name":
                by = By.name(locatorValue);
                break;
            case "class":
                by = By.className(locatorValue);
                break;
            case "xpath":
                by = By.xpath(locatorValue);
                break;
            case "css":
                by = By.cssSelector(locatorValue);
                break;
            case "linktext":
                by = By.linkText(locatorValue);
                break;
            case "partiallinktext":
                by = By.partialLinkText(locatorValue);
                break;
            case "tag":
                by = By.tagName(locatorValue);
                break;

            default:
                System.out.println("wrong locator type is passed..." + locatorType);
                throw new FrameworkException("WRONG LOCATOR TYPE");
        }

        return by;

    }
    public void doSendKeys(By locator, String value) {
        getElement(locator).sendKeys(value);
    }
    public void doClick(By locator) {
        getElement(locator).click();
    }


}
