package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CategoryPage {
    private WebDriver driver;
    private By productPrices = By.cssSelector(".price.actual-price");//локатор на цену
    private By sortDropdown = By.name("products-orderby");//локатор на сортировку

    public CategoryPage(WebDriver driver) {
        this.driver = driver;
    }

    //Сортировка по возрастанию цены
    public void sortByPriceLowToHigh(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //ожидание кликабельности
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(sortDropdown));

        Select select = new Select(dropdown);
        select.selectByContainsVisibleText("Price: Low to High");

        //Без этого ожидания цены прочитаются из старого DOM, до сортировки
        wait.until(ExpectedConditions.presenceOfElementLocated(productPrices));
    }

    //Возвращает список цен на товары
    public List<Double> getAllPrices(){
        List<WebElement> webElementList = driver.findElements(productPrices);
        ArrayList<Double> prices = new ArrayList<>();

        for(WebElement element: webElementList){
            //Убираем символ $ и лишние пробелы
            prices.add(Double.parseDouble(element.getText().replace("$", "").trim()));
        }
        return prices;
    }
}
