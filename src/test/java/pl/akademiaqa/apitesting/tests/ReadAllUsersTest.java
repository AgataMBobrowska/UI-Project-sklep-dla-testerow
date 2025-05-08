package pl.akademiaqa.apitesting.tests;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.apitesting.response.GetUserResponse;
import pl.akademiaqa.pages.common.BaseApiTest;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class ReadAllUsersTest extends BaseApiTest {

    @Test
    void should_return_all_users() {
        APIResponse response = context.get("users");
        PlaywrightAssertions.assertThat(response).isOK();
        log.info(response.text());
    }

    @Test
    void should_return_list_of_users() {
        APIResponse response = context.get("users");
        PlaywrightAssertions.assertThat(response).isOK();
        JsonArray jsonArray = new Gson().fromJson(response.text(), JsonArray.class);
        log.info(jsonArray.toString());

        List<String> emails = jsonArray.asList()
                .stream()
                .map(el -> el.getAsJsonObject().get("email").getAsString())
                .collect(Collectors.toList());
        log.info("List of emails: " + emails);

        Assertions.assertThat(emails).contains("Sincere@april.biz");
    }

    @Test
    void should_return_list_of_users_jackson_test() throws IOException {
        APIResponse response = context.get("users");
        PlaywrightAssertions.assertThat(response).isOK();

        // JACKSON DATABIND - zamiana odpowiedzi na JsonNode
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(response.text());
        log.info(jsonNode.toString());
        log.info("First user email: " + jsonNode.get(0).get("email"));
    }

    @Test
    void should_return_list_of_users_dto() {
        APIResponse response = context.get("users");
        PlaywrightAssertions.assertThat(response).isOK();

        List<GetUserResponse> userResponses = Arrays.asList(new Gson().fromJson(response.text(), GetUserResponse[].class));
        log.info("Users DTO: " + userResponses);

        //zmiana odpowiedzi na DTO
        JsonArray jsonArray = new Gson().fromJson(response.text(), JsonArray.class);
        List <GetUserResponse> usersList = jsonArray.asList()
                .stream()
                .map(el -> new GetUserResponse(
                    el.getAsJsonObject().get("id").getAsInt(),
                    el.getAsJsonObject().get("name").getAsString(),
                    el.getAsJsonObject().get("username").getAsString(),
                    el.getAsJsonObject().get("email").getAsString())
                ).collect(Collectors.toList());

        log.info("Users DTO: " + usersList);
    }
}
