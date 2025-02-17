package pl.akademiaqa.utils;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PageUtils {

    public static void waitForThePageToLoad(Page page) {
        page.waitForLoadState(LoadState.NETWORKIDLE);
    }
}
