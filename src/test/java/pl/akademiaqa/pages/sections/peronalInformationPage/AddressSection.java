package pl.akademiaqa.pages.sections.peronalInformationPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pl.akademiaqa.pages.BasePage;

public class AddressSection extends BasePage {

    private final String addressSection = "#checkout-addresses-step ";

    private final Locator addressInput;

    private final Locator zipCodeInput;

    private final Locator cityInput;

    private final Locator continueButton;

    public AddressSection(Page page) {
        super(page);
        this.addressInput = page.locator(addressSection + "#field-address1");
        this.zipCodeInput = page.locator(addressSection + "#field-postcode");
        this.cityInput = page.locator(addressSection + "#field-city");
        this.continueButton = page.locator(addressSection + "button[name='confirm-addresses']");
    }

    public ShippingSection fillAddress() {
        addressInput.fill("Ulica Długa 123");
        zipCodeInput.fill("12-345");
        cityInput.fill("Piotrowo");
        continueButton.click();

        return new ShippingSection(page);
    }
}
