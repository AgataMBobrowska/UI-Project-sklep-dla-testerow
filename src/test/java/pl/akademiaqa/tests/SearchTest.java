package pl.akademiaqa.tests;

import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.pages.HomePage;
import pl.akademiaqa.pages.SearchResultPage;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SearchTest extends BaseTest {

    private HomePage homePage;

    @BeforeEach
    void beforeEach() {

        homePage = new HomePage(page);
    }

    @Test
    void should_return_products_by_search_name_mug() {

        page.navigate("https://skleptestera.pl/index.php");
        SearchResultPage searchResultPage = homePage.getTopMenuSearchSection().searchForProducts("mug");
        assertThat(searchResultPage.getSearchResultSection().getProducts().size()).isEqualTo(5);
    }
}
