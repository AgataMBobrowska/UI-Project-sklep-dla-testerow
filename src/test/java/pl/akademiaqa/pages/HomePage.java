package pl.akademiaqa.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.akademiaqa.pages.sections.TopMenuSearchSection;

public class HomePage {

    private Page page;

    @Getter
    private TopMenuSearchSection topMenuSearchSection;

    public HomePage(Page page) {
        this.page = page;
        this.topMenuSearchSection = new TopMenuSearchSection(page);
    }
}
