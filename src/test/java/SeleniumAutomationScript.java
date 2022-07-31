import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class SeleniumAutomationScript {
    @Test
    public void login() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://seleniumui.moderntester.pl/form.php");

        WebElement firstName = driver.findElement(By.id("inputFirstName3"));
        firstName.sendKeys("Asia");

        WebElement lastName = driver.findElement(By.xpath("//*[@id='inputLastName3']"));
        lastName.sendKeys("Kacprowska");
        firstName.clear();
        //WebElement mail = driver.findElement(By.cssSelector("#inputEmail3"));
        driver.findElement(By.cssSelector("#inputEmail3")).sendKeys("test@gmail.com");
        List<WebElement> elements = driver.findElements(By.xpath("//input[@name='gridRadiosSex']"));

        for (WebElement element : elements) {
            element.click();
            Thread.sleep(500);
        }

        //pole age
        WebElement age = driver.findElement(By.cssSelector("#inputAge3"));
        age.sendKeys("24");
        //year of experience
        WebElement yearOfExperience = driver.findElement(By.xpath("//input[@id='gridRadios1']"));
        yearOfExperience.click();
        //profession
        WebElement profession = driver.findElement(By.xpath("//input[@id='gridCheckAutomationTester']"));
        profession.click();

        WebElement continent = driver.findElement(By.xpath("//select[@id='selectContinents']"));
        Select continents = new Select(continent);
        continents.selectByIndex(4);

        WebElement commands = driver.findElement(By.xpath("//select[@id='selectSeleniumCommands']"));
        Select commandsSelect = new Select(commands);
        for(int i = 0; i <=5; i++){
            commandsSelect.selectByIndex(i);
            Thread.sleep(1000);
        }

        WebElement field = driver.findElement(By.xpath("//textarea[@id='additionalInformations']"));
        field.sendKeys("test");
        Thread.sleep(1000);

        WebElement testFile = driver.findElement(By.xpath("//a[normalize-space()='Test File to Download']"));
        testFile.click();
        Thread.sleep(1000);

        WebElement sendSign = driver.findElement(By.xpath("//button[normalize-space()='Sign in']"));
        sendSign.click();
//Co można zrobić, aby poczekać na komunikat potwierdzenia i dopiero dalej?
        Thread.sleep(1000);
        
        Thread.sleep(5000);
        driver.quit();
    }
}
