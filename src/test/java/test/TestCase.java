package test;

import Utils.Utils;
import base.TestBase;
import data.ExcelData;
import data.TXTFile;
import log.Log;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import page.*;

import java.io.*;
import java.util.Timer;

public class TestCase extends TestBase {

    TXTFile txtFile = new TXTFile();
    HomePage homePage = new HomePage(driver);
    SuggestionPage suggestionPage = new SuggestionPage(driver);
    SearchPage searchPage = new SearchPage(driver);
    ProductPage productPage = new ProductPage(driver);
    BasketPage basketPage = new BasketPage(driver);
    Utils utils = new Utils();
    Log log = new Log();
    ExcelData excelData = new ExcelData("src/main/resources/search_data.xlsx");

    @Test
    public void mainTest() throws IOException, InterruptedException {

        String firstItemToSearchFromExcel = excelData.getExcelData(0,0,0);
        String secondItemToSearchFromExcel = excelData.getExcelData(0,0,1);

        String expectedPageTitle = "Beymen.com – Türkiye’nin Tek Dijital Lüks Platformu";
        driver.get("https://www.beymen.com/");
        log.info("www.beymen.com sitesi açılır.");

        Assertions.assertEquals(expectedPageTitle,driver.getTitle());
        log.info("Ana sayfanın açıldığı kontrol edilir.");

        homePage.clickAcceptCookiesButton();
        homePage.clickGenderPopupCloseButton();
        homePage.enterInputSearchBar(firstItemToSearchFromExcel);
        log.info("Arama kutucuğuna “şort” kelimesi girilir.");

        homePage.clearSearchProductBarInput();
        log.info("Arama kutucuğuna girilen “şort” kelimesi silinir.");

        suggestionPage.searchProduct(secondItemToSearchFromExcel);
        log.info("Arama kutucuğuna “gömlek” kelimesi girilir. Klavye üzerinden “enter” tuşuna bastırılır.");

        searchPage.clickProduct();
        log.info("Sonuca göre sergilenen ürünlerden rastgele bir ürün seçilir.");

        Double productPriceInProductPage = utils.editPriceString(productPage.getProductPrice());
        String productName = productPage.getProductName();

        txtFile.write( productName + " " + productPriceInProductPage);
        log.info("Seçilen ürünün ürün bilgisi ve tutar bilgisi txt dosyasına yazılır. ");

        productPage.clickProductSize();
        productPage.clickAddBasketButton();
        log.info("Seçilen ürün sepete eklenir");

        productPage.clickGoBasketButtonAfterAddBasket();
        Double productPriceInBasket = utils.editPriceString(basketPage.getProductPrice());
        Assertions.assertEquals(productPriceInProductPage, productPriceInBasket);
        log.info("Ürün sayfasındaki fiyat ile sepette yer alan ürün fiyatının doğruluğu karşılaştırılır.");

        String productCountInCart = "2";
        basketPage.selectProductCount(productCountInCart);
        Thread.sleep(2000);
        Double expectedCountedPrice = productPriceInProductPage*Integer.parseInt(productCountInCart);
        Double actualCountedPrice = utils.editPriceString(basketPage.getProductPrice());
        Assertions.assertEquals(expectedCountedPrice,actualCountedPrice);
        log.info("Adet arttırılarak ürün adedinin 2 olduğu doğrulanır.");

        basketPage.clickRemoveButton();
        Thread.sleep(2000);
        Assertions.assertTrue(basketPage.isBasketEmpty());
        log.info("Ürün sepetten silinerek sepetin boş olduğu kontrol edilir. ");
    }

}
