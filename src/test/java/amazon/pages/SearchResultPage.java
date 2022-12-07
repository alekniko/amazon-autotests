package amazon.pages;

import amazon.BaseFunctions;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultPage {
    private final BaseFunctions baseFunctions;

    public SearchResultPage(BaseFunctions baseFunctions) {
        this.baseFunctions = baseFunctions;
    }

    private final By SEARCH_RESULT_ITEM = By.xpath(".//div[contains(@class, 's-result-item') and @data-component-type='s-search-result']");

    public void checkFirstResultsAreCorrect(int resultsCount, String expectedResult) {
        List<WebElement> items = baseFunctions.getElements(SEARCH_RESULT_ITEM);
        for (int i = 0; i < resultsCount; i++) {
            String actualResult = items.get(i).getText();
            Assertions.assertTrue(actualResult.contains(expectedResult));
        }
    }
}
