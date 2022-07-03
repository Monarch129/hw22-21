package steps;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pages.InventoryPage;
import java.util.Random;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class InventoryPageSteps {
    InventoryPage page;

    public InventoryPageSteps() {
        this.page = page(InventoryPage.class);
    }

    public int addAllInventoryToCart() {
        ElementsCollection collection = page.inventoryItems;
        int collectionLength = collection.size();
        for (SelenideElement invItem: collection) {
            page.getElementInnerButton(invItem).click();
        }
        return collectionLength;
    }
    public void addRandomItemToCart() {
        ElementsCollection collection = page.inventoryItems;
        Random rnd = new Random();
        int i = rnd.nextInt(collection.size());
        page.getElementInnerButton(collection.get(i)).click();
    }
    public void goToCart() {
        page.cartButton.click();
    }
    public void openInventoryItemByName(String itemName) {
        page.getItemDetailsByName(itemName).click();
    }
    public void checkShoppingBadgeChanging() {
        ElementsCollection collection = page.inventoryItems;
        int count = 0;
        for (SelenideElement invItem: collection) {
            page.getElementInnerButton(invItem).click();
            count++;
            page.shoppingBadge.shouldBe(visible).shouldHave(exactText(String.valueOf(count)));
        }
    }
}
