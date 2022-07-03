package tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PageObjectTests extends Application {
    public PageObjectTests() {
        super();
    }
    @Test
    void CheckAddedItemAppearsInBin(){
        int itemsAddedToCart = inventoryPageSteps.addAllInventoryToCart();
        inventoryPageSteps.goToCart();
        cartPageSteps.checkCountItems(itemsAddedToCart);
    }
    @Test
    void CheckShoppingBadge(){
        inventoryPageSteps.checkShoppingBadgeChanging();
    }
    @Test
    void CheckBinIsEmptyAfterMadeOrder() {
        String fName = "Julie";
        String lName = "Chimsburmger";
        String zip = "1234";
        int expectedCartItemsCount = 0;

        inventoryPageSteps.addRandomItemToCart();
        inventoryPageSteps.goToCart();
        cartPageSteps.goToCheckout();
        checkoutStepOnePageSteps.fillCheckoutInfo(fName, lName, zip);
        checkoutStepTwoPageSteps.finishOrder();
        checkoutCompletePageSteps.backToProducts();
        inventoryPageSteps.goToCart();

        cartPageSteps.checkCountItems(expectedCartItemsCount);
    }
    @ParameterizedTest
    @ValueSource(strings = {"Sauce Labs Backpack","Sauce Labs Bike Light","Sauce Labs Bolt T-Shirt",
            "Sauce Labs Fleece Jacket","Sauce Labs Onesie","Test.allTheThings() T-Shirt (Red)"})
    void CheckOpenItemDetails(String itemName){ //
            inventoryPageSteps.openInventoryItemByName(itemName);
            inventoryItemPageSteps.checkInventoryItemIsOpenedAndShown();
    }
    @Test
    void CheckDeletingItemsFromTheBin(){
        int addedItemCount = inventoryPageSteps.addAllInventoryToCart();
        inventoryPageSteps.goToCart();
        cartPageSteps.checkCountItems(addedItemCount);

        cartPageSteps.removeAllItems();
        cartPageSteps.checkCountItems(0);
    }
}