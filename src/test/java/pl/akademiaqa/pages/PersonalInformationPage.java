package pl.akademiaqa.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.akademiaqa.dto.AddressDetailsDTO;
import pl.akademiaqa.pages.sections.peronalInformationPage.AddressSection;
import pl.akademiaqa.pages.sections.peronalInformationPage.PersonalInformationSection;
import pl.akademiaqa.utils.PageUtils;

@Getter
public class PersonalInformationPage extends BasePage {

    private PersonalInformationSection personalInformation;

    private AddressSection addressSection;

    public PersonalInformationPage(Page page) {
        super(page);
        PageUtils.waitForThePageToLoad(page);
        this.personalInformation = new PersonalInformationSection(page);
        this.addressSection = new AddressSection(page);
    }

    public OrderConfirmationPage enterOrderDetails(AddressDetailsDTO addressDetails) {
        return personalInformation
                .enterPersonalInfo()
                .fillAddress(addressDetails)
                .selectMyCarrierDelivery()
                .placeOrder();
    }
}