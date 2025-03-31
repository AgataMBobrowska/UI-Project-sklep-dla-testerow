package pl.akademiaqa.apitesting;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.Test;

public class ReadSingleUserTest {

    Playwright playwright;

    APIRequest request;

    APIRequestContext apiContext;

    @Test
    void should_return_single_user_response_test() {

        playwright = Playwright.create();
        request = playwright.request();
        apiContext = request.newContext();

        APIResponse response = apiContext.get("https://jsonplaceholder.typicode.com/users/10");
        PlaywrightAssertions.assertThat(response).isOK();
    }
}