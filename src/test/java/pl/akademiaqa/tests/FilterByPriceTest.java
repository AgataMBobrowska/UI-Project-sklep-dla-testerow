package pl.akademiaqa.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.pages.ArtPage;
import pl.akademiaqa.pages.HomePage;
import pl.akademiaqa.utils.Properties;

class FilterByPriceTest extends BaseTest {

    private HomePage homePage;

    @BeforeEach
    void beforeEach() {
        homePage = new HomePage(page);
        page.navigate(Properties.getProperty("app.url"));
        homePage.getTopNavigationSection().setPageLanguageToEn();
    }

    @Test
    void should_return_products_with_price_greater_than_40() {
        System.out.println(page.url());
        ArtPage artPage = homePage.getTopMenuSearchSection().clickArtLink();
        System.out.println(page.url());
    }
}
