package amazon.pages;

import amazon.BaseFunctions;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BestSellersPage {
    private final BaseFunctions baseFunc;

    public BestSellersPage(BaseFunctions baseFunc) {
        this.baseFunc = baseFunc;
    }

    private final By HEADER = By.xpath(".//span[@id='zg_banner_text']");
    private final By LEFT_MENU_OPTIONS = By.xpath(".//div[@role='group']/div[@role='treeitem']/a");
    private final By BOOK_NAME = By.xpath(".//div[@class='zg-grid-general-faceout']//a[2]");
    private final By GRID_HEADER = By.xpath(".//h1[contains(@class, 'a-size-large')]");
    private final By COMMENT_COUNT = By.xpath(".//div[@class='zg-grid-general-faceout']//div[@class='a-icon-row']/a/span");

    private final String HEADER_NAME = "Amazon Best Sellers";
    private final String GRID_HEADER_NAME = "Best Sellers in Books";

    public void checkPageHeader() {
        baseFunc.waitElementDisplayed(HEADER);
        String headerText = baseFunc.getElement(HEADER).getText();
        Assertions.assertEquals(HEADER_NAME, headerText, "Incorrect header name!");
    }

    public void selectOptionFromLeftMenu(String optionName) {
        List<WebElement> menuOptions = baseFunc.getElements(LEFT_MENU_OPTIONS);
        for (WebElement we : menuOptions) {
            if (we.getText().equals(optionName)) {
                we.click();
                break;
            }
        }
    }

    public void checkGridName() {
        baseFunc.waitElementDisplayed(GRID_HEADER);
        String actualGridName = baseFunc.getElement(GRID_HEADER).getText();
        Assertions.assertEquals(GRID_HEADER_NAME, actualGridName, "Incorrect grid name");
    }

    public String getBookName(int bookPositionInGrid) {
        List<WebElement> books = baseFunc.getElements(BOOK_NAME);
        return books.get(bookPositionInGrid - 1).getText();
    }

    public void openSelectedBookPage(int bookPositionInGrid) {
        List<WebElement> books = baseFunc.getElements(BOOK_NAME);
        books.get(bookPositionInGrid - 1).click();
    }

    public String getCommentCount(int bookPositionInGrid) {
        List<WebElement> commentCountList = baseFunc.getElements(COMMENT_COUNT);
        return commentCountList.get(bookPositionInGrid - 1).getText().replaceFirst(",", "");
    }
}
