package steps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;
import static com.codeborne.selenide.Selenide.open;

public class CommonStepsDef {

    private static void clearBrowserHistory() {
        Selenide.clearBrowserLocalStorage();
        Selenide.clearBrowserCookies();
    }
    private static void closeBrowser(){
        WebDriverRunner.getWebDriver().quit();
    }
    @After("@line")
    public void clearBrowserAfterEachExceptLoop(){
        clearBrowserHistory();
    }

    @BeforeAll
    public static void clearBrowserBeforeAll() {
        open("https://www.saucedemo.com/");
        clearBrowserHistory();
        closeBrowser();
    }
}
