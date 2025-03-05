package pl.akademiaqa.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.pages.HomePage;
import pl.akademiaqa.pages.ProductDetailsPage;
import pl.akademiaqa.pages.SearchResultPage;
import pl.akademiaqa.utils.Properties;

class PurchaseTest extends BaseTest {

    private HomePage homePage;

    @BeforeEach
    void beforeEach() {
        homePage = new HomePage(page);
        page.navigate(Properties.getProperty("app.url"));
        homePage.getTopNavigationSection().setPageLanguageToEn();
    }

    @Test
    void should_purchase_product_test() {
        SearchResultPage searchResultPage = homePage.getTopMenuSearchSection().searchForProducts("Customizable Mug");
        ProductDetailsPage productDetailsPage = searchResultPage.getSearchResultSection().viewProductDetails("Customizable Mug");
        productDetailsPage.getProductCustomizationSection().setCustomMessage("Hello");

        page.waitForTimeout(3000);
    }
}
