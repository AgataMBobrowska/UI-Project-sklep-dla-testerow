package pl.akademiaqa.dto;

import lombok.Builder;
import lombok.Data;
import com.microsoft.playwright.Locator;

@Data
@Builder
public class ProductDTO {

    private Locator thumbnail;

    private String name;

    private double price;
}
