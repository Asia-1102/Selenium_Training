import org.testng.annotations.Test;
import pages.FormPage;

import java.io.File;

public class ForPopTest extends TestBase {

    @Test
    public void shouldFillFormWithSuccess() {
        driver.get("https://seleniumui.moderntester.pl/form.php");
        File file = new File("src/main/resources/file.txt");
        FormPage formPage = new FormPage(driver);

        formPage.setFirstName("Mateusz");
        formPage.setLastName("Nowak");
        formPage.selectMaleGender();
        formPage.setAge("55");
        formPage.setEmail("mk@wp.pl");
        formPage.selectYearsOfExperience(3);
        formPage.selectManualTesterProfession();
        formPage.selectContinent("europe");
        formPage.selectSeleniumCommand("switch-commands");
        formPage.uploadFile(file);

    }
}