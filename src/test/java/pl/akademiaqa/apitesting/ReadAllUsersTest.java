package pl.akademiaqa.apitesting;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.impl.AssertionsTimeout;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.pages.common.BaseApiTest;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
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
}
