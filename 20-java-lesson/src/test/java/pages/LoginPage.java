package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.element;

public class LoginPage extends BasePage{
    public LoginPage() {
        super();
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
}
