package pl.akademiaqa.pages.sections.searchResultsPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;
import java.util.List;

@Getter
public class SearchResultSection {

    private final List<Locator> products;

    public SearchResultSection(Page page) {

        products = page.locator(".js-product").all();
    }
}
