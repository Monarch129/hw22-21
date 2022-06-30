package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.element;
import static com.codeborne.selenide.Selenide.elements;
import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.cssSelector;

public class CartPage extends BasePage {
    private static String pageUrl = "";
    public CartPage() {
        super(pageUrl);
    }

    public ElementsCollection getCartItems() {
        return elements(className("cart_item"));
    }
    public SelenideElement getCheckoutButton() {
        return element(By.xpath("//button[@id='checkout']"));
    }
    public SelenideElement getElementRemoveButton(SelenideElement cartItem) {
        return cartItem.find(cssSelector("button.cart_button"));
    }
}
