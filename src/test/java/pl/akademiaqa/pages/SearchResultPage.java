package pl.akademiaqa.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.akademiaqa.pages.sections.searchResultsPage.SearchResultSection;

import static pl.akademiaqa.utils.PageUtils.waitForThePageToLoad;

public class SearchResultPage {

    @Getter
    private final SearchResultSection searchResultSection;

    public SearchResultPage(Page page) {
        waitForThePageToLoad(page);
        this.searchResultSection = new SearchResultSection(page);
    }
}
