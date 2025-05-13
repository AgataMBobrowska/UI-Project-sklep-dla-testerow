package pl.akademiaqa.apitesting.transformers;

import com.google.gson.Gson;
import com.microsoft.playwright.APIResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.akademiaqa.apitesting.response.CreateUpdateUserResponse;
import pl.akademiaqa.apitesting.response.GetUserResponse;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserTransformers {

    public static GetUserResponse readUserToResponseDTO(APIResponse apiResponse) {
        return new Gson().fromJson(apiResponse.text(), GetUserResponse.class);
    }

    public static CreateUpdateUserResponse createUpdateUserResponseDTO(APIResponse response) {
        return new Gson().fromJson(response.text(), CreateUpdateUserResponse.class);
    }
}
