package pl.akademiaqa.pages.sections.products;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class FilterByComposition {

    private Page page;

    private Locator mattPaper;

    private Locator mattPaperProductsCount;

    public FilterByComposition(Page page) {
        this.page = page;
        this.mattPaper = page.locator("//a[contains(text(), 'Matt paper')]");
        this.mattPaperProductsCount = page.locator(".product-miniature");
    }

    public void clickMattPaper() {
        mattPaper.click();
    }

    public int countMattPaperProducts() {
        mattPaperProductsCount.count();
        return mattPaperProductsCount.count();
    }
}
