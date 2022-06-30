package tests;
import com.codeborne.selenide.*;
import org.junit.jupiter.api.*;
import pages.SinglePage;
import java.util.Random;
import static com.codeborne.selenide.Condition.*;

class SelenideTest {
    SinglePage site;
    @BeforeEach
    void Login(){
        String login = "standard_user";
        String password = "secret_sauce";

        site = new SinglePage();

        site.userNameInput().setValue(login);
        site.userPasswordInput().setValue(password);
        site.loginButton().click();
    }

    @Test
    void CheckAddedItemAppearsInBin(){
        ElementsCollection collection = site.getInventoryItems();
        int collectionLength = collection.size();
        for (SelenideElement invItem: collection) {
            site.getElementInnerButton(invItem).click();
        }

        site.goToCart();;
        ElementsCollection cart_collection = site.getCartItems();

        cart_collection.shouldHave(CollectionCondition.size(collectionLength));
    }

    @Test
    void CheckShoppingBadge(){
        ElementsCollection collection = site.getInventoryItems();
        int count = 0;
        for (SelenideElement invItem: collection) {
            site.getElementInnerButton(invItem).click();
            count++;
            site.getShoppingBadge().shouldBe(visible).shouldHave(exactText(String.valueOf(count)));
        }
    }

    @Test
    void CheckBinIsEmptyAfterMadeOrder() {
        String fName = "Julie";
        String lName = "Chimsburmger";
        String zip = "1234";

        ElementsCollection collection = site.getInventoryItems();
        Random rnd = new Random();
        int i = rnd.nextInt(collection.size());
        site.getElementInnerButton(collection.get(i)).click();

        site.goToCart();
        site.getCheckoutButton().click();

        site.firstNameInput().setValue(fName);
        site.lastNameInput().setValue(lName);
        site.zipcodeInput().setValue(zip);
        site.getContinueButton().click();
        site.getFinishButton().click();

        ElementsCollection cart_collection = site.getCartItems();
        cart_collection.shouldHave(CollectionCondition.size(0));
    }
    @Test
    void CheckOpenItemDetails(){
        String[] inventoryList = {"Sauce Labs Backpack","Sauce Labs Bike Light",
                "Sauce Labs Bolt T-Shirt","Sauce Labs Fleece Jacket",
                "Sauce Labs Onesie","Test.allTheThings() T-Shirt (Red)"};
        for (String invItem: inventoryList) {
            site.getItemDetailsByName(invItem).click();
            site.getItemDetailBackButton().shouldBe(visible).shouldBe(enabled).click();
        }
    }

    @Test
    void CheckDeletingItemsFromTheBin(){
        ElementsCollection itemCollection = site.getInventoryItems();
        int collectionLength = itemCollection.size();
        for (SelenideElement invItem: itemCollection) {
            site.getElementInnerButton(invItem).click();
        }

        site.goToCart();

        itemCollection = site.getCartItems();
        itemCollection.shouldHave(CollectionCondition.size(collectionLength));

        for (SelenideElement cartItem: itemCollection) {
            site.getElementRemoveButton(cartItem).click();
        }

        itemCollection.shouldHave(CollectionCondition.size(0));
    }

    @AfterEach
    void Wait() throws InterruptedException {
        Thread.sleep(3000);
        //оставила для наглядности, что все работает верно

        site.clearCookiesAndStorage();
    }
}