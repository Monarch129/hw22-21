package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.element;
import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.xpath;

public class InventoryItemPage extends BasePage {
    private static String pageUrl = "";
    public InventoryItemPage() {
        super(pageUrl);
    }

    public SelenideElement getItemDetailBackButton() {
        return element(xpath("//button[@id='back-to-products']"));
    }
    public SelenideElement getInventoryItemContainer() {
        return element(className("inventory_details_container"));
    }
}
