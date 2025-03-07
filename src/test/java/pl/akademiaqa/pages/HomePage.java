package pl.akademiaqa.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.akademiaqa.pages.sections.TopMenuSearchSection;
import pl.akademiaqa.pages.sections.TopNavigationSection;

@Getter
public class HomePage extends BasePage {

    private final TopMenuSearchSection topMenuSearchSection;

    private final TopNavigationSection topNavigationSection;

    public HomePage(Page page) {
        super(page);
        this.topMenuSearchSection = new TopMenuSearchSection(page);
        this.topNavigationSection = new TopNavigationSection(page);
    }
}
