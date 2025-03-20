package pl.akademiaqa.fasady;

import pl.akademiaqa.dto.AddressDetailsDTO;
import pl.akademiaqa.pages.OrderConfirmationPage;
import pl.akademiaqa.pages.modals.AddToCartConfirmationModalPage;

public class OrderProductFacade {

    public OrderConfirmationPage orderProduct(AddToCartConfirmationModalPage confirmationPage, AddressDetailsDTO addressDetails) {
        return confirmationPage
                .clickProceedToCheckoutButtonOnModal()
                .proceedToCheckoutOnShoppingCartPage()
                .enterOrderDetails(addressDetails);
    }
}
