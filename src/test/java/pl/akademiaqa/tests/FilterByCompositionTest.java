package pl.akademiaqa.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.pages.ArtPage;
import pl.akademiaqa.pages.HomePage;
import pl.akademiaqa.utils.Properties;

class FilterByCompositionTest extends BaseTest {

    private HomePage homePage;

    @BeforeEach
    void beforeEach() {
        homePage = new HomePage(page);
        page.navigate(Properties.getProperty("app.url"));
        homePage.getTopNavigationSection().setPageLanguageToEn();
    }

    @Test
    void should_return_matt_paper_products() {
        ArtPage artPage = homePage.getTopMenuSearchSection().clickArtLink();
        artPage.getFilterByComposition().clickMattPaper();
        int mattPaperProductCount = artPage.getFilterByComposition().countMattPaperProducts();
        System.out.println("Number of Matt paper products: " + mattPaperProductCount);
    }
}
