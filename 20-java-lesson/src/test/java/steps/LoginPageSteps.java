package steps;

import pages.LoginPage;

import static com.codeborne.selenide.Selenide.page;

public class LoginPageSteps {
    LoginPage page;
    public LoginPageSteps() {
        page = page(LoginPage.class);
    }
    public void Login(String login, String password) {
        page.userNameInput.setValue(login);
        page.userPasswordInput.setValue(password);
        page.loginButton.click();
    }
}
