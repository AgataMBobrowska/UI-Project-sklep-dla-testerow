package pl.akademiaqa.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.akademiaqa.pages.sections.TopMenuSearchSection;

@Getter
public class HomePage {

    private final TopMenuSearchSection topMenuSearchSection;

    public HomePage(Page page) {
        this.topMenuSearchSection = new TopMenuSearchSection(page);
    }
}
