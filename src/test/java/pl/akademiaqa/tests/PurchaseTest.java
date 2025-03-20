package pl.akademiaqa.tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.dto.AddressDetailsDTO;
import pl.akademiaqa.fasady.AddProductToCartFacade;
import pl.akademiaqa.fasady.OrderProductFacade;
import pl.akademiaqa.pages.*;
import pl.akademiaqa.pages.modals.AddToCartConfirmationModalPage;
import pl.akademiaqa.utils.Properties;

class

PurchaseTest extends BaseTest {

    private HomePage homePage;

    private AddProductToCartFacade addProductToCartFacade;

    private OrderProductFacade orderProductFacade;

    private final String productName = "Customizable Mug";

    @BeforeEach
    void beforeEach() {
        homePage = new HomePage(page);
        page.navigate(Properties.getProperty("app.url"));
        homePage.getTopNavigationSection().setPageLanguageToEn();
        addProductToCartFacade = new AddProductToCartFacade(homePage);
        orderProductFacade = new OrderProductFacade();
    }

    @Test
    void should_purchase_product_test_v2() {
        AddToCartConfirmationModalPage confirmationModal = addProductToCartFacade.addCustomizedProductToCart(productName);
        Assertions.assertThat(confirmationModal.getConfirmationLabelText()).contains(("Product successfully added to your shopping cart"));

        AddressDetailsDTO addressDetails = AddressDetailsDTO.getDefaultAddressDTO();
        OrderConfirmationPage confirmationPage = orderProductFacade.orderProduct(confirmationModal, addressDetails);
        Assertions.assertThat(confirmationPage.getConfirmationDetailsSection()
                .getConfirmationTitle()).containsIgnoringCase("YOUR ORDER IS CONFIRMED");
    }
}
