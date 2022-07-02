package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.element;

public class LoginPage extends BasePage{
    public LoginPage() {
        super();
    }
    @FindBy( how = How.NAME, using = "user-name")
    public SelenideElement userNameInput;
    @FindBy( how = How.NAME, using = "password")
    public SelenideElement userPasswordInput;
    @FindBy( how = How.NAME, using = "login-button")
    public SelenideElement loginButton;
}
