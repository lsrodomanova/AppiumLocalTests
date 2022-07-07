package tests;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

@Tag("appium")
public class OnboardingTests extends TestBase {

    @Test
    void WikiTest() {

        step("Open first page", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView")).
                    shouldHave(text("The Free Encyclopedia …in over 300 languages"));
        });

        step("Open second page", () -> {
            $(AppiumBy.xpath("//android.widget.LinearLayout[2]")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("New ways to explore"));
        });

        step("Open third page", () -> {
            $(AppiumBy.xpath("//android.widget.LinearLayout[3]")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("Reading lists with sync"));
        });

        step("Open forth page", () -> {
            $(AppiumBy.xpath("//android.widget.LinearLayout[4]")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("Send anonymous data"));
        });
    }
}
