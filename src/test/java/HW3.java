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
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='item-title__title']")));
        WebElement nameElement = webDriver.findElement(By.xpath("//div[@class='tender--head--title col-sm-9']"));
        WebElement costElement = webDriver.findElement(By.xpath("//strong[contains(text(),'98 940,00')]/span[@class='small']"));
        WebElement statusElement = webDriver.findElement(By.xpath("//span[@class='marked'][contains(text(),'Завершена')]"));
        WebElement companyElement = webDriver.findElement(By.xpath("//td[@class='col-sm-6' and contains(text(), 'Комунальне некомерційне підприємство Білоцерківської міської ради \"Білоцерківська міська лікарня №2\"')]"));
        String name = nameElement.getText(); String tender  = "Меблі (тумба мобільна, тумба, тумба приставна)";
        String cost = "98 940,00 UAH";
        String status = "Завершена";
        String company = "Комунальне некомерційне підприємство Білоцерківської міської ради \"Білоцерківська міська лікарня №2\" • Біла Церква";
        System.out.println("Название: " + name);
        System.out.println("Стоимость: " + cost);
        System.out.println("Статус: " + status);
        System.out.println("Компания: " + company);
    }
}
