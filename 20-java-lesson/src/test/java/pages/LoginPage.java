package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.element;

public class LoginPage extends BasePage{
    private static String pageUrl = "https://www.saucedemo.com/";

    public LoginPage() {
        super(pageUrl);
    }

    public SelenideElement userNameInput() {
        return element(By.name("user-name"));
    }

    public SelenideElement userPasswordInput() {
        return element(By.name("password"));
    }

    public SelenideElement loginButton() {
        return element(By.name("login-button"));
    }

    public void Login(String login, String password) {
        this.userNameInput().setValue(login);
        this.userPasswordInput().setValue(password);
        this.loginButton().click();
    }
}
