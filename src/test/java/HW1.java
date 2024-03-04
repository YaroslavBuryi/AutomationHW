import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HW1 {
    private WebDriver webDriver;

    @BeforeMethod
    public void initDriver() {
        webDriver = new ChromeDriver();
    }

    @AfterMethod()
    public void destroy() {
        webDriver.quit();
    }

    @Test
    public void firstTest() {
        webDriver.get("https://rozetka.com.ua/");
        WebElement inputElement = webDriver.findElement(By.xpath("//input[@class=\"search-form__input ng-untouched ng-pristine ng-valid\" and @type=\"text\" and @name=\"search\" and @formcontrolname=\"text\" and @placeholder=\"Я шукаю...\"]"));
        Assert.assertTrue(inputElement.isDisplayed(), "Page is not opened successfully");
    }
}
