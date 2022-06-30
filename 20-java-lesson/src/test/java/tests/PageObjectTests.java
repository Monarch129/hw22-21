package tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static com.codeborne.selenide.Condition.*;

class PageObjectTests extends Application {

    public PageObjectTests() {
        super();
    }
    @Test
    void CheckAddedItemAppearsInBin(){
        ElementsCollection collection = inventoryPage.getInventoryItems();
        int collectionLength = collection.size();
        for (SelenideElement invItem: collection) {
            inventoryPage.getElementInnerButton(invItem).click();
        }

        inventoryPage.getCartButton().click();
        ElementsCollection cart_collection = cartPage.getCartItems();

        cart_collection.shouldHave(CollectionCondition.size(collectionLength));
    }

    @Test
    void CheckShoppingBadge(){
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

        ElementsCollection collection = inventoryPage.getInventoryItems();
        Random rnd = new Random();
        int i = rnd.nextInt(collection.size());
        inventoryPage.getElementInnerButton(collection.get(i)).click();

        inventoryPage.getCartButton().click();
        cartPage.getCheckoutButton().click();

        checkoutStepOnePage.firstNameInput().setValue(fName);
        checkoutStepOnePage.lastNameInput().setValue(lName);
        checkoutStepOnePage.zipcodeInput().setValue(zip);
        checkoutStepOnePage.getContinueButton().click();
        checkoutStepTwoPage.getFinishButton().click();

        checkoutCompletePage.backToProductsButton().click();
        inventoryPage.getCartButton().click();

        ElementsCollection cart_collection = cartPage.getCartItems();
        cart_collection.shouldHave(CollectionCondition.size(0));
    }
    @Test
    void CheckOpenItemDetails(){
        String[] inventoryList = {"Sauce Labs Backpack","Sauce Labs Bike Light",
                "Sauce Labs Bolt T-Shirt","Sauce Labs Fleece Jacket",
                "Sauce Labs Onesie","Test.allTheThings() T-Shirt (Red)"};
        for (String invItem: inventoryList) {
            inventoryPage.getItemDetailsByName(invItem).click();
            inventoryItemPage.getInventoryItemContainer().shouldBe(visible).shouldBe(enabled);
            inventoryItemPage.getItemDetailBackButton().click();
        }
    }

    @Test
    void CheckDeletingItemsFromTheBin(){
        ElementsCollection itemCollection = inventoryPage.getInventoryItems();
        int collectionLength = itemCollection.size();
        for (SelenideElement invItem: itemCollection) {
            inventoryPage.getElementInnerButton(invItem).click();
        }

        inventoryPage.getCartButton().click();

        itemCollection = cartPage.getCartItems();
        itemCollection.shouldHave(CollectionCondition.size(collectionLength));

        for (SelenideElement cartItem: itemCollection) {
            cartPage.getElementRemoveButton(cartItem).click();
        }

        itemCollection.shouldHave(CollectionCondition.size(0));
    }
}