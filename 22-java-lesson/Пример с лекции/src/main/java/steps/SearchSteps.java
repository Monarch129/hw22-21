package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Тогда;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.AlfabankPage;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.openqa.selenium.remote.CapabilityType.BROWSER_VERSION;

public class SearchSteps {

    @Дано("пользователь \"Вася\" открыл страницу alfabank.ru")
    public void openPage() {
        WebDriverRunner.setWebDriver(createChromeDriver());
        Selenide.open("https://alfabank.ru/");
    }

    @Дано("выполнили поиск по слову {string}")
    public void searchByWord(String value) {
        AlfabankPage.alfabankPage().searchInput.setValue(value);
        AlfabankPage.alfabankPage().searchBtn.click();
    }

    @Тогда("на странице получили {string} результатов")
    public void checkResultCounter(String value) {
        AlfabankPage.alfabankPage().resultCounter.shouldHave(Condition.text(value));
    }

    @Before("@cards")
    public void setTimeout() {
        Configuration.timeout = 10000;
        System.out.println(Configuration.timeout);
    }

    @BeforeStep
    public void beforeStepTmp() {
        System.out.println("Перед шагом");
    }

    @After
    public void tearDown() {
        getWebDriver().quit();
    }


    private WebDriver createChromeDriver() {
        return new ChromeDriver(getChromeDriverOptions());
    }

    private ChromeOptions getChromeDriverOptions() {
        ChromeOptions chromeOptions = new ChromeOptions().addArguments("disable-extensions",
                "test-type", "no-default-browser-check", "ignore-certificate-errors",
                "--window-size=1920,1080");
        chromeOptions.setCapability(BROWSER_VERSION, "103");
        return chromeOptions;
    }


}
