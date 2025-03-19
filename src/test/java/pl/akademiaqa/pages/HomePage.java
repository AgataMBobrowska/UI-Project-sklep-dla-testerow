package pl.akademiaqa.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;

@Getter
public class HomePage extends BasePage {

    public HomePage(Page page) {
        super(page);
    }
}