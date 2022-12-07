package amazon.pages;

import amazon.BaseFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TodaysDealsPage {
    private final BaseFunctions baseFunc;

    public TodaysDealsPage(BaseFunctions baseFunc) {

        this.baseFunc = baseFunc;
    }

    private final By LEFT_MENU_OPTIONS = By.xpath(".//span[@data-testid='grid-filter-DEPARTMENTS']//ul/li//span");
    private final By PRODUCT_NAME = By.xpath(".//div[@data-testid='grid-deals-container']//a[2]");

    public void selectOptionFromLeftMenu(String optionName) {
        List<WebElement> menuOptions = baseFunc.getElements(LEFT_MENU_OPTIONS);
        for (WebElement we : menuOptions) {
            if (we.getText().equals(optionName)) {
                we.click();
                break;
            }
        }
    }

    public WebElement getProduct(int productOrderNumber) {
        baseFunc.waitElementToBeClickable(PRODUCT_NAME);
        List<WebElement> products = baseFunc.getElements(PRODUCT_NAME);
        return products.get(productOrderNumber - 1);
    }

    public String getProductName(int productOrderNumber) {
        return getProduct(productOrderNumber).getText();
    }

    public void selectProductByName(String name) {
        List<WebElement> products = baseFunc.getElements(PRODUCT_NAME);
        for (WebElement we: products) {
            if (we.getText().contains(name)) {
                we.click();
                break;
            }
        }
    }
}
