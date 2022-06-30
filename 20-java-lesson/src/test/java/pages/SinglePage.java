package pages;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.*;

public class SinglePage {
    String baseurl = "https://www.saucedemo.com/";
    String cartUrl = "https://www.saucedemo.com/cart.html";
    public SinglePage() {
        openUrl(baseurl);
    }
    public void goToCart(){
        openUrl(cartUrl);
    }
    // Login elements
    public SelenideElement userNameInput() {
        return element(By.name("user-name"));
    }
    public SelenideElement userPasswordInput() {
        return element(By.name("password"));
    }
    public SelenideElement loginButton() {
        return element(By.name("login-button"));
    }
    public ElementsCollection getInventoryItems() {
        return elements(className("inventory_item"));
    }
    public SelenideElement getElementInnerButton(SelenideElement el){
        return el.find(cssSelector("button"));
    }

    void openUrl(String s) {
        open(s);
    }

    public ElementsCollection getCartItems() {
        return elements(className("cart_item"));
    }

    public SelenideElement getShoppingBadge() {
        return element(By.xpath("//span[contains(@class, 'shopping_cart_badge')]"));
    }

    public SelenideElement getCheckoutButton() {
        return element(By.xpath("//button[@id='checkout']"));
    }

    public SelenideElement firstNameInput() {
        return element(By.xpath("//input[@id='first-name']"));
    }

    public SelenideElement lastNameInput() {
        return element(By.xpath("//input[@id='last-name']"));
    }

    public SelenideElement zipcodeInput() {
        return element(By.xpath("//input[@id='postal-code']"));
    }

    public SelenideElement getContinueButton() {
        return element(By.xpath("//input[@id='continue']"));
    }

    public SelenideElement getFinishButton() {
        return element(By.xpath("//button[@id='finish']"));
    }

    public SelenideElement getItemDetailsByName(String invItemName) {
        return element(By.xpath("//div[@class='inventory_item_name' and text()='"+invItemName+"']"));
    }

    public SelenideElement getItemDetailBackButton() {
        return element(xpath("//button[@id='back-to-products']"));
    }

    public SelenideElement getElementRemoveButton(SelenideElement cartItem) {
        return cartItem.find(cssSelector("button.cart_button"));
    }

    public void clearCookiesAndStorage() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }


}

