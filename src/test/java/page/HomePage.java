package page;

import base.PageBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageBase {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public static String ACCEPT_COOKIES_BUTTON_ID = "onetrust-accept-btn-handler";
    public static String GENDER_POPUP_CLOSE_POPUP_CLASS_NAME = "bwi-close";
    public static String HEADER_SEARCH_INPUT_CLASS_NAME = "o-header__search--input";
    public static String DELETE_BUTTON_IN_SEARCH_BAR_CLASS_NAME = "o-header__search--close";
    public static String SEARCH_BUTTON_SEARCH_BAR_CLASS_NAME = "o-header__search--btn";

    public void clickAcceptCookiesButton() {
        clickById(ACCEPT_COOKIES_BUTTON_ID);
    }

    public void clickGenderPopupCloseButton() {
        clickByClassName(GENDER_POPUP_CLOSE_POPUP_CLASS_NAME);
    }

    public void enterInputSearchBar(String value) {
        sendKeyByClassName(HEADER_SEARCH_INPUT_CLASS_NAME, value);
    }

    public void clearSearchProductBarInput() {
        clickByClassName(DELETE_BUTTON_IN_SEARCH_BAR_CLASS_NAME);
    }


}
