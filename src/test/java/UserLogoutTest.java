import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import model.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import static model.LoginPage.*;
import static model.MainPage.*;
import static model.ProfilePage.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserLogoutTest {
    private WebDriver driver;
    private User user;
    private UserClient userClient;
    private String accessToken;

    @Before
    public void beforeTest() {
        driver = BrowserDriverSetting.browserDriverSetUp();
        user = UserGenerator.getRandomUser();
        userClient = new UserClient();
        ValidatableResponse createResponse = userClient.createUser(user);
        accessToken = createResponse.extract().path("accessToken");
        MainPage page = new MainPage(driver);
        page.openPage(MAIN_PAGE_URL);
        page.findAndClickElement(SIGN_IN_ACCOUNT_BUTTON);
        page.findElementAndInputData(FIELD_EMAIL_LOGIN, user.getEmail());
        page.findElementAndInputData(FIELD_PASSWORD_LOGIN, user.getPassword());
        page.findAndClickElement(LOGIN_BUTTON);
    }

    @Test
    @DisplayName("Выход пользователя из аккаунта")
    public void UserLogoutTest(){
        MainPage page = new MainPage(driver);
        page.findAndClickElement(PROFILE_LINK);
        assertEquals(user.getName(), page.findElement(FIELD_NAME_PROFILE).getAttribute("value"));
        assertEquals(user.getEmail().toLowerCase(), page.findElement(FIELD_EMAIL_PROFILE).getAttribute("value"));
        page.findAndClickElement(LOGOUT_BUTTON);
        assertTrue(page.isElementDisplayed(page.findElement(LOGIN_HEADER)));
    }

    @After
    public void afterTest() {
        driver.quit();
        userClient.deleteUser(accessToken);
    }
}


