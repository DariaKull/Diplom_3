import io.qameta.allure.junit4.DisplayName;
import model.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;
import static model.MainPage.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(Parameterized.class)
public class SelectTypeComponentsBurgerTest {
    private WebDriver driver;
    private final By locatorTypeComponents;
    private final By locatorLabelComponents;
    private final int count;

    public SelectTypeComponentsBurgerTest(By locatorTypeComponents, By locatorLabelComponents, int count){
        this.locatorTypeComponents = locatorTypeComponents;
        this.locatorLabelComponents = locatorLabelComponents;
        this.count = count;
    }

    @Parameterized.Parameters(name = "{index}: Вид компонента - {0}")
    public static Object[][] orderData() {
        return new Object[][]{
                {BUNS, LABEL_BUNS, 1},
                {SAUCES, LABEL_SAUCES, 2},
                {INGREDIENTS, LABEL_INGREDIENTS, 3},
        };
    }

    @Before
    public void beforeTest() {
        driver = BrowserDriverSetting.browserDriverSetUp();
    }

    @Test
    @DisplayName("Состав бургера. Переход по табам: Булки, Соусы, Начинки")
    public void selectTypeComponentsBurgerTest() throws InterruptedException {
        MainPage page = new MainPage(driver);
        page.openPage(MAIN_PAGE_URL);
        if (locatorTypeComponents.equals(BUNS)) page.findAndClickElementWithWaitingAfter(SAUCES);
        page.findAndClickElementWithWaitingAfter(locatorTypeComponents);
        int yLocatorTypeComponents = page.findElement(locatorTypeComponents).getLocation().y;
        for (int i = 1; i <= count - 1; i++) {
            List<WebElement> elementsAbove = new ArrayList<>(driver.findElements(By.xpath(String.format(MENU_ELEMENTS, i))));
            for (WebElement element:elementsAbove) {
                int yElement = element.getLocation().y;
                assertTrue(yElement < yLocatorTypeComponents);
            }
        }
        int yLocatorLabelComponents = page.findElement(locatorLabelComponents).getLocation().y;
        assertTrue(yLocatorLabelComponents > yLocatorTypeComponents);
    }

    @After
    public void afterTest() {
        driver.quit();
    }
}
