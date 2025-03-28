
package pl.akademiaqa.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.akademiaqa.pages.sections.searchResultsPage.SearchResultSection;

import static pl.akademiaqa.utils.PageUtils.waitForThePageToLoad;

public class SearchResultPage extends BasePage {

    @Getter
    private SearchResultSection searchResultSection;

    public SearchResultPage(Page page) {
        super(page);
        waitForThePageToLoad(page);
        this.searchResultSection = new SearchResultSection(page);
    }

    public ProductDetailsPage viewProductDetails(String productName) {
        return getSearchResultSection().viewProductDetails(productName);
    }
}
