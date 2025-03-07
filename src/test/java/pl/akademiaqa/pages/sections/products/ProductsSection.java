package pl.akademiaqa.pages.sections.products;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pl.akademiaqa.pages.BasePage;
import pl.akademiaqa.utils.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

import static pl.akademiaqa.utils.StringUtils.toUTF8;

public class ProductsSection extends BasePage {

    private List<Locator> products;

    public ProductsSection(Page page) {
        super(page);
        this.products = page.locator(".js-product").all();
    }

    private List<String> getProductPricesText() {
        return page.locator(".js-product .price").allInnerTexts();
    }

    public List<Double> getProductsPrices()  {
        return getProductPricesText()
                .stream()
                .map(p -> p.replaceAll(toUTF8("zł"), ""))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
    }
}
