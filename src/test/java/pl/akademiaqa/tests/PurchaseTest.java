package pl.akademiaqa.tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.fasady.AddProductToCartFacade;
import pl.akademiaqa.fasady.OrderProductFacade;
import pl.akademiaqa.pages.*;
import pl.akademiaqa.pages.modals.AddToCartConfirmationModalPage;

class

PurchaseTest extends BaseTest {

    private HomePage homePage;

    private AddProductToCartFacade addProductToCartFacade;

    private OrderProductFacade orderProductFacade;

    private final String productName = "Customizable Mug";

    @BeforeEach
    void beforeEach() {
        homePage = new HomePage(page);
        page.navigate("https://skleptestera.pl/index.php");
        homePage.getTopNavigationSection().setPageLanguageToEn();
        addProductToCartFacade = new AddProductToCartFacade(homePage);
        orderProductFacade = new OrderProductFacade();
    }

    @Test
    void should_purchase_product_test() {
        AddToCartConfirmationModalPage confirmationModal = addProductToCartFacade.addCustomizedProductToCart(productName);
        Assertions.assertThat(confirmationModal.getConfirmationLabelText()).contains(("Product successfully added to your shopping cart"));

        OrderConfirmationPage confirmationPage = orderProductFacade.orderProduct(confirmationModal);
        Assertions.assertThat(confirmationPage.getConfirmationDetailsSection()
                .getConfirmationTitle()).containsIgnoringCase("YOUR ORDER IS CONFIRMED");
    }
}
