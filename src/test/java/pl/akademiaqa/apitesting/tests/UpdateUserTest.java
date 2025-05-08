package pl.akademiaqa.apitesting.tests;

import com.google.gson.Gson;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.apitesting.payload.CreateUserPayload;
import pl.akademiaqa.apitesting.response.CreateUpdateUserResponse;
import pl.akademiaqa.apitesting.response.GetUserResponse;
import pl.akademiaqa.pages.common.BaseApiTest;

class UpdateUserTest extends BaseApiTest {

    @Test
    void should_update_entire_user_test() {
        log.info("Step 1: Create a new user");
        CreateUserPayload user = CreateUserPayload.createDefaultPayload();
        APIResponse createUserResponse = context.post("users/", RequestOptions.create().setData(user));
        Assertions.assertThat(createUserResponse.status()).isEqualTo(201);
        CreateUpdateUserResponse createUserResponseDTO = new Gson().fromJson(createUserResponse.text(), CreateUpdateUserResponse.class);
        Assertions.assertThat(createUserResponseDTO.getId()).isNotNull();
        log.info("Created user: " + createUserResponseDTO);

        log.info("Step 2: Update the user");
        user.setEmail("agata@test.pl");

        APIResponse updateUserResponse = context.put("users/" + createUserResponseDTO.getId(), RequestOptions.create().setData(user));
        Assertions.assertThat(updateUserResponse.status()).isEqualTo(200);
        CreateUpdateUserResponse updateUserResponseDTO = new Gson().fromJson(updateUserResponse.text(), CreateUpdateUserResponse.class);
        Assertions.assertThat(updateUserResponseDTO.getEmail()).isEqualTo("agata@test.pl");
        log.info("Updated user: " + updateUserResponseDTO);

        log.info("Step 3: Read updated user");
        APIResponse apiResponse = context.get("users/" + createUserResponseDTO.getId());
        GetUserResponse getUserResponseDTO = new Gson().fromJson(apiResponse.text(), GetUserResponse.class);
        Assertions.assertThat(getUserResponseDTO.getEmail()).isEqualTo("agata@test.pl");
        log.info("Read user: " + updateUserResponseDTO);

    }
}
