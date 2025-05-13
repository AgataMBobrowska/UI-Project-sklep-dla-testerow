package pl.akademiaqa.apitesting.tests;

import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.apitesting.facades.CreateUserApiFacade;
import pl.akademiaqa.apitesting.payload.CreateUserPayload;
import pl.akademiaqa.apitesting.response.CreateUpdateUserResponse;
import pl.akademiaqa.apitesting.response.GetUserResponse;
import pl.akademiaqa.apitesting.transformers.UserTransformers;
import pl.akademiaqa.pages.common.BaseApiTest;

import static pl.akademiaqa.apitesting.assertions.StatusCodeAssertions.assert200;

class UpdateUserTest extends BaseApiTest {

    @Test
    void should_update_entire_user_test() {
        CreateUserPayload user = CreateUserPayload.createDefaultPayload();
        CreateUpdateUserResponse createUserDTO = CreateUserApiFacade.createUser(context, user);

        log.info("Step 2: Update the user");
        user.setEmail("agata@test.pl");

        APIResponse updateUserResponse = context.put("users/" + createUserDTO.getId(), RequestOptions.create().setData(user));
        assert200(updateUserResponse);

        CreateUpdateUserResponse updateUserResponseDTO = UserTransformers.createUpdateUserResponseDTO(updateUserResponse);
        Assertions.assertThat(updateUserResponseDTO.getEmail()).isEqualTo("agata@test.pl");
        log.info("Updated user: " + updateUserResponseDTO);

        log.info("Step 3: Read updated user");
        APIResponse apiResponse = context.get("users/" + createUserDTO.getId());
        assert200(apiResponse);

        GetUserResponse getUserResponseDTO = UserTransformers.readUserToResponseDTO(apiResponse);
        Assertions.assertThat(getUserResponseDTO.getEmail()).isEqualTo("agata@test.pl");
        log.info("Read user: " + updateUserResponseDTO);

    }
}
