package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.element;
import static com.codeborne.selenide.Selenide.elements;
import static org.openqa.selenium.By.*;

public class InventoryPage extends BasePage{
    private static String pageUrl = "";
    public InventoryPage() {
        super(pageUrl);
    }

    public SelenideElement getCartButton(){
        return element(className("shopping_cart_link"));
    }
    public ElementsCollection getInventoryItems() {
        return elements(className("inventory_item"));
    }

    public SelenideElement getElementInnerButton(SelenideElement el) {
        return el.find(cssSelector("button"));
    }

    public SelenideElement getShoppingBadge() {
        return element(xpath("//span[contains(@class, 'shopping_cart_badge')]"));
    }
    public SelenideElement getItemDetailsByName(String invItemName) {
        return element(By.xpath("//div[@class='inventory_item_name' and text()='"+invItemName+"']"));
    }
}
