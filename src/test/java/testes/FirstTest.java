package testes;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class FirstTest extends BaseTest {

    @Test
    public void testHomePageTitle(){
        driver.get("https://demowebshop.tricentis.com/");

        HomePage homePage = new HomePage(driver);

        String actualTitle = homePage.getPageTitle();

        Assert.assertTrue(actualTitle.contains("Welcome"), "Заголовок не содержит 'Welcome'. Фактический заголовок: " + actualTitle);
    }
}
