package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import steps.*;

public class Application {
    LoginPageSteps loginPageSteps;
    InventoryPageSteps inventoryPageSteps;
    InventoryItemPageSteps inventoryItemPageSteps;
    CheckoutStepOnePageSteps checkoutStepOnePageSteps;
    CheckoutStepTwoPageSteps checkoutStepTwoPageSteps;
    CheckoutCompletePageSteps checkoutCompletePageSteps;
    CartPageSteps cartPageSteps;
    CommonSteps commonSteps;

    public Application() {
        loginPageSteps = new LoginPageSteps();
        inventoryPageSteps = new InventoryPageSteps();
        inventoryItemPageSteps = new InventoryItemPageSteps();
        checkoutStepOnePageSteps = new CheckoutStepOnePageSteps();
        checkoutStepTwoPageSteps = new CheckoutStepTwoPageSteps();
        checkoutCompletePageSteps = new CheckoutCompletePageSteps();
        cartPageSteps = new CartPageSteps();
        commonSteps = new CommonSteps();
    }

    @BeforeEach
    void Login(){
        String login = "standard_user";
        String password = "secret_sauce";
        commonSteps.openUrl("https://www.saucedemo.com/");
        loginPageSteps.Login(login, password);
    }

    @AfterEach
    void Wait() throws InterruptedException {
        Thread.sleep(2000);//оставила для наглядности, что все работает верно
        commonSteps.clearCookiesAndStorage();
    }
}
