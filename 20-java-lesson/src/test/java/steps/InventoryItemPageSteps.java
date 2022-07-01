package steps;

import pages.InventoryItemPage;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;

public class InventoryItemPageSteps {
    InventoryItemPage page;

    public InventoryItemPageSteps() {
        this.page = new InventoryItemPage();
    }

    public void checkInventoryItemIsOpenedAndShown() {
        page.getInventoryItemContainer().shouldBe(visible).shouldBe(enabled);
    }
}
