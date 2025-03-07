package pl.akademiaqa.pages.sections.shoppingCartPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class SummarySection {

    Page page;

    private Locator proceedToCheckoutButton;

    public SummarySection(Page page) {
        this.proceedToCheckoutButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Proceed to checkout"));
        this.page = page;
    }

    public void proceedToCheckoutButton() {
        proceedToCheckoutButton.click();
    }
}
