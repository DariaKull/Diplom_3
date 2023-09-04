import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserDriverSetting {
    private final static Browser CURRENT_BROWSER = Browser.YANDEX;

    public static WebDriver browserDriverSetUp(){
        WebDriver driver = null;
        switch (CURRENT_BROWSER) {
            case YANDEX:
                System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\yandexdriver.exe");
                driver = new ChromeDriver();
                break;
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe");
                //WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
        }
        return driver;
    }
}