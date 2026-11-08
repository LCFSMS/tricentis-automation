package testes;

import Data.User;
import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;

public class RegisterTest extends BaseTest {

    //тест на регистрацию
    @Test
    public void testRegister() {
        driver.get("https://demowebshop.tricentis.com/");//переход на главную страницу

        User user = new User("Jon", "Doe",
                "test" + System.currentTimeMillis() + "@mail.com", "Password123", "Password123");

        HomePage homePage = new HomePage(driver);
        homePage.clickRegisterLink(); //нажатие на кнопку регистрации

        RegisterPage registerPage = new RegisterPage(driver);
        //заполнение формы для регистрации
        registerPage.fillRegistrationForm(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(), user.getConfirmPassword());
        //подтверждение регистрации(нажатие на кнопку в форме регистрации)
        registerPage.clickRegisterButton();
        Assert.assertTrue(registerPage.isRegistrationSuccessful(), "Регистрация не удалась");
    }
}
