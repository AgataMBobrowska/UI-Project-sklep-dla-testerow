package pl.akademiaqa.pages.sections;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.akademiaqa.pages.SearchResultPage;

public class TopMenuSearchSection {

    @Getter

    private Page page;

    private final Locator searchInput;

    public TopMenuSearchSection(Page page) {
        this.page = page;
        this.searchInput = page.locator("input[name=s]");

    }

    public SearchResultPage searchForProducts(String productName) {
        searchInput.fill(productName);
        page.keyboard().press("Enter");

        return new SearchResultPage(page);
    }
}
