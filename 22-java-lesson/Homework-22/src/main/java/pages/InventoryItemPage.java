package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class InventoryItemPage {
    @FindBy(how = How.XPATH, using = "//button[@id='back-to-products']")
    public SelenideElement itemDetailBackButton;
    @FindBy(how = How.CLASS_NAME, using = "inventory_details_container")
    public SelenideElement inventoryItemContainer;
}
