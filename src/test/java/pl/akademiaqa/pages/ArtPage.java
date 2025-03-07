package pl.akademiaqa.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.akademiaqa.pages.sections.products.FilterByComposition;
import pl.akademiaqa.pages.sections.products.FilterBySection;
import pl.akademiaqa.pages.sections.products.ProductsSection;
import pl.akademiaqa.utils.PageUtils;

@Getter
public class ArtPage extends BasePage {

    private final ProductsSection productsSection;

    private final FilterBySection filterBySection;

    private final FilterByComposition filterByComposition;

    public ArtPage(Page page) {
        super(page);
        PageUtils.waitForThePageToLoad(page);
        this.productsSection = new ProductsSection(page);
        this.filterBySection = new FilterBySection(page);
        this.filterByComposition = new FilterByComposition(page);
    }
}
