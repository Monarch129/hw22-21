package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static org.openqa.selenium.By.cssSelector;

public class CartPage {
    @FindBy(how = How.CLASS_NAME, using = "cart_item")
    public ElementsCollection cartItems;
    @FindBy(how = How.XPATH, using = "//button[@id='checkout']")
    public SelenideElement checkoutButton;
    public SelenideElement getElementRemoveButton(SelenideElement cartItem) {
        return cartItem.find(cssSelector("button.cart_button"));
    }
}
