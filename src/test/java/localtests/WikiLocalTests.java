package localtests;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.back;
import static io.qameta.allure.Allure.step;

@Tag("appium")
public class WikiLocalTests extends TestBaseLocal{
    String firstLanguage= "English";
    String secondLanguage="Italiano";

    @Test
    void WikiTest() {
        back();
        step("Open first page", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/addLangContainer")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/section_header_text")).shouldHave(text(firstLanguage));
        });

        step("Open second page", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/wiki_language_title")).click();
            $(AppiumBy.className("org.wikipedia.alpha:id/section_header_text")).shouldHave(text("All languages"));
        });

        step("Open third page", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/search_container")).find(byText(secondLanguage)).click();
            $(AppiumBy.className("android.widget.LinearLayout")).shouldHave(text(secondLanguage));
        });

        step("Open forth page", () -> {
            $(AppiumBy.className("android.widget.ImageButton")).click();
            $(AppiumBy.className("android.widget.TextView")).shouldHave(text("The Free Encyclopedia …in over 300 languages"));
        });
    }
}
