package pl.akademiaqa.fasady;

import pl.akademiaqa.pages.OrderConfirmationPage;
import pl.akademiaqa.pages.modals.AddToCartConfirmationModalPage;

public class OrderProductFacade {

    public OrderConfirmationPage orderProduct(AddToCartConfirmationModalPage confirmationPage) {
        return confirmationPage
                .clickProceedToCheckoutButtonOnModal()
                .proceedToCheckoutOnShoppingCartPage()
                .enterOrderDetails();
    }
}
