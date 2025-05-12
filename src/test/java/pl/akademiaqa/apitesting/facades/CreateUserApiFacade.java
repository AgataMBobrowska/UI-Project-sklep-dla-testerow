package pl.akademiaqa.apitesting.facades;

import com.google.gson.Gson;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;
import org.assertj.core.api.Assertions;
import pl.akademiaqa.apitesting.assertions.StatusCodeAssertions;
import pl.akademiaqa.apitesting.payload.CreateUserPayload;
import pl.akademiaqa.apitesting.response.CreateUpdateUserResponse;

public class CreateUserApiFacade {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(CreateUserApiFacade.class);

    public static CreateUpdateUserResponse createUser(APIRequestContext context, CreateUserPayload userPayload) {

        log.info("Step 1: Create a new user");
        APIResponse createUserResponse = context.post("users/", RequestOptions.create().setData(userPayload));
        StatusCodeAssertions.assert201(createUserResponse);
        CreateUpdateUserResponse createUserResponseDTO = new Gson().fromJson(createUserResponse.text(), CreateUpdateUserResponse.class);
        Assertions.assertThat(createUserResponseDTO.getId()).isNotNull();
        log.info("Created user: " + createUserResponseDTO);

        return createUserResponseDTO;
    }
}
