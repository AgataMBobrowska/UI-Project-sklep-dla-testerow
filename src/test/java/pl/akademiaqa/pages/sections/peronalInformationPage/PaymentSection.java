package pl.akademiaqa.pages.sections.peronalInformationPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pl.akademiaqa.pages.BasePage;
import pl.akademiaqa.pages.OrderConfirmationPage;

public class PaymentSection extends BasePage {

    private final String paymentSection = "#checkout-payment-step ";

    private final Locator payByCashRadioButton;

    private final Locator termsOfServiceCheckbox;

    private final Locator placeOrderButton;

    public PaymentSection(Page page) {
        super(page);
        this.payByCashRadioButton = page.locator(paymentSection + "#payment-option-2");
        this.termsOfServiceCheckbox = page.locator(paymentSection + "input[name='conditions_to_approve[terms-and-conditions]']");
        this.placeOrderButton = page.locator(paymentSection + "#payment-confirmation button");
    }
    public OrderConfirmationPage placeOrder() {
        payByCashRadioButton.click();
        termsOfServiceCheckbox.check();
        placeOrderButton.click();

        return new OrderConfirmationPage(page);
    }
}
