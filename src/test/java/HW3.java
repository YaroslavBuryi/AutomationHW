import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;
public class HW3 extends BaseTest {

    @Test
    public void retrieveSearchResultData() {
        String searchValue = "тумба";
        webDriver.get("https://prozorro.gov.ua/en");
        WebElement input = webDriver.findElement(By.xpath("//input[@class='search-text__input']"));
        input.clear();
        input.sendKeys(searchValue);
        input.sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='item-title__title']")));
        List<WebElement> searchResults = webDriver.findElements(By.xpath("//a[@class='item-title__title']"));
        searchResults.get(0).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='search-result-card__description']")));
        WebElement nameElement = webDriver.findElement(By.xpath("//div[@class='search-result-card__title']"));
        WebElement costElement = webDriver.findElement(By.xpath("//div[@class='search-result-card__cost']"));
        WebElement statusElement = webDriver.findElement(By.xpath("//div[@class='search-result-card__status']"));
        WebElement companyElement = webDriver.findElement(By.xpath("//div[@class='search-result-card__company']"));
        String name = nameElement.getText().trim();
        String cost = costElement.getText().trim();
        String status = statusElement.getText().trim();
        String company = companyElement.getText().trim();
        System.out.println("Название: " + name);
        System.out.println("Стоимость: " + cost);
        System.out.println("Статус: " + status);
        System.out.println("Компания: " + company);
    }
}
