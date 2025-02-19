package pl.akademiaqa.pages.sections.products;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.List;
import java.util.stream.Collectors;

public class ProductsSection {

    private Page page;

    private List<Locator> products;

    public ProductsSection(Page page) {
        this.page = page;
        this.products = page.locator(".js-product").all();
    }

    private List<String> getProductPricesText() {
        return page.locator(".js-product .price").allInnerTexts();
    }

    public List<Double> getProductsPrices()  {
        return getProductPricesText()
                .stream()
                .map(p -> p.replaceAll("zł", ""))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
    }
}
