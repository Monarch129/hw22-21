package steps;

import pages.CheckoutCompletePage;

public class CheckoutCompletePageSteps {
    CheckoutCompletePage page;
    public CheckoutCompletePageSteps() {
        this.page = new CheckoutCompletePage();
    }
    public void backToProducts() {
        page.backToProductsButton().click();
    }
}
