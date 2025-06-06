package pl.akademiaqa.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.akademiaqa.pages.HomePage;
import pl.akademiaqa.pages.SearchResultPage;
import pl.akademiaqa.utils.Properties;
import java.util.stream.Stream;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SearchTest extends BaseTest {

    private HomePage homePage;

    @BeforeEach
    void beforeEach() {

        homePage = new HomePage(page);
        page.navigate(Properties.getProperty("app.url"));
        homePage.getTopNavigationSection().setPageLanguageToEn();
    }

    @DisplayName("Search for products")
    @ParameterizedTest(name = "Search for {0} should return {1} products")
    @MethodSource("searchData")
    void should_return_products_by_product_name(String productName, int productCounter) {
        SearchResultPage searchResultPage = homePage.getTopMenuSearchSection().searchForProduct(productName);
        assertThat(searchResultPage.getSearchResultSection().getProducts().size()).isEqualTo(productCounter);
    }

    private static Stream<Arguments> searchData() {
        return Stream.of(
                Arguments.of("t-shirt", 1),
                Arguments.of("mug", 5),
                Arguments.of("frame", 4),
                Arguments.of("graphics", 3),
                Arguments.of("notebook", 3),
                Arguments.of("sweater", 1),
                Arguments.of("cushion", 3)
        );
    }
}
