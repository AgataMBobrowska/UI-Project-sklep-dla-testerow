package pl.akademiaqa.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.akademiaqa.pages.sections.searchResultsPage.SearchResultSection;

@Getter
public class SearchResultPage {

    private final SearchResultSection searchResultSection;

    public SearchResultPage(Page page) {

        this.searchResultSection = new SearchResultSection(page);
    }
}
