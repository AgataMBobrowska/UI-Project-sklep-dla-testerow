package pl.akademiaqa.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.pages.HomePage;
import pl.akademiaqa.utils.Properties;

public class PurchaseTest extends BaseTest{

    private HomePage homePage;


    @BeforeEach
    void beforeEach() {
        homePage = new HomePage(page);
        page.navigate(Properties.getProperty("app.url"));
        homePage.getTopNavigationSection().setPageLanguageToEn();
    }
    @Test
    void should_purchase_product_test() {
        homePage.getTopMenuSearchSection().searchForProducts("Customizable mug");
    }
}
