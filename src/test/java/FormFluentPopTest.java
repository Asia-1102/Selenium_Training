import org.testng.annotations.Test;
import pages.FormPage;

import java.io.File;

public class FormFluentPopTest extends TestBase{
    @Test
    public void shouldFillFormWithSuccess() {
        driver.get("https://seleniumui.moderntester.pl/form.php");
        File file = new File("src/main/resources/file.txt");
        FormPage formPage = new FormPage(driver);

        formPage.setFirstName("Mateusz")
                .setLastName("Nowak")
                .selectMaleGender()
                .setAge("55")
                .setEmail("mk@wp.pl")
                .selectYearsOfExperience(3)
                .selectManualTesterProfession()
                .selectContinent("europe")
                .selectSeleniumCommand("switch-commands")
                .uploadFile(file);

    }
}
