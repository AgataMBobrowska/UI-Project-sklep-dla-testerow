package pl.akademiaqa.pages.sections;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;

public class TopMenuSearchSection {

    private Page page;

    @Getter
    private Locator searchInput;

    public TopMenuSearchSection(Page page) {
        this.page = page;
        this.searchInput = page.locator("input[name=s]");

    }

    public void searchForProducts(String productName) {
        searchInput.fill(productName);
        page.keyboard().press("Enter");
    }
}
