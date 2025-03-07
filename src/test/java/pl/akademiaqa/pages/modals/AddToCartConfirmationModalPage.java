package pl.akademiaqa.pages.modals;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import pl.akademiaqa.pages.ShoppingCartPage;

import static pl.akademiaqa.utils.PageUtils.waitForThePageToLoad;

public class AddToCartConfirmationModalPage {

    private Page page;

    private Locator confirmationLabel;

    private Locator proceedToCheckoutButton;

    public AddToCartConfirmationModalPage(Page page) {
        this.page = page;
        waitForThePageToLoad(page);
        this.confirmationLabel = page.locator("#myModalLabel");
        this.proceedToCheckoutButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Proceed to checkout"));
    }

    public String getConfirmationLabelText() {
        return confirmationLabel.innerText();
    }

    public ShoppingCartPage clickProceedToCheckoutButton() {
        proceedToCheckoutButton.click();
        return new ShoppingCartPage(page);
    }
}
