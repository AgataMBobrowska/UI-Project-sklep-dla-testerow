package pl.akademiaqa.pages.sections.products;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class FilterBySection {

    private Page page;

    private Locator leftSlider;

    public FilterBySection(Page page) {
        this.page = page;
        this.leftSlider = page.locator(".ui-slider-handle").first();
    }

    public void showLeftSlider() {
        System.out.println(leftSlider.boundingBox().x);
        System.out.println(leftSlider.boundingBox().y);
        System.out.println(leftSlider.boundingBox().height);
        System.out.println(leftSlider.boundingBox().width);

    }

    public void filterProductsByPriceWithCursor() {
        double x = leftSlider.boundingBox().x;
        double y = leftSlider.boundingBox().y;

        double middleX = x + leftSlider.boundingBox().width / 2;
        double middleY = y + leftSlider.boundingBox().height / 2;

        page.mouse().move(middleX, middleY);
        page.mouse().down();
        page.mouse().move(x + 7.00, y);
        page.mouse().up();
    }
}
