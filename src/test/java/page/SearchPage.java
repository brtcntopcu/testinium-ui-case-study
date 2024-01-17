package page;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class SearchPage extends PageBase {

    public SearchPage(WebDriver driver) {
        super(driver);
    }
    Random rand = new Random();

    public static String SEARCH_RESULT_ITEMS_CLASS_NAME = "m-productImageList";

    public void clickProduct() {
        List<WebElement> productsOnSearchResult = super.driver.findElements(By.className(SEARCH_RESULT_ITEMS_CLASS_NAME));

        int rand_int1 = rand.nextInt(productsOnSearchResult.size());
        WebElement randomElement = productsOnSearchResult.get(rand_int1);
        click(randomElement);
    }

}
