package pl.akademiaqa.tests;

import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pl.akademiaqa.pages.HomePage;
import pl.akademiaqa.pages.SearchResultPage;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SearchTest extends BaseTest {

    private HomePage homePage;

    @BeforeEach
    void beforeEach() {

        homePage = new HomePage(page);
        page.navigate("https://skleptestera.pl/index.php");
    }

    @Test
    void should_return_products_by_search_name_mug() {
        SearchResultPage searchResultPage = homePage.getTopMenuSearchSection().searchForProducts("mug");
        assertThat(searchResultPage.getSearchResultSection().getProducts().size()).isEqualTo(5);
    }

    @Test
    void should_return_products_by_search_name_frame() {
        SearchResultPage searchResultPage = homePage.getTopMenuSearchSection().searchForProducts("frame");
        assertThat(searchResultPage.getSearchResultSection().getProducts().size()).isEqualTo(4);
    }

    @Test
    void should_return_products_by_search_name_tshirt() {
        SearchResultPage searchResultPage = homePage.getTopMenuSearchSection().searchForProducts("t-shirt");
        assertThat(searchResultPage.getSearchResultSection().getProducts().size()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(strings = {"mug", "t-shirt", "frame"})
    void should_return_products_by_product_name(String productName) {
        SearchResultPage searchResultPage = homePage.getTopMenuSearchSection().searchForProducts(productName);
        assertThat(searchResultPage.getSearchResultSection().getProducts().size()).isGreaterThan(0);
    }
}
