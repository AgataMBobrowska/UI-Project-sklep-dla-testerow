package pl.akademiaqa.apitesting.assertions;

import com.microsoft.playwright.APIResponse;
import org.assertj.core.api.Assertions;

public class StatusCodeAssertions {

    public static void assert201(APIResponse response) {
        Assertions.assertThat(response.status()).isEqualTo(201);
    }

    public static void assert200(APIResponse response) {
        Assertions.assertThat(response.status()).isEqualTo(200);
    }

    public static void assert204(APIResponse response) {
        Assertions.assertThat(response.status()).isEqualTo(204);
    }

    public static void assert404(APIResponse response) {
        Assertions.assertThat(response.status()).isEqualTo(404);
    }
}
