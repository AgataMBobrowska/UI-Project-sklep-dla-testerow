package pl.akademiaqa.pages.sections.searchResultsPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.akademiaqa.dto.ProductDTO;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class SearchResultSection {

    private final List<Locator> products;

    public SearchResultSection(Page page) {
        products = page.locator(".js-product").all();
    }

    public void viewProductDetails(String productName) {
        Locator product = products.stream()
                .filter(p -> p.locator(".product-title").innerText().equals(productName))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Product not found: " + productName));

        product.click();
    }

    public List<ProductDTO> productsToDTO() {
        return products.stream()
                .map(p -> ProductDTO.builder()
                        .thumbnail(p.locator(".thumbnail-top"))
                        .name(p.locator(".product-title").innerText())
                        .price(Double.parseDouble(p.locator(".price").innerText().replace("zł", "").trim()))
                        .build())
                .collect(Collectors.toList());
    }
}