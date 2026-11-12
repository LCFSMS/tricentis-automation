package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");//Скрываем флаги автоматизации

        options.addArguments("--headless=new");//Запуск без видимого окна(новый режим) [reference: 1]
        options.addArguments("--no-sandbox");//Обход ограничений прав в контейнере [reference: 2]
        options.addArguments("--disable-dev-shm-usage");//Решает проблемы с нехваткой памяти
        options.addArguments("--user-data-dir=/tmp/chrome-profile-" + System.currentTimeMillis());//Уникальная папка профиля для каждого запуска[reference: 3]

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();//разворачиваем окно на весь экран
    }

    @AfterMethod
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }
}
