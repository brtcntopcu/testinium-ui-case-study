package page;

import base.PageBase;
import org.openqa.selenium.WebDriver;

public class ProductPage extends PageBase {

    public static String PRODUCT_BRAND_NAME_CLASS_NAME = "o-productDetail__brandLink";
    public static String PRODUCT_DESCRIPTION_CLASS_NAME = "o-productDetail__description";
    public static String PRODUCT_PRICE_CLASS_NAME = "m-price__new";
    public static String PRODUCT_SIZES_XPATH = "//*[@id=\"sizes\"]/div/span";
    public static String ADD_BASKET_BUTTON_ID = "addBasket";
    public static String GO_BASKET_BUTTON_ON_NOTIFICATION_CSS_SELECTOR = "div.m-notification.success >button.m-notification__button.btn";

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        String productBrandName = getElementTextByClassName(PRODUCT_BRAND_NAME_CLASS_NAME);
        String productDescription = getElementTextByClassName(PRODUCT_DESCRIPTION_CLASS_NAME);

        return productBrandName + " " + productDescription;
    }

    public String getProductPrice() {
        return getElementTextByClassName(PRODUCT_PRICE_CLASS_NAME);
    }

    public void clickProductSize() {
        scrollUntilFindXPATH(PRODUCT_SIZES_XPATH);
        int elementSize = pickElementGroup(PRODUCT_SIZES_XPATH).size();
        for(int i = 0; i < elementSize; i++){
            if(pickElementGroup(PRODUCT_SIZES_XPATH).get(i).isEnabled() & pickElementGroup(PRODUCT_SIZES_XPATH).get(i).isDisplayed()){
                pickElementGroup(PRODUCT_SIZES_XPATH).get(i).click();
            }
        }
    }

    public void clickAddBasketButton(){
        clickById(ADD_BASKET_BUTTON_ID);
    }

    public void clickGoBasketButtonAfterAddBasket() {
        clickByCSSSelector(GO_BASKET_BUTTON_ON_NOTIFICATION_CSS_SELECTOR);
    }
}
