package pl.akademiaqa.tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.pages.*;
import pl.akademiaqa.pages.modals.AddToCartConfirmationModalPage;
import pl.akademiaqa.pages.sections.peronalInformationPage.AddressSection;
import pl.akademiaqa.pages.sections.peronalInformationPage.PaymentSection;
import pl.akademiaqa.pages.sections.peronalInformationPage.ShippingSection;
import pl.akademiaqa.utils.Properties;

class

PurchaseTest extends BaseTest {

    private HomePage homePage;

    private final String product = "Customizable Mug";

    @BeforeEach
    void beforeEach() {
        homePage = new HomePage(page);
        page.navigate(Properties.getProperty("app.url"));
        homePage.getTopNavigationSection().setPageLanguageToEn();
    }

    @Test
    void should_purchase_product_test() {
        SearchResultPage searchResultPage = homePage.getTopMenuSearchSection().searchForProducts(product);
        ProductDetailsPage productDetailsPage = searchResultPage.getSearchResultSection().viewProductDetails(product);
        productDetailsPage.getProductCustomizationSection().setCustomMessage("Hello");
        AddToCartConfirmationModalPage confirmationModal = productDetailsPage.getAddToCartSection().addToCart();
        Assertions.assertThat(confirmationModal.getConfirmationLabelText()).contains(("Product successfully added to your shopping cart"));
        ShoppingCartPage shoppingCartPage = confirmationModal.clickProceedToCheckoutButton();
        PersonalInformationPage personalInformationPage = shoppingCartPage.getSummarySection().proceedToCheckoutButton();
        AddressSection addressSection = personalInformationPage.getPersonalInformation().enterPersonalInfo();
        ShippingSection shippingSection = addressSection.fillAddress();
        PaymentSection paymentSection = shippingSection.selectMyCarrierDelivery();
        OrderConfirmationPage confirmationPage = paymentSection.placeOrder();
        Assertions.assertThat(confirmationPage.getConfirmationDetailsSection()
                .getConfirmationTitle()).containsIgnoringCase("YOUR ORDER IS CONFIRMED");
    }
}
