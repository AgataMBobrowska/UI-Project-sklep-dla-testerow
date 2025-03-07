package pl.akademiaqa.pages.sections.products;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pl.akademiaqa.pages.BasePage;

public class FilterByComposition extends BasePage {


    private Locator mattPaper;

    private Locator mattPaperProductsCount;

    public FilterByComposition(Page page) {
        super(page);
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
