import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTest extends TestBase{

    @Test
    public void shouldFillFormWithSuccess() throws InterruptedException {
        driver.get("https://seleniumui.moderntester.pl/alerts.php");
        WebElement prompt = driver.findElement(By.cssSelector("#prompt-alert"));
        prompt.click();
        driver.switchTo().alert().sendKeys("Asia");
        driver.switchTo().alert().accept();
        WebElement text = driver.findElement(By.id("prompt-label"));
        String actual = text.getText();
        Assert.assertEquals(actual, "Hello Asia! How are you today?");
        Thread.sleep(1000);


        // kliknąć w przycisk Prompt Pop up
        // w alercie wpisz: Jan


        // w alercie kliknij OK
        //driver.switchTo().alert().accept();

        // sprawdź asercją czy tekst pod przyciskiem jest równy
        // Hello Jan! How are you today?
    }
}
