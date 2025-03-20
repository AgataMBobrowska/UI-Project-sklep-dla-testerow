package pl.akademiaqa.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AddressDetailsDTO {

    private String addressInput;

    private String zipCodeInput;

    private String cityInput;

    private String continueButton;


    public static AddressDetailsDTO getDefaultAddressDTO() {
        return AddressDetailsDTO.builder()
                .addressInput("Ulica Długa")
                .zipCodeInput("12-345")
                .cityInput("Warszawa")
                .continueButton("Continue")
                .build();
    }
}
