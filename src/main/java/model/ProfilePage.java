package model;

import org.openqa.selenium.By;

public class ProfilePage {
    //Поле "Имя"
    public final static By FIELD_NAME_PROFILE = By.xpath("//label[text()='Имя']//following::input[1]");
    //Поле "Логин"
    public final static By FIELD_EMAIL_PROFILE = By.xpath("//label[text()='Логин']//following::input[1]");
    //Кнопка "Выход"
    public final static By LOGOUT_BUTTON = By.xpath("//button[text()='Выход']");
}