package pl.akademiaqa.apitesting.tests;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.apitesting.response.GetUserResponse;
import pl.akademiaqa.pages.common.BaseApiTest;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

class ReadSingleUserTest extends BaseApiTest {

    Playwright playwright;

    APIRequest request;

    APIRequestContext apiContext;

    @BeforeEach
    void beforeEach() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        playwright = Playwright.create();
        request = playwright.request();
        apiContext = request.newContext(new APIRequest.NewContextOptions()
                .setBaseURL("https://jsonplaceholder.typicode.com")
                .setExtraHTTPHeaders(headers));
    }

    @Test
    void should_return_single_user_response_test() {
        APIResponse response = apiContext.get("users/10");
        PlaywrightAssertions.assertThat(response).isOK();

        System.out.println(response.status());
        System.out.println(response.statusText());
        System.out.println(new String(response.body(), StandardCharsets.UTF_8));
        System.out.println(response.headers());
        System.out.println(response.url());
        System.out.println(response.text());
    }

    @Test
    void should_return_single_user_gson_test() {
        APIResponse response = apiContext.get("users/10");
        PlaywrightAssertions.assertThat(response).isOK();

        JsonObject jsonResponse = new Gson().fromJson(response.text(), JsonObject.class);
        System.out.println(jsonResponse);
        System.out.println(jsonResponse.get("name"));
        System.out.println(jsonResponse.get("email"));
    }

    @Test
    void should_return_single_user_jackson_test() throws IOException {
        APIResponse response = apiContext.get("users/10");
        PlaywrightAssertions.assertThat(response).isOK();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(response.text());
        System.out.println(jsonNode.toPrettyString());
        System.out.println(jsonNode.get("name"));
    }

    //deserializacja
    @Test
    void should_return_single_user_dto_test(){
        APIResponse response = apiContext.get("users/10");
        PlaywrightAssertions.assertThat(response).isOK();

        GetUserResponse getUserResponse = new Gson().fromJson(response.text(), GetUserResponse.class);
        System.out.println(getUserResponse);

    }
}