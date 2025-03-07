package pl.akademiaqa.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.akademiaqa.pages.sections.productDetailsPage.AddToCartSection;
import pl.akademiaqa.pages.sections.productDetailsPage.ProductCustomizationSection;

import static pl.akademiaqa.utils.PageUtils.waitForThePageToLoad;

@Getter
public class ProductDetailsPage extends BasePage {

    private ProductCustomizationSection productCustomizationSection;

    private AddToCartSection addToCartSection;

    public ProductDetailsPage(Page page) {
        super(page);
        waitForThePageToLoad(page);
        this.productCustomizationSection = new ProductCustomizationSection(page);
        this.addToCartSection = new AddToCartSection(page);
    }
}
