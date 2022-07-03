package steps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import pages.CartPage;
import pages.InventoryPage;

import static com.codeborne.selenide.Selenide.page;

public class AddingToCartStepsDef {
    InventoryPage inventoryPage;
    CartPage cartPage;
    private int countOfAddedItems = 0;

    public AddingToCartStepsDef() {
        this.inventoryPage = page(InventoryPage.class);
        this.cartPage = page(CartPage.class);
    }
    @Дано("Пользователь добавляет все товары в корзину")
    public void AddAllItemsInCart(){
        ElementsCollection collection = inventoryPage.inventoryItems;
        countOfAddedItems = collection.size();
        for (SelenideElement invItem: collection) {
            inventoryPage.getElementInnerButton(invItem).click();
        }
    }

    @Когда("Пользователь переходит в корзину")
    public void goToCart() {
        inventoryPage.cartButton.click();
    }
    @Тогда("Количество товаров в корзине совпадает с количеством добавленных товаров")
    public void checkAddedItemAppearsInBin(){
        cartPage.cartItems.shouldHave(CollectionCondition.size(countOfAddedItems));
    }
    @Дано("Пользователь добавляет {int}-й товар в корзину")
    public void addNthItemInCart(int number){
        inventoryPage.getElementInnerButton(inventoryPage.inventoryItems.get(number-1)).click();
    }
    @Тогда("Значение пузырька с количеством товаров меняется на {int}")
    public void checkShoppingBadgeValue(int number) {
        inventoryPage.shoppingBadge.shouldBe(Condition.visible).shouldHave(Condition.exactText(String.valueOf(number)));
    }

    @Когда("Пользователь удаляет все товары из корзины нажатием на кнопку Remove")
    public void clickAllRemoveBtnInCart() {
        for (SelenideElement cartItem: cartPage.cartItems) {
            cartPage.getElementRemoveButton(cartItem).click();
        }
    }
}
