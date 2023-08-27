import io.qameta.allure.junit4.DisplayName;
import model.RegistrationPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static junit.framework.TestCase.assertTrue;
import static model.RegistrationPage.*;

public class PasswordMustContainAtLeast6SymbolsTest {

    private WebDriver driver;
    @Before
    public void beforeTest() {
        driver = BrowserDriverSetting.browserDriverSetUp();
    }

    @Test
    @DisplayName("Регистрации пользователя. Некорретный пароль = 5 символов.")
    public void passwordMustContainAtLeast6SymbolsTest(){
        RegistrationPage page = new RegistrationPage(driver);
        page.openPage(REGISTRATION_PAGE_URL);
        page.findElementAndInputData(FIELD_PASSWORD,"12345");
        page.findAndClickElement(REGISTRATION_BUTTON);
        assertTrue(page.isElementDisplayed(page.findElement(INCORRECT_PASSWORD_LABEL)));
    }

    @After
    public void afterTest() {
        driver.quit();
    }
}