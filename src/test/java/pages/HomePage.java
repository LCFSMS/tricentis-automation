package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;

    private final By pageTitle = By.cssSelector("div.topic-html-content");//локатор заголовка страницы. ищем класс topic-html-content в div

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();//Находит элемент по локатору и получает его видимый текст
    }

    public void clickRegisterLink() {
        driver.findElement(By.cssSelector("a.ico-register")).click();
    }

    //Выйти из учетки
    public void clickLogOutLink() {
        driver.findElement(By.cssSelector("a.ico-logout")).click();
    }

    public void clickLogInLink() {
        driver.findElement(By.cssSelector("a.ico-login")).click();
    }

    //Возвращает имя пользователя
    public String getLoggedInUserEmail(){
        return driver.findElement(By.cssSelector("a.account")).getText();
    }

}
