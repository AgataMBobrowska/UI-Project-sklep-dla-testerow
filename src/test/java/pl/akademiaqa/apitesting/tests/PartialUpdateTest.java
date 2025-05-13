package pl.akademiaqa.apitesting.tests;

import com.google.gson.JsonObject;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.apitesting.facades.CreateUserApiFacade;
import pl.akademiaqa.apitesting.payload.CreateUserPayload;
import pl.akademiaqa.apitesting.response.CreateUpdateUserResponse;
import pl.akademiaqa.pages.common.BaseApiTest;

import static pl.akademiaqa.apitesting.assertions.StatusCodeAssertions.assert200;
import static pl.akademiaqa.apitesting.transformers.UserTransformers.createUpdateUserResponseDTO;

class PartialUpdateTest extends BaseApiTest {

    @Test
    void should_update_email_test(){

        CreateUserPayload user = CreateUserPayload.createDefaultPayload();
        CreateUpdateUserResponse createUserDTO = CreateUserApiFacade.createUser(context, user);

        log.info("Step 2: Update the user");
        JsonObject userUpdate = new JsonObject();
        userUpdate.addProperty("email", "agata@mail.com");

        APIResponse updateResponse = context.patch("users/" + createUserDTO.getId(), RequestOptions.create().setData(userUpdate));
        assert200(updateResponse);

        CreateUpdateUserResponse updateUserDTO = createUpdateUserResponseDTO(updateResponse);
        Assertions.assertThat(updateUserDTO.getEmail()).isEqualTo("agata@mail.com");
    }
}
