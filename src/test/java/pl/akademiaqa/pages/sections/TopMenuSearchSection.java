package pl.akademiaqa.pages.sections;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import lombok.Getter;
import pl.akademiaqa.pages.ArtPage;
import pl.akademiaqa.pages.SearchResultPage;

public class TopMenuSearchSection {

    @Getter

    private Page page;

    private final Locator searchInput;

    private Locator artLink;

    public TopMenuSearchSection(Page page) {
        this.page = page;
        this.searchInput = page.locator("input[name=s]");
        this.artLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Art").setExact(true));
    }

    public SearchResultPage searchForProducts(String productName) {
        searchInput.fill(productName);
        page.keyboard().press("Enter");

        return new SearchResultPage(page);
    }

    public ArtPage clickArtLink() {
        artLink.click();
        return new ArtPage(page);
    }
}
