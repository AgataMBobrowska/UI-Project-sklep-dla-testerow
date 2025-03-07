package pl.akademiaqa.pages.sections.productDetailsPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pl.akademiaqa.pages.BasePage;
import pl.akademiaqa.pages.modals.AddToCartConfirmationModalPage;

public class AddToCartSection extends BasePage {

    private Locator addToCartButton;

    public AddToCartSection(Page page) {
        super(page);
        this.addToCartButton = page.locator(".add-to-cart");
    }

    public AddToCartConfirmationModalPage addToCart() {
        addToCartButton.click();
        return new AddToCartConfirmationModalPage(page);
    }
}
