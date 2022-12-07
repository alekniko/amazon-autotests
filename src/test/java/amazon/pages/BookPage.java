package amazon.pages;

import amazon.BaseFunctions;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class BookPage {
    private final BaseFunctions baseFunc;

    public BookPage(BaseFunctions baseFunc) {
        this.baseFunc = baseFunc;
    }

    private final By TITLE = By.xpath(".//span[@id='productTitle']");
    private final By COMMENT_COUNT = By.xpath(".//div[@id='averageCustomerReviews_feature_div']//span[@id='acrCustomerReviewText']");

    public void checkPageTitleIsCorrect(String expectedTitle) {
        String actualTitleText = baseFunc.getElement(TITLE).getText();
        Assertions.assertEquals(expectedTitle, actualTitleText, "Incorrect book title");
    }

    public void checkCommentCountIsCorrect(String expectedCount) {
        String actualCommentCount = baseFunc.getElement(COMMENT_COUNT).getText().replaceAll("[^0-9]", "");
        System.out.println(actualCommentCount);
        Assertions.assertEquals(expectedCount, actualCommentCount, "Incorrect comment count");
    }

}
