package pl.akademiaqa.apitesting;

import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.pages.common.BaseApiTest;

class ReadAllUsersTest extends BaseApiTest {

    @Test
    void should_return_all_users() {
        APIResponse response = context.get("users");
        PlaywrightAssertions.assertThat(response).isOK();
        System.out.println(response.text());
    }
}
