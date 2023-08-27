import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import model.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static model.ForgotPasswordPage.*;
import static model.LoginPage.*;
import static model.MainPage.*;
import static model.RegistrationPage.*;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class UserLoginTest {
    private WebDriver driver;
    private UserClient userClient;
    private String accessToken;
    private User user;
    private final String url;
    private final By locator;

    public UserLoginTest(String url, By locator){
        this.url = url;
        this.locator = locator;
    }

    @Parameterized.Parameters(name = "{index}: Страница - {0}, элемент - {1}")
    public static Object[][] orderData() {
        return new Object[][]{
                {MAIN_PAGE_URL, SIGN_IN_ACCOUNT_BUTTON},
                {MAIN_PAGE_URL, PROFILE_LINK},
                {FORGOT_PASSWORD_PAGE_URL, SIGN_IN_LINK},
                {REGISTRATION_PAGE_URL, REGISTRATION_SIGN_IN_LINK}
        };
    }

    @Before
    public void beforeTest() {
        driver = BrowserDriverSetting.browserDriverSetUp();
        user = UserGenerator.getRandomUser();
        userClient = new UserClient();
        ValidatableResponse createResponse = userClient.createUser(user);
        accessToken = createResponse.extract().path("accessToken");
    }

    @Test
    @DisplayName("Вход пользователя с разных страниц")
    public void userLoginTest(){
        MainPage page = new MainPage(driver);
        page.openPage(url);
        page.findAndClickElement(locator);
        assertTrue(page.isElementDisplayed(page.findElement(LOGIN_HEADER)));
        page.findElementAndInputData(FIELD_EMAIL_LOGIN, user.getEmail());
        page.findElementAndInputData(FIELD_PASSWORD_LOGIN, user.getPassword());
        page.findAndClickElement(LOGIN_BUTTON);
        assertTrue(page.isElementDisplayed(page.findElement(SET_BURGER_HEADER)));
    }

    @After
    public void afterTest() {
        driver.quit();
        userClient.deleteUser(accessToken);
    }
}
