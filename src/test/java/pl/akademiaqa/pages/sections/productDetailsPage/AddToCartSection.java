package pl.akademiaqa.pages.sections.productDetailsPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pl.akademiaqa.pages.modals.AddToCartConfirmationModalPage;

public class AddToCartSection {

    private Page page;

    private Locator addToCartButton;

    public AddToCartSection(Page page) {
        this.addToCartButton = page.locator(".add-to-cart");
        this.page = page;
    }

    public AddToCartConfirmationModalPage addToCart() {
        addToCartButton.click();
        return new AddToCartConfirmationModalPage(page);
    }
}
