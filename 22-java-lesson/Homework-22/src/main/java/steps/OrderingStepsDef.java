package steps;

import com.codeborne.selenide.CollectionCondition;
import io.cucumber.java.ru.*;
import pages.*;
import static com.codeborne.selenide.Selenide.page;

public class OrderingStepsDef {
    InventoryPage inventoryPage;
    CartPage cartPage;
    CheckoutStepOnePage checkoutStepOnePage;
    CheckoutStepTwoPage checkoutStepTwoPage;
    CheckoutCompletePage checkoutCompletePage;

    public OrderingStepsDef() {
        inventoryPage = page(InventoryPage.class);
        cartPage = page(CartPage.class);
        checkoutStepOnePage = page(CheckoutStepOnePage.class);
        checkoutStepTwoPage = page(CheckoutStepTwoPage.class);
        checkoutCompletePage = page(CheckoutCompletePage.class);
    }
    @Когда("Пользователь нажимает на кнопку Checkout")
    public void userClicksOnCheckoutBtn() {
        cartPage.checkoutButton.click();
    }
    @Когда("Пользователь нажимает на кнопку Finish")
    public void userClicksOnFinishBtn() {
        checkoutStepTwoPage.finishButton.click();
    }
    @Когда("Пользователь нажимает на кнопку Back Home")
    public void userClicksOnBackHomeBtn() {
        checkoutCompletePage.backToProductsButton.click();
    }
    @Тогда("Количество товаров в корзине равно {int}")
    public void checkIfItemsNumberInTheBinEqual(Integer count) {
        cartPage.cartItems.shouldHave(CollectionCondition.size(count));
    }

    @И("Пользователь заполняет поле First Name значением {string}, Last Name значением {string}, Zip Code значением {string} и нажимает на кнопку Continue")
    public void userFillsCheckoutInfoAndClicksOnContinueButton(String fName, String lName, String zip) {
        checkoutStepOnePage.firstNameInput.setValue(fName);
        checkoutStepOnePage.lastNameInput.setValue(lName);
        checkoutStepOnePage.zipcodeInput.setValue(zip);
        checkoutStepOnePage.continueButton.click();
    }
}
