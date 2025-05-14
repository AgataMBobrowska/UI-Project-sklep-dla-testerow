package pl.akademiaqa.apitesting.tests;

import com.microsoft.playwright.APIResponse;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.apitesting.assertions.StatusCodeAssertions;
import pl.akademiaqa.apitesting.facades.CreateUserApiFacade;
import pl.akademiaqa.apitesting.payload.CreateUserPayload;
import pl.akademiaqa.apitesting.response.CreateUpdateUserResponse;
import pl.akademiaqa.pages.common.BaseApiTest;

import static pl.akademiaqa.apitesting.assertions.StatusCodeAssertions.assert404;

class DeleteUserTest  extends BaseApiTest {

    @Test
    void should_delete_existing_user_test() {

        CreateUserPayload user = CreateUserPayload.createDefaultPayload();
        CreateUpdateUserResponse createUserDTO = CreateUserApiFacade.createUser(context, user);

        log.info("Step 2: Delete the user");
        APIResponse apiResponse = context.delete("users/" + createUserDTO.getId());
        StatusCodeAssertions.assert200(apiResponse);  //204 - no content

        log.info("Step 3: Read deleted user");
        APIResponse getUserResponse = context.get("users/" + createUserDTO.getId());
        assert404(getUserResponse);
    }
}
