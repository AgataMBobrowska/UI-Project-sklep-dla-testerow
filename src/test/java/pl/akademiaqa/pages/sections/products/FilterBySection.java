package pl.akademiaqa.pages.sections.products;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class FilterBySection {

    private Locator leftSlider;

    public FilterBySection(Page page) {
        this.leftSlider = page.locator(".ui-slider-handle").first();
    }

    public void showLeftLocator(){
        System.out.println(leftSlider.boundingBox().x);
        System.out.println(leftSlider.boundingBox().y);

        System.out.println(leftSlider.boundingBox().height);
        System.out.println(leftSlider.boundingBox().width);

    }
}
