package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");//Скрываем флаги автоматизации
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();//разворачиваем окно на весь экран
    }

    @AfterClass
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }
}
