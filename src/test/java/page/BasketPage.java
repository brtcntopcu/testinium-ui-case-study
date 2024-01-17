package page;

import base.PageBase;
import org.openqa.selenium.WebDriver;

public class BasketPage extends PageBase {
    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public static String PRODUCT_PRICE_CLASS_NAME = "m-productPrice__salePrice";
    public static String QUANTITY_SELECT_LIST_ID = "quantitySelect0-key-0";
    public static String REMOVE_CART_BUTTON_ID = "removeCartItemBtn0-key-0";
    public static String EMPTY_BASKET_MESSAGE_TITLE_TEXT = "Sepetinizde Ürün Bulunmamaktadır";

    public String getProductPrice() {
        return getElementTextByClassName(PRODUCT_PRICE_CLASS_NAME);
    }

    public void selectProductCount(String productCount) {
        dropDownMenu(QUANTITY_SELECT_LIST_ID).selectByValue(productCount);
    }

    public void clickRemoveButton() {
        clickById(REMOVE_CART_BUTTON_ID);
    }

    public Boolean isBasketEmpty() {
        return driver.getPageSource().contains(EMPTY_BASKET_MESSAGE_TITLE_TEXT);
    }
}
