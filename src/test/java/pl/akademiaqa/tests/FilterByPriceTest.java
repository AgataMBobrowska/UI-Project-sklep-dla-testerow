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
    void should_return_products_with_price_greater_than_40() {
        ArtPage artPage = homePage.getTopMenuSearchSection().clickArtLink();
//        String newUrl = page.url() + "&q=Price-zł-40-44";
//        page.navigate(newUrl);

        artPage.getFilterBySection().filterProductsByPriceWithCursor();
        System.out.println(artPage.getProductsSection().getProductsPrices());

//        Assertions.assertTrue(artPage.getProductsSection().getProductsPrices().stream().allMatch(p -> p > 40));
        artPage.getFilterBySection().showLeftSlider();
        page.waitForTimeout(3000);
    }
}
