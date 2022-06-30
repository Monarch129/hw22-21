package tests;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static com.codeborne.selenide.Condition.*;

class PageObjectTests extends Application {

    public PageObjectTests() {
        super();
    }
    @Test
    void CheckAddedItemAppearsInBin(){
        int itemsAddedToCart = inventoryPage.addAllInventoryToCart();
        inventoryPage.getCartButton().click();
        int actualCartItemsCount = cartPage.getCartItemsCount();

        Assertions.assertEquals(itemsAddedToCart, actualCartItemsCount);
    }

    @Test
    void CheckShoppingBadge(){ // тест короткий, а переносить assertions в page неправильно (тк assertions запрашиваю на каждое добавление товара)
        ElementsCollection collection = inventoryPage.getInventoryItems();
        int count = 0;
        for (SelenideElement invItem: collection) {
            inventoryPage.getElementInnerButton(invItem).click();
            count++;
            inventoryPage.getShoppingBadge().shouldBe(visible).shouldHave(exactText(String.valueOf(count)));
        }
    }

    @Test
    void CheckBinIsEmptyAfterMadeOrder() {
        String fName = "Julie";
        String lName = "Chimsburmger";
        String zip = "1234";
        int expectedCartItemsCount = 0;

        inventoryPage.addRandomItemToCart();

        inventoryPage.getCartButton().click();
        cartPage.getCheckoutButton().click();

        checkoutStepOnePage.fillCheckoutInfo(fName, lName, zip);
        checkoutStepTwoPage.getFinishButton().click();
        checkoutCompletePage.backToProductsButton().click();

        inventoryPage.getCartButton().click();

        int actualCartItemsCount = cartPage.getCartItemsCount();
        Assertions.assertEquals(expectedCartItemsCount, actualCartItemsCount);
    }
    @ParameterizedTest
    @ValueSource(strings = {"Sauce Labs Backpack","Sauce Labs Bike Light",
            "Sauce Labs Bolt T-Shirt","Sauce Labs Fleece Jacket",
            "Sauce Labs Onesie","Test.allTheThings() T-Shirt (Red)"})
    void CheckOpenItemDetails(String itemName){ // так же, тест очень простой, какую-либо логику выносить куда-то не вижу смысла.
            inventoryPage.getItemDetailsByName(itemName).click();
            inventoryItemPage.getInventoryItemContainer().shouldBe(visible).shouldBe(enabled);
    }

    @Test
    void CheckDeletingItemsFromTheBin(){
        int addedItemCount = inventoryPage.addAllInventoryToCart();
        inventoryPage.getCartButton().click();

        int actualCartItemsCount = cartPage.getCartItemsCount();
        Assertions.assertEquals(addedItemCount, actualCartItemsCount, "Amount after adding");

        cartPage.RemoveAllItems();
        actualCartItemsCount = cartPage.getCartItemsCount();
        Assertions.assertEquals(0,actualCartItemsCount, "Amount after deleting");
    }
}