package steps;

import pages.CheckoutStepTwoPage;

public class CheckoutStepTwoPageSteps {
    CheckoutStepTwoPage page;

    public CheckoutStepTwoPageSteps() {
        this.page = new CheckoutStepTwoPage();
    }

    public void finishOrder() {
        page.getFinishButton().click();
    }
}
