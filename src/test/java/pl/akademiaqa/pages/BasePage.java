package pl.akademiaqa.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.akademiaqa.pages.common.TopMenuSearchSection;
import pl.akademiaqa.pages.common.TopNavigationSection;

public class BasePage {

    protected Page page;

    @Getter
    protected TopMenuSearchSection topMenuSearchSection;

    @Getter
    protected TopNavigationSection topNavigationSection;

    public BasePage(Page page) {
        this.page = page;
        this.topMenuSearchSection = new TopMenuSearchSection(page);
        this.topNavigationSection = new TopNavigationSection(page);
    }

    public SearchResultPage searchForProducts (String productName) {
        return topMenuSearchSection.searchForProduct(productName);
    }

    public void setPageLanguageToEn() {
        topNavigationSection.setPageLanguageToEn();
    }

    public ArtPage clickArtLink() {
        return getTopMenuSearchSection().clickArtLink();
    }
}