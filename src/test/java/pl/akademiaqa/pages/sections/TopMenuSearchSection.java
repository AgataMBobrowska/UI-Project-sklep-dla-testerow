package pl.akademiaqa.pages.sections;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import lombok.Getter;
import pl.akademiaqa.pages.ArtPage;
import pl.akademiaqa.pages.BasePage;
import pl.akademiaqa.pages.SearchResultPage;

@Getter
public class TopMenuSearchSection extends BasePage {

    private final Locator searchInput;

    private Locator artLink;

    public TopMenuSearchSection(Page page) {
        super(page);
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
