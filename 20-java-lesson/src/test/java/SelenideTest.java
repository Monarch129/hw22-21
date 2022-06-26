import com.codeborne.selenide.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import java.util.Random;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static org.openqa.selenium.By.*;

class SelenideTest {

    @BeforeEach
    void Login(){
        String login = "standard_user";
        String password = "secret_sauce";

        open("https://www.saucedemo.com/");
        element(By.name("user-name")).setValue(login);
        element(By.name("password")).setValue(password);
        element(By.name("login-button")).click();
    }
    @Test
    void CheckAddedItemAppearsInBin(){
        ElementsCollection collection = elements(className("inventory_item"));
        int collectionLength = collection.size();
        for (SelenideElement invItem: collection) {
            invItem.findElement(cssSelector("button")).click();
        }

        open("https://www.saucedemo.com/cart.html");
        ElementsCollection cart_collection = elements(className("cart_item"));
        cart_collection.shouldHave(CollectionCondition.size(collectionLength));
    }

    @Test
    void CheckShoppingBadge(){
        ElementsCollection collection = elements(className("inventory_item"));
        int count = 0;
        for (SelenideElement invItem: collection) {
            invItem.findElement(cssSelector("button")).click();
            count++;
            element(By.xpath("//span[contains(@class, 'shopping_cart_badge')]"))
                    .shouldBe(visible).shouldHave(exactText(String.valueOf(count)));
        }
    }

    @Test
    void CheckBinIsEmptyAfterMadeOrder() {
        String fName = "Julie";
        String lName = "Chimsburmger";
        String zip = "1234";

        ElementsCollection collection = elements(className("inventory_item"));
        Random rnd = new Random();
        int i = rnd.nextInt(collection.size());
        collection.get(i).find(cssSelector("button")).click();

        open("https://www.saucedemo.com/cart.html");
        element(xpath("//button[@id='checkout']")).click();

        element(xpath("//input[@id='first-name']")).setValue(fName);
        element(xpath("//input[@id='last-name']")).setValue(lName);
        element(xpath("//input[@id='postal-code']")).setValue(zip);
        element(xpath("//input[@id='continue']")).click();
        element(xpath("//button[@id='finish']")).click();

        open("https://www.saucedemo.com/cart.html");
        ElementsCollection cart_collection = elements(className("cart_item"));
        cart_collection.shouldHave(CollectionCondition.size(0));
    }
    @Test
    void CheckOpenItemDetails(){
        String[] inventoryList = {"Sauce Labs Backpack","Sauce Labs Bike Light",
                "Sauce Labs Bolt T-Shirt","Sauce Labs Fleece Jacket",
                "Sauce Labs Onesie","Test.allTheThings() T-Shirt (Red)"};
        for (String invItem: inventoryList) {
            element(xpath("//div[@class='inventory_item_name' and text()='"+invItem+"']")).click();
            element(xpath("//button[@id='back-to-products']")).shouldBe(visible).shouldBe(enabled).click();
        }
    }

    @Test
    void CheckDeletingItemsFromTheBin(){
        ElementsCollection itemCollection = elements(className("inventory_item"));
        int collectionLength = itemCollection.size();
        for (SelenideElement invItem: itemCollection) {
            invItem.findElement(cssSelector("button")).click();
        }

        open("https://www.saucedemo.com/cart.html");

        itemCollection = elements(className("cart_item"));
        itemCollection.shouldHave(CollectionCondition.size(collectionLength));

        for (SelenideElement cartItem: itemCollection) {
            cartItem.find(cssSelector("button.cart_button")).click();
        }

        itemCollection.shouldHave(CollectionCondition.size(0));
    }

    @AfterEach
    void Wait() throws InterruptedException {
        Thread.sleep(3000);

        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        //elements(className("cart_item")).forEach(i -> i.findElement(tagName("button")).click());
    }
}