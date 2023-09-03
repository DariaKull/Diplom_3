import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import model.RegistrationPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import static model.LoginPage.*;
import static model.MainPage.PROFILE_LINK;
import static model.MainPage.SET_BURGER_HEADER;
import static model.ProfilePage.*;
import static model.RegistrationPage.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserRegistrationTest {
    private WebDriver driver;
    private User user;


    @Before
    public void beforeTest() {
        driver = BrowserDriverSetting.browserDriverSetUp();
        user = UserGenerator.getRandomUser();

    }

    @Test
    @DisplayName("Регистрация пользователя")
    public void userRegistrationTest(){
        RegistrationPage page = new RegistrationPage(driver);
        page.openPage(REGISTRATION_PAGE_URL);
        page.findElementAndInputData(FIELD_NAME, user.getName());
        page.findElementAndInputData(FIELD_EMAIL, user.getEmail());
        page.findElementAndInputData(FIELD_PASSWORD, user.getPassword());
        page.findAndClickElement(REGISTRATION_BUTTON);
        assertTrue(page.isElementDisplayed(page.findElement(LOGIN_HEADER)));
        page.findElementAndInputData(FIELD_EMAIL_LOGIN, user.getEmail());
        page.findElementAndInputData(FIELD_PASSWORD_LOGIN, user.getPassword());
        page.findAndClickElement(LOGIN_BUTTON);
        assertTrue(page.isElementDisplayed(page.findElement(SET_BURGER_HEADER)));
        page.findAndClickElement(PROFILE_LINK);
        assertEquals(user.getName(), page.findElement(FIELD_NAME_PROFILE).getAttribute("value"));
        assertEquals(user.getEmail().toLowerCase(), page.findElement(FIELD_EMAIL_PROFILE).getAttribute("value"));
        page.findAndClickElement(LOGOUT_BUTTON);
        assertTrue(page.isElementDisplayed(page.findElement(LOGIN_HEADER)));
    }

    @After
    public void afterTest() {
        driver.quit();
        UserClient userClient = new UserClient();
        ValidatableResponse loginResponse = userClient.loginUser(UserCredentials.from(user));
        userClient.deleteUser(loginResponse.extract().path("accessToken"));
    }
}
