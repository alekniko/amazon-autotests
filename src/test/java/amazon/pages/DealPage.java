package amazon.pages;

import amazon.BaseFunctions;
import org.openqa.selenium.By;

public class DealPage {

    private final BaseFunctions baseFunc;

    public DealPage(BaseFunctions baseFunc) {
        this.baseFunc = baseFunc;
    }

    private final By HEADER = By.xpath(".//h1");

    public String getHeaderName () {
        return baseFunc.getElement(HEADER).getText();
    }
}
