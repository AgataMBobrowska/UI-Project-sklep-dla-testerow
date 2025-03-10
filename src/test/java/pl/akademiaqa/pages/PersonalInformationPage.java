package pl.akademiaqa.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.akademiaqa.pages.sections.peronalInformationPage.PersonalInformationSection;
import pl.akademiaqa.utils.PageUtils;

@Getter
public class PersonalInformationPage extends BasePage {

    private PersonalInformationSection personalInformation;

    public PersonalInformationPage(Page page) {
        super(page);
        PageUtils.waitForThePageToLoad(page);
        this.personalInformation= new PersonalInformationSection(page);
    }
}
