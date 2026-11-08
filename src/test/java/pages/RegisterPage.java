package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private WebDriver driver;

    //локаторы для полей формы регистрации
    private By firstName = By.id("FirstName");
    private By lastName = By.id("LastName");
    private By email = By.id("Email");
    private By password = By.id("Password");
    private By confirmPassword = By.id("ConfirmPassword");
    private By registerButton = By.id("register-button");

    private By successMessage = By.cssSelector("div.result");//локатор сообщения об успешной регистрации
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillRegistrationForm(String firsName, String lastName, String email, String password, String confirmPassword) {
        driver.findElement(this.firstName).sendKeys(firsName);
        driver.findElement(this.lastName).sendKeys(lastName);
        driver.findElement(this.email).sendKeys(email);
        driver.findElement(this.password).sendKeys(password);
        driver.findElement(this.confirmPassword).sendKeys(confirmPassword);
    }


    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    public boolean isRegistrationSuccessful(){
        String text = driver.findElement(successMessage).getText(); //получение текста из блока сообщения об успешной регистрации
        return text.contains("Your registration completed");
    }
}
