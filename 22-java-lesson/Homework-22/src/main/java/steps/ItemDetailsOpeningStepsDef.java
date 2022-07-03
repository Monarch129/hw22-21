package steps;

import io.cucumber.java.ru.*;
import pages.InventoryItemPage;
import pages.InventoryPage;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class ItemDetailsOpeningStepsDef {

    InventoryPage inventoryPage;
    InventoryItemPage inventoryItemPage;

    public ItemDetailsOpeningStepsDef() {
        inventoryPage = page(InventoryPage.class);
        inventoryItemPage = page(InventoryItemPage.class);
    }

    @Когда("Пользователь нажимает на название товара {string}")
    public void userClicksOnItemName(String itemName) {
        inventoryPage.getItemDetailsByName(itemName).click();
    }
    @Тогда("Открывается карточка товара")
    public void checkIfItemDetailsAreOpened() {
        inventoryItemPage.inventoryItemContainer.shouldBe(visible).shouldBe(enabled);
    }
}
