package pl.akademiaqa.apitesting.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CreateUserAddressPayload {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private CreateUserAddressGeoPayload geo;

    public static CreateUserAddressPayload createDefaultUserAddressPayload() {
        return CreateUserAddressPayload.builder()
                .street("Kwiatowa")
                .suite("1")
                .city("Warszawa")
                .zipcode("00-001")
                .geo(CreateUserAddressGeoPayload.getDefaultUserAddressGeoPayload())
                .build();
    }
}
