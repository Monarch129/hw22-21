package steps;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import pages.CartPage;

public class CartPageSteps {
    CartPage page;
    public CartPageSteps() {
        this.page = new CartPage();
    }
    public int getCartItemsCount() {
        ElementsCollection cart_collection = page.getCartItems();
        return cart_collection.size();
    }

    public void removeAllItems() {
        for (SelenideElement cartItem: page.getCartItems()) {
            page.getElementRemoveButton(cartItem).click();
        }
    }
    public void goToCheckout(){
        page.getCheckoutButton().click();
    }
    public void checkCountItems(int itemsAddedToCart) {
        int actualCartItemsCount = this.getCartItemsCount();
        Assertions.assertEquals(itemsAddedToCart, actualCartItemsCount);
    }
}
