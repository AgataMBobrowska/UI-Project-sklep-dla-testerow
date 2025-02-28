package pl.akademiaqa.pages.sections.searchResultsPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.akademiaqa.dto.ProductDTO;

import java.util.List;
import java.util.stream.Collectors;


public class SearchResultSection {
@Getter
    private final List<Locator> products;

    public SearchResultSection(Page page) {

        products = page.locator(".js-product").all();
    }

    public void viewProductDetails(String productName) {
        ProductDTO productDTO = productsToDTO().stream()
                .filter(p -> p.getName().equals(productName))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Product not found: " + productName));
        productDTO.getThumbnail().click();

    }

    public List <ProductDTO> productsToDTO() {
        return products.stream()
                .map(p -> {
                    return ProductDTO.builder()
                            .thumbnail(p.locator(".thumbnail-top"))
                            .name(p.locator(".product-title").innerText())
                            .price(Double.parseDouble(p.locator(".price").innerText()))
                            .build();
                })
                .collect(Collectors.toList());
    }
}
