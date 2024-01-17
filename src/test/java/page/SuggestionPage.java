package page;

import base.PageBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SuggestionPage extends PageBase {

    public SuggestionPage(WebDriver driver) {
        super(driver);
    }

    public static String HEADER_SEARCH_INPUT_NAME = "qSugesstion";

    public void searchProduct(String value) {
        sendKeyByName(HEADER_SEARCH_INPUT_NAME,value + Keys.ENTER);

    }
}
