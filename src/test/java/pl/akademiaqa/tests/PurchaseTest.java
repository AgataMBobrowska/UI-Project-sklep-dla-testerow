package pl.akademiaqa.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.pages.*;
import pl.akademiaqa.pages.modals.AddToCartConfirmationModalPage;
import pl.akademiaqa.pages.sections.peronalInformationPage.AddressSection;
import pl.akademiaqa.utils.Properties;

class PurchaseTest extends BaseTest {

    private HomePage homePage;

    @BeforeEach
    void beforeEach() {
        homePage = new HomePage(page);
        page.navigate(Properties.getProperty("app.url"));
        homePage.getTopNavigationSection().setPageLanguageToEn();
    }

    @Test
    void should_purchase_product_test() {
        SearchResultPage searchResultPage = homePage.getTopMenuSearchSection().searchForProducts("Customizable Mug");
        ProductDetailsPage productDetailsPage = searchResultPage.getSearchResultSection().viewProductDetails("Customizable Mug");
        productDetailsPage.getProductCustomizationSection().setCustomMessage("Hello");
        AddToCartConfirmationModalPage confirmationModal = productDetailsPage.getAddToCartSection().addToCart();
        Assertions.assertTrue(confirmationModal.getConfirmationLabelText().contains("Product successfully added to your shopping cart"));
        ShoppingCartPage shoppingCartPage = confirmationModal.clickProceedToCheckoutButton();
        PersonalInformationPage personalInformationPage = shoppingCartPage.getSummarySection().proceedToCheckoutButton();
        AddressSection addressSection = personalInformationPage.getPersonalInformation().enterPersonalInfo();
        addressSection.fillAddress();

        page.waitForTimeout(4000);
    }
}

