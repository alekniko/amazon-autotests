package amazon.pages;

import amazon.BaseFunctions;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    private final BaseFunctions baseFunc;

    public HomePage(BaseFunctions baseFunc) {

        this.baseFunc = baseFunc;
    }

    private final By MAIN_MENU_ITEMS = By.xpath(".//div[@id='nav-xshop']/a");
    private final By SEARCH_INPUT_FIELD = By.xpath(".//input[@name='field-keywords']");

    public void selectFromMainMenu(String menuBtnName) {
        List<WebElement> menuItems = baseFunc.getElements(MAIN_MENU_ITEMS);
        boolean isClicked = false;
        for (WebElement we : menuItems) {
            if (we.getText().equals(menuBtnName)) {
                we.click();
                isClicked = true;
                break;
            }
        }
        Assertions.assertTrue(isClicked, "Not possible to click on menu button");
    }

    public void SearchFor(String TextToFind) {
        baseFunc.type(SEARCH_INPUT_FIELD, TextToFind);
        baseFunc.pressKey(SEARCH_INPUT_FIELD, Keys.ENTER);
    }
}
