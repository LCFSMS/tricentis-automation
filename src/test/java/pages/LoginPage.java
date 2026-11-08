package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    private By email = By.id("Email");
    private By password = By.id("Password");
    private By loginButton = By.cssSelector("input.button-1.login-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillLoginForm(String email, String password){
        driver.findElement(this.email).sendKeys(email);
        driver.findElement(this.password).sendKeys(password);
    }

    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }

    public boolean isLoginSuccessful(){
        String text = driver.findElement(By.cssSelector("div.validation-summary-errors")).getText();
        return text.contains("Login was unsuccessful");
    }
}
