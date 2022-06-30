package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.*;

public class Application {
    LoginPage loginPage;
    InventoryPage inventoryPage;
    InventoryItemPage inventoryItemPage;
    CheckoutStepOnePage checkoutStepOnePage;
    CheckoutStepTwoPage checkoutStepTwoPage;
    CheckoutCompletePage checkoutCompletePage;
    CartPage cartPage;

    public Application() {
        loginPage = new LoginPage();
        inventoryPage = new InventoryPage();
        inventoryItemPage = new InventoryItemPage();
        checkoutStepOnePage = new CheckoutStepOnePage();
        checkoutStepTwoPage = new CheckoutStepTwoPage();
        checkoutCompletePage = new CheckoutCompletePage();
        cartPage = new CartPage();
    }

    @BeforeEach
    void Login(){
        String login = "standard_user";
        String password = "secret_sauce";

        loginPage.openPage();

        loginPage.userNameInput().setValue(login);
        loginPage.userPasswordInput().setValue(password);
        loginPage.loginButton().click();
    }

    @AfterEach
    void Wait() throws InterruptedException {
        Thread.sleep(3000);
        //оставила для наглядности, что все работает верно

        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }
}
