package Utils;

public class Utils {

    public Double editPriceString(String text) {
        String priceString =
                text.substring(0, text.length() - 3)
                        .replace(".", "")
                        .replace(",",".");
        return Double.parseDouble(priceString);
    }

}
