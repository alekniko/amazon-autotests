package amazon.tests;

import amazon.BaseFunctions;
import amazon.pages.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AmazonWebPageTests {

    private BaseFunctions baseFunc;
    private BestSellersPage bestSellers;
    private BookPage bookPage;
    private HomePage homePage;
    private TodaysDealsPage todaysDealsPage;
    private DealPage dealPage;
    private SearchResultPage resultPage;

    private final String BEST_SELLERS_URL = "https://www.amazon.com/gp/bestsellers/";
    private final String HOME_PAGE_URL = "https://www.amazon.com/ref=nav_logo";
    private final int SELECTED_BOOK = 2;
    private final String ITEM_TO_FIND = "Kindle Paperwhite";

    @BeforeEach
    public void before() {
        baseFunc = new BaseFunctions();
        bestSellers = new BestSellersPage(baseFunc);
        bookPage = new BookPage(baseFunc);
        homePage = new HomePage(baseFunc);
        todaysDealsPage = new TodaysDealsPage(baseFunc);
        dealPage = new DealPage(baseFunc);
        resultPage = new SearchResultPage(baseFunc);
    }

    @AfterEach
    public void after() {
        baseFunc.closeBrowser();
    }

    @Test
    public void checkCommentCommentCountIsCorrect() {
        baseFunc.openUrl(BEST_SELLERS_URL);
        baseFunc.closeChangeCountryPopUp();

        bestSellers.checkPageHeader();
        bestSellers.selectOptionFromLeftMenu("Books");
        bestSellers.checkGridName();
        String selectedBookName = bestSellers.getBookName(SELECTED_BOOK);
        String selectedBookCommentCount = bestSellers.getCommentCount(SELECTED_BOOK);
        bestSellers.openSelectedBookPage(SELECTED_BOOK);
        bookPage.checkPageTitleIsCorrect(selectedBookName);
        bookPage.checkCommentCountIsCorrect(selectedBookCommentCount);
    }

    @Test
    public void checkTodayDeals() {
        baseFunc.openUrl(HOME_PAGE_URL);
        baseFunc.closeChangeCountryPopUp();

        homePage.selectFromMainMenu("Today's Deals");
        todaysDealsPage.selectOptionFromLeftMenu("Books");
        String productNameInGrid = todaysDealsPage.getProductName(5);
        todaysDealsPage.selectProductByName(productNameInGrid);
        String productNameInHeader = dealPage.getHeaderName();
        System.out.println(productNameInGrid);
        System.out.println(productNameInHeader);
        Assertions.assertEquals(productNameInGrid,productNameInHeader,
                "Product name in grit is not the same as product name in header");
    }

    @Test
    public void checkSearchField() {
        baseFunc.openUrl(HOME_PAGE_URL);
        baseFunc.closeChangeCountryPopUp();

        homePage.SearchFor(ITEM_TO_FIND);
        resultPage.checkFirstResultsAreCorrect(5, ITEM_TO_FIND);
    }
}
