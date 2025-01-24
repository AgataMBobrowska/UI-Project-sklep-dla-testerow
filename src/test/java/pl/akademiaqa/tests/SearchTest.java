package pl.akademiaqa.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.pages.HomePage;

public class SearchTest extends BaseTest {

    private HomePage homePage;

    @BeforeEach
    void beforeEach() {
        homePage = new HomePage(page);
    }

    @Test
    void should_return_products_by_search_name_mug() {

        page.navigate("https://skleptestera.pl/index.php");
        homePage.getTopMenuSearchSection().searchForProducts("mug");

    }
}
