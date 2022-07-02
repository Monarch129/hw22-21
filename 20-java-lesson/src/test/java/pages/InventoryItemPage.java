package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.element;
import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.xpath;

public class InventoryItemPage extends BasePage {
    public InventoryItemPage() {
        super();
    }
    @FindBy(how = How.XPATH, using = "//button[@id='back-to-products']")
    public SelenideElement itemDetailBackButton;
    @FindBy(how = How.CLASS_NAME, using = "inventory_details_container")
    public SelenideElement inventoryItemContainer;
}
