package pl.akademiaqa.apitesting;

import com.microsoft.playwright.Response;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.tests.BaseTest;

import java.util.ArrayList;
import java.util.List;

public class RequestResponseTest extends BaseTest {

    @Test
    void should_return_status_code_200() {
        Response response = page.navigate("http://skleptestera.pl");

        // STATUS CODE 200
        System.out.println(response.status());
        System.out.println(response.ok());

        // BODY
        System.out.println(response.text());

        //HEADERS
        System.out.println(response.headers());

        //URL
        System.out.println(response.url());

        Assertions.assertThat(response.ok()).isTrue();
    }

    @Test
    void should_return_request_method_get_test() {
        Response response = page.navigate("http://skleptestera.pl");

        System.out.println(response.request().method());
        System.out.println(response.request().postData());
        System.out.println(response.request().headers());

        Assertions.assertThat(response.request().method()).isEqualTo("GET");
    }

    @Test
    void http_handlers_test() {
        page.onRequest(req -> System.out.println(">>" + req.method() + req.url()));
        page.onResponse(res -> System.out.println("<<" + res.status()));
        page.navigate("http://skleptestera.pl");
    }

    @Test
    void should_return_redirects_in_status_code_200_v2() {
        List<Integer> statusCodes = new ArrayList<>();
        page.onResponse(res -> statusCodes.add(res.status()));
        page.navigate("http://skleptestera.pl");

        Assertions.assertThat(statusCodes.stream().allMatch(s -> s == 200)).isFalse();
        Assertions.assertThat(statusCodes).contains(301);
        Assertions.assertThat(statusCodes).contains(302);
    }

    @Test
    void should_return_only_status_code_200() {
        List<Integer> statusCodes = new ArrayList<>();
        page.onResponse(res -> statusCodes.add(res.status()));
        page.navigate("https://skleptestera.pl/index.php");

        Assertions.assertThat(statusCodes.stream().allMatch(s -> s == 200)).isTrue();
    }
}
