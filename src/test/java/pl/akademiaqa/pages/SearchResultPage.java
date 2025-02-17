package pl.akademiaqa.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.akademiaqa.pages.sections.searchResultsPage.SearchResultSection;
import pl.akademiaqa.utils.PageUtils;

@Getter
public class SearchResultPage {

    private final SearchResultSection searchResultSection;

    public SearchResultPage(Page page) {
        PageUtils.waitForThePageToLoad(page);
        this.searchResultSection = new SearchResultSection(page);
    }
}
