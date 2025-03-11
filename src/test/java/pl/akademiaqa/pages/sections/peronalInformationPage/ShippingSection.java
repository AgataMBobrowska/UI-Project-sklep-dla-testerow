package pl.akademiaqa.pages.sections.peronalInformationPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pl.akademiaqa.pages.BasePage;

public class ShippingSection extends BasePage {

    private final String shippingSection = "#checkout-delivery-step ";

    private Locator myCarrirerDelivery;

    private Locator continueButton;

    public ShippingSection(Page page) {
        super(page);
        this.myCarrirerDelivery = page.locator(shippingSection + "#delivery_option_2");
        this.continueButton = page.locator(shippingSection + "button[name='confirmDeliveryOption']");
    }

    public PaymentSection selectMyCarrierDelivery() {
        myCarrirerDelivery.click();
        continueButton.click();

        return new PaymentSection(page);
    }
}
