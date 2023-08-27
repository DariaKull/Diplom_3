package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends Page{

    public final static String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site";
    //Надпись "Соберите бургер"
    public final static By SET_BURGER_HEADER = By.xpath("//h1[text()='Соберите бургер']");
    //Кнопка "Войти в аккаунт"
    public final static By SIGN_IN_ACCOUNT_BUTTON = By.xpath("//button[text()='Войти в аккаунт']");

    //Ссылка "Конструктор"
    public final static By CONSTRUCTOR_LINK = By.xpath("//p[text()='Конструктор']");
    //Ссылка "Лента заказов"
    public final static By FEED_LINK = By.xpath("//p[text()='Лента Заказов']");
    //Ссылка "Логотип"
    public final static By LOGO_LINK = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']");
    //Ссылка "Личный кабинет"
    public final static By PROFILE_LINK = By.xpath("//a[@href='/account']");
    //Контейнер элементов, конкретного меню
    public final static String MENU_ELEMENTS = "//div[@class='BurgerIngredients_ingredients__menuContainer__Xu3Mo']/ul[%s]/a";
    //Переключатель "Булки"
    public final static By BUNS = By.xpath("//span[text()='Булки']");
    //Надпись "Булки"
    public final static By LABEL_BUNS = By.xpath("//h2[text()='Булки']");
    //Переключатель "Соусы"
    public final static By SAUCES = By.xpath("//span[text()='Соусы']");
    //Надпись "Соусы"
    public final static By LABEL_SAUCES = By.xpath("//h2[text()='Соусы']");
    //Переключатель "Начинки"
    public final static By INGREDIENTS = By.xpath("//span[text()='Начинки']");
    //Надпись "Начинки"
    public final static By LABEL_INGREDIENTS = By.xpath("//h2[text()='Начинки']");

    public MainPage(WebDriver driver) {
        super(driver);
    }
}