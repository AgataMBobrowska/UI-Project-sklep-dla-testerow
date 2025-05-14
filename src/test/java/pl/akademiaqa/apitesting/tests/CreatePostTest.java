package pl.akademiaqa.apitesting.tests;

import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.RequestOptions;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.pages.common.BaseApiTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

class CreatePostTest extends BaseApiTest {

    @Test
    void should_create_new_post_from_file_post_test() throws IOException {

        byte[] post = Files.readAllBytes(Path.of("src/main/resources/json/post.json"));

        APIResponse posts = context.post("posts", RequestOptions.create().setData(post));
        PlaywrightAssertions.assertThat(posts).isOK();

        log.info("Created post: " + posts.text());
    }
}
