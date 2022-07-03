package steps;

import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.ru.*;
import pages.LoginPage;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertEquals;

public class AuthenticationStepsDef {
    LoginPage page;
    public AuthenticationStepsDef() {
        page = page(LoginPage.class);
    }
    @Дано("Пользователь заходит на главную страницу сайта")
    public void openMainPage(){
        open("https://www.saucedemo.com/");
    }
    @Когда("Пользователь вводит логин {string}, пароль {string} и нажимает кнопку Log in")
    public void authenticate(String login, String password){
        page.userNameInput.setValue(login);
        page.userPasswordInput.setValue(password);
        page.loginButton.click();
    }
    @Тогда("Производится переход на страницу с товарами {string}")
    public void checkCurrentPageIsInventory(String expectedUrl){
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(expectedUrl, currentUrl);
    }
}
