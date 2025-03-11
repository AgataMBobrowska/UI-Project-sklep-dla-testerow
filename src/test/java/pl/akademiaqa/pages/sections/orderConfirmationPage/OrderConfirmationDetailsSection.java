package pl.akademiaqa.pages.sections.orderConfirmationPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pl.akademiaqa.pages.BasePage;

public class OrderConfirmationDetailsSection extends BasePage {

    private String orderConfirmationDetailsSection = "#content-hook_order_confirmation ";

    private Locator title;

    public OrderConfirmationDetailsSection(Page page) {
        super(page);
        this.title = page.locator(orderConfirmationDetailsSection + ".card-title");
    }

    public String getConfirmationTitle() {
        return title.innerText();
    }
}
