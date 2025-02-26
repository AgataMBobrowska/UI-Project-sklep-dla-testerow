package pl.akademiaqa.tests;

import org.junit.jupiter.api.Assertions;
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
    void should_return_products_with_price_greater_than_40_by_url() {
        ArtPage artPage = homePage.getTopMenuSearchSection().clickArtLink();
        String newUrl = page.url() + "&q=Price-zł-40-44";
        page.navigate(newUrl);
        Assertions.assertTrue(artPage.getProductsSection().getProductsPrices().stream().allMatch(p -> p > 40));
    }

    @Test
    void should_return_products_with_price_greater_than_40_by_cursor() {
        ArtPage artPage = homePage.getTopMenuSearchSection().clickArtLink();
        artPage.getFilterBySection().filterProductsByPriceWithCursor(40.00);
        Assertions.assertTrue(artPage.getProductsSection().getProductsPrices().stream().allMatch(p -> p > 40));
    }

    @Test
    void should_return_products_with_price_greater_than_40_by_keyboard() {
        ArtPage artPage = homePage.getTopMenuSearchSection().clickArtLink();
        artPage.getFilterBySection().filterProductsByPriceWithKeyboard(40.00);
        Assertions.assertTrue(artPage.getProductsSection().getProductsPrices().stream().allMatch(p -> p > 40));
    }
}
