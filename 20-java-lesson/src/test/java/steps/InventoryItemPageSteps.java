package steps;

import pages.InventoryItemPage;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class InventoryItemPageSteps {
    InventoryItemPage page;

    public InventoryItemPageSteps() {
        this.page = page(InventoryItemPage.class);
    }

    public void checkInventoryItemIsOpenedAndShown() {
        page.inventoryItemContainer.shouldBe(visible).shouldBe(enabled);
    }
}
