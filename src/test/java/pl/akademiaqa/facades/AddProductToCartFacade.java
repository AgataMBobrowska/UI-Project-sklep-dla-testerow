package pl.akademiaqa.facades;

import pl.akademiaqa.pages.HomePage;
import pl.akademiaqa.pages.modals.AddToCartConfirmationModalPage;

public class AddProductToCartFacade {

    private HomePage homePage;


    public AddProductToCartFacade(HomePage homePage) {
        this.homePage = homePage;
    }

    public AddToCartConfirmationModalPage  addCustomizedProductToCart(String productName) {
        return homePage
                .searchForProducts(productName)
                .viewProductDetails(productName)
                .setCustomMessage(productName)
                .addProductToCart();
    }

    public AddToCartConfirmationModalPage  addProductToCart(String productName) {
        return homePage
                .searchForProducts(productName)
                .viewProductDetails(productName)
                .addProductToCart();
    }
}
