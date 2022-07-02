package steps;

import pages.CheckoutStepTwoPage;

import static com.codeborne.selenide.Selenide.page;

public class CheckoutStepTwoPageSteps {
    CheckoutStepTwoPage page;

    public CheckoutStepTwoPageSteps() {
        this.page = page(CheckoutStepTwoPage.class);
    }

    public void finishOrder() {
        page.finishButton.click();
    }
}
