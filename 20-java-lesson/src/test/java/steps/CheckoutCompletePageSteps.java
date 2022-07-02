package steps;

import pages.CheckoutCompletePage;

import static com.codeborne.selenide.Selenide.page;

public class CheckoutCompletePageSteps {
    CheckoutCompletePage page;
    public CheckoutCompletePageSteps() {
        this.page = page(CheckoutCompletePage.class);
    }
    public void backToProducts() {
        page.backToProductsButton.click();
    }
}
