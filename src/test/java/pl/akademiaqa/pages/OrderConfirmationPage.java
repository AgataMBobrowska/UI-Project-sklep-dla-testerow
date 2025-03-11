package pl.akademiaqa.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.akademiaqa.pages.sections.orderConfirmationPage.OrderConfirmationDetailsSection;

@Getter
public class OrderConfirmationPage extends BasePage {

    private OrderConfirmationDetailsSection orderConfirmationDetailsSection;

    public OrderConfirmationPage(Page page) {
        super(page);
        this.orderConfirmationDetailsSection = new OrderConfirmationDetailsSection(page);
    }
}
