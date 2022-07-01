package steps;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pages.InventoryPage;
import java.util.Random;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;

public class InventoryPageSteps {
    InventoryPage page;

    public InventoryPageSteps() {
        this.page = new InventoryPage();
    }

    public int addAllInventoryToCart() {
        ElementsCollection collection = page.getInventoryItems();
        int collectionLength = collection.size();
        for (SelenideElement invItem: collection) {
            page.getElementInnerButton(invItem).click();
        }
        return collectionLength;
    }
    public void addRandomItemToCart() {
        ElementsCollection collection = page.getInventoryItems();
        Random rnd = new Random();
        int i = rnd.nextInt(collection.size());
        page.getElementInnerButton(collection.get(i)).click();
    }
    public void goToCart() {
        page.getCartButton().click();
    }
    public void openInventoryItemByName(String itemName) {
        page.getItemDetailsByName(itemName).click();
    }
    public void checkShoppingBadgeChanging() {
        ElementsCollection collection = page.getInventoryItems();
        int count = 0;
        for (SelenideElement invItem: collection) {
            page.getElementInnerButton(invItem).click();
            count++;
            page.getShoppingBadge().shouldBe(visible).shouldHave(exactText(String.valueOf(count)));
        }
    }
}