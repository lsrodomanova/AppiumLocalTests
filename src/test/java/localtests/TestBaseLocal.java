package localtests;

import helpers.AllureAttachments;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import drivers.BrowserstackMobileDriver;
import drivers.LocalDriver;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;


import java.util.Objects;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.AllureAttachments.sessionId;
import static io.qameta.allure.Allure.step;

public class TestBaseLocal {
    @BeforeAll
    public static void setup() {
        String deviceHost = System.getProperty("deviceHost", "local");

        if (Objects.equals(deviceHost, "local")) {
            Configuration.browser = LocalDriver.class.getName();
        } else {
            Configuration.browser = BrowserstackMobileDriver.class.getName();
        }
        Configuration.browserSize = null;
    }

    @BeforeEach
    public void startDriver() {
        addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    public void afterEach() {

        String sessionId = sessionId();
        AllureAttachments.screenshotAs("Last screenshot");
        AllureAttachments.pageSource();

        step("Close driver", Selenide::closeWebDriver);
            AllureAttachments.video(sessionId);
    }
}
