package pl.akademiaqa.apitesting.tests;

import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.pages.common.BaseApiTest;

class ReadAllPostsTest extends BaseApiTest {

    @Test
    void should_return_all_posts() {
        APIResponse response = context.get("posts");
        PlaywrightAssertions.assertThat(response).isOK();
        log.info(response.text());
    }
}
