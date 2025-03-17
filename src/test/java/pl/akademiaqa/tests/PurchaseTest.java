package pl.akademiaqa.tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.pages.*;
import pl.akademiaqa.pages.modals.AddToCartConfirmationModalPage;
import pl.akademiaqa.utils.Properties;

class

PurchaseTest extends BaseTest {

    private HomePage homePage;

    private final String productName = "Customizable Mug";

    @BeforeEach
    void beforeEach() {
        homePage = new HomePage(page);
        page.navigate(Properties.getProperty("app.url"));
        homePage.getTopNavigationSection().setPageLanguageToEn();
    }

    @Test
    void should_purchase_product_test_v2() {
        AddToCartConfirmationModalPage confirmationModal =
                homePage
                        .searchForProduct(productName)
                        .viewProductDetails(productName)
                        .setCustomMessage("Hello")
                        .addProductToCart();

        Assertions.assertThat(confirmationModal.getConfirmationLabelText()).contains(("Product successfully added to your shopping cart"));

        OrderConfirmationPage confirmationPage = confirmationModal
                .clickProceedToCheckoutButtonOnModal()
                .proceedToCheckoutOnShoppingCartPage()
                .enterOrderDetails();
        Assertions.assertThat(confirmationPage.getConfirmationDetailsSection()
                .getConfirmationTitle()).containsIgnoringCase("YOUR ORDER IS CONFIRMED");
    }
}