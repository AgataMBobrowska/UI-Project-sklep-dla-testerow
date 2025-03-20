package pl.akademiaqa.pages.sections.peronalInformationPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pl.akademiaqa.dto.AddressDetailsDTO;
import pl.akademiaqa.pages.BasePage;

import java.util.List;

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

    public ShippingSection fillAddress(AddressDetailsDTO addressDetails) {
        addressInput.fill(addressDetails.getAddressInput());
        zipCodeInput.fill(addressDetails.getZipCodeInput());
        cityInput.fill(addressDetails.getCityInput());
        continueButton.click();

        return new ShippingSection(page);
    }
}
