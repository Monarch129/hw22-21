package steps;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import pages.CartPage;

import static com.codeborne.selenide.Selenide.page;

public class CartPageSteps {
    CartPage page;
    public CartPageSteps() {
        this.page = page(CartPage.class);
    }
    public int getCartItemsCount() {
        ElementsCollection cart_collection = page.cartItems;
        return cart_collection.size();
    }

    public void removeAllItems() {
        for (SelenideElement cartItem: page.cartItems) {
            page.getElementRemoveButton(cartItem).click();
        }
    }
    public void goToCheckout(){
        page.checkoutButton.click();
    }
    public void checkCountItems(int itemsAddedToCart) {
        int actualCartItemsCount = this.getCartItemsCount();
        Assertions.assertEquals(itemsAddedToCart, actualCartItemsCount);
    }
}
