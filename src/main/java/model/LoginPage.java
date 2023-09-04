package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Page{

    public final static String LOGIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/login";
    //Надпись "Вход"
    public final static By LOGIN_HEADER = By.xpath("//h2[text()='Вход']");
    //Поле "Email"
    public final static By FIELD_EMAIL_LOGIN = By.xpath("//label[text()='Email']//following::input[1]");
    //Поле "Пароль"
    public final static By FIELD_PASSWORD_LOGIN = By.xpath("//input[@name='Пароль']");
    //Кнопка "Войти"
    public final static By LOGIN_BUTTON = By.xpath("//button[text()='Войти']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }
}
