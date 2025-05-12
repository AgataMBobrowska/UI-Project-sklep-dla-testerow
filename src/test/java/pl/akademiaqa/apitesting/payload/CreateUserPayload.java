package pl.akademiaqa.apitesting.payload;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CreateUserPayload {

    private String name;

    @SerializedName("username")
    private String userName;

    private String email;

    private CreateUserAddressPayload address;

    private String phone;

    private String website;

    private CreateUserCompanyPayload company;

    public static CreateUserPayload createDefaultPayload() {
        return CreateUserPayload.builder()
                .name("Json Dto")
                .userName("json.dto")
                .email("jsondto@email.com")
                .address(CreateUserAddressPayload.createDefaultUserAddressPayload())
                .phone("123-456-789")
                .website("jsondto.com")
                .company(CreateUserCompanyPayload.createDefaultUserCompanyPayload())
                .build();
    }
}
