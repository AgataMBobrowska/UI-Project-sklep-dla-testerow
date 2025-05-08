package pl.akademiaqa.apitesting.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CreateUserCompanyPayload {

    private String name;
    private String catchPhrase;
    private String bs;

    public static CreateUserCompanyPayload createDefaultUserCompanyPayload() {
        return CreateUserCompanyPayload.builder()
                .name("Company A")
                .catchPhrase("Test test")
                .bs("Test")
                .build();
    }
}
