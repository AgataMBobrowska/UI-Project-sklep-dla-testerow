package pl.akademiaqa.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.akademiaqa.pages.sections.TopMenuSearchSection;
import pl.akademiaqa.pages.sections.TopNavigationSection;

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

    public SearchResultPage searchForProduct (String productName) {
        return topMenuSearchSection.searchForProducts(productName);
    }

    public void setPageLanguageToEn() {
        topNavigationSection.setPageLanguageToEn();
    }

    public ArtPage clickArtLink() {
        return getTopMenuSearchSection().clickArtLink();
    }
}