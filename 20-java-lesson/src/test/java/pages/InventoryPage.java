package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.element;
import static com.codeborne.selenide.Selenide.elements;
import static org.openqa.selenium.By.*;

public class InventoryPage extends BasePage{
    public InventoryPage() {
        super();
    }
    @FindBy(how = How.CLASS_NAME, using = "shopping_cart_link")
    public SelenideElement cartButton;
    @FindBy(how = How.CLASS_NAME, using = "inventory_item")
    public ElementsCollection inventoryItems;
    @FindBy(how = How.XPATH, using = "//span[contains(@class, 'shopping_cart_badge')]")
    public SelenideElement shoppingBadge;
    public SelenideElement getItemDetailsByName(String invItemName) {
        return element(By.xpath(String.format("//div[@class='inventory_item_name' and text()='%s']", invItemName)));
    }
    public SelenideElement getElementInnerButton(SelenideElement el) {
        return el.find(cssSelector("button"));
    }
}
