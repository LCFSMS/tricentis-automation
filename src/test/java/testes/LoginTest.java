package testes;

import Data.User;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;

public class LoginTest extends BaseTest {


    @Test
    public void testLogin(){

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

        homePage.clickLogOutLink();
        homePage.clickLogInLink();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.fillLoginForm(user.getEmail(), user.getPassword());
        loginPage.clickLoginButton();

        Assert.assertEquals(homePage.getLoggedInUserEmail(), user.getEmail(), "Залогинен другой пользователь");


    }

    //Негативный тест (вход с неправельным паролем)
    @Test
    public void testLoginWithWrongPassword(){
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

        homePage.clickLogOutLink();
        homePage.clickLogInLink();

        LoginPage loginPage = new LoginPage(driver);

        //будет ошибка (неверный пароль)
        loginPage.fillLoginForm(user.getEmail(), "user.getPassword()");
        loginPage.clickLoginButton();

       Assert.assertTrue(loginPage.isLoginSuccessful(), "Пользователь как-то смог войти с неправельным паролем!");
    }
}
