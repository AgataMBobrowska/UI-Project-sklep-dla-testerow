package pl.akademiaqa.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.akademiaqa.pages.sections.shoppingCartPage.SummarySection;

import static pl.akademiaqa.utils.PageUtils.waitForThePageToLoad;

@Getter
public class ShoppingCartPage  extends BasePage {

    private SummarySection summarySection;

    public ShoppingCartPage(Page page) {
        super(page);
        waitForThePageToLoad(page);
        this.summarySection = new SummarySection(page);
    }
}
