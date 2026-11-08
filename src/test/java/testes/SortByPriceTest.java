package testes;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CategoryPage;

import java.util.List;

public class SortByPriceTest extends BaseTest {

    //Проверка корректности сортировки товара по возрастанию цены
    @Test
    public void testSortByPriceLowToHigh(){
        driver.get("https://demowebshop.tricentis.com/books");

        CategoryPage categoryPage = new CategoryPage(driver);

        categoryPage.sortByPriceLowToHigh();
        List<Double> prices = categoryPage.getAllPrices();

        Assert.assertFalse(prices.isEmpty(), "Список цен пуст, товары не загрузились");
        for (Double price: prices){
            System.out.println(price);
        }
        for (int i = 1; i < prices.size(); i++) {
            Assert.assertTrue(prices.get(i) >= prices.get(i-1), "Сортировка не правильная");

        }
    }
}
