package steps;

import pages.LoginPage;

public class LoginPageSteps {
    LoginPage page;
    public LoginPageSteps() {
        page = new LoginPage();
    }
    public void Login(String login, String password) {
        page.userNameInput().setValue(login);
        page.userPasswordInput().setValue(password);
        page.loginButton().click();
    }
}
