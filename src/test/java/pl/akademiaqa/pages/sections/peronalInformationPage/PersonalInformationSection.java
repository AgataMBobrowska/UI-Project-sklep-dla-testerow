package pl.akademiaqa.pages.sections.peronalInformationPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pl.akademiaqa.pages.BasePage;
import pl.akademiaqa.utils.EmailUtils;

public class PersonalInformationSection extends BasePage {

    private final String personalInformationSection = "#checkout-personal-information-step ";

    private final String customerForm = personalInformationSection + "#customer-form ";

    private final Locator socialTitleMrRadioButton;

    private final Locator socialTitleMrsRadioButton;

    private final Locator firstNameInput;

    private final Locator lastNameInput;

    private final Locator emailInput;

    private final Locator passwordInput;

    private final Locator dateOfBirthDaySelect;

    private final Locator termsOfServiceCheckbox;

    private final Locator dataPrivacyCheckbox;

    private final Locator continueButton;

    public PersonalInformationSection(Page page) {
        super(page);
        this.socialTitleMrRadioButton = page.locator(customerForm + "#field-id_gender-1");
        this.socialTitleMrsRadioButton = page.locator(customerForm + "#field-id_gender-2");
        this.firstNameInput = page.locator(customerForm + "#field-firstname");
        this.lastNameInput = page.locator(customerForm + "#field-lastname");
        this.emailInput = page.locator(customerForm + "#field-email");
        this.passwordInput = page.locator(customerForm + "#field-password");
        this.dateOfBirthDaySelect = page.locator(customerForm + "#field-birthday");
        this.termsOfServiceCheckbox = page.locator(customerForm + "input[name='psgdpr']");
        this.dataPrivacyCheckbox = page.locator(customerForm + "input[name='customer_privacy']");
        this.continueButton = page.locator(customerForm + "button[name='continue']");
    }

    public AddressSection enterPersonalInfo() {
        selectSocialTitleMrs()
                .fillFirstName("Maria")
                .fillLastName("Kowalska")
                .fillEmail(EmailUtils.generateRandomEmail())
                .selectDateOfBirthDay("07/05/1990")
                .checkDataPrivacyCheckbox()
                .checkTermsOfServiceCheckbox()
                .clickContinueButton();

        return new AddressSection(page);
    }

    private PersonalInformationSection selectSocialTitleMr() {
        socialTitleMrRadioButton.check();
        return this;
    }
    private PersonalInformationSection selectSocialTitleMrs() {
        socialTitleMrsRadioButton.check();
        return this;
    }

    private PersonalInformationSection fillFirstName(String firstName) {
        firstNameInput.fill(firstName);
        return this;
    }

    private PersonalInformationSection fillLastName(String lastName) {
        lastNameInput.fill(lastName);
        return this;
    }

    private PersonalInformationSection fillEmail(String email) {
        emailInput.fill(email);
        return this;
    }

    private PersonalInformationSection fillPassword(String password) {
        passwordInput.fill(password);
        return this;
    }

    private PersonalInformationSection selectDateOfBirthDay(String dateOfBirthDay) {
        dateOfBirthDaySelect.fill(dateOfBirthDay);
        return this;
    }

    private PersonalInformationSection checkTermsOfServiceCheckbox() {
        termsOfServiceCheckbox.check();
        return this;
    }

    private PersonalInformationSection checkDataPrivacyCheckbox() {
        dataPrivacyCheckbox.check();
        return this;
    }

    private void clickContinueButton() {
        continueButton.click();
    }
}
