package pl.akademiaqa.pages.sections.productDetailsPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pl.akademiaqa.pages.BasePage;

public class ProductCustomizationSection extends BasePage {


    private Locator customMessageInput;

    private Locator saveCustomizationButton;

    private Locator customizationLabel;

    public ProductCustomizationSection(Page page) {
        super(page);
        this.customMessageInput = page.locator("#field-textField1");
        this.saveCustomizationButton = page.locator("button[name=submitCustomizedData]");
        this.customizationLabel = page.locator(".customization-message");
    }

    public void setCustomMessage(String customMessage) {
        customMessageInput.fill(customMessage);
        saveCustomizationButton.click();

    }
}
