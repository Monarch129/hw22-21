package steps;

import pages.CheckoutStepOnePage;

import static com.codeborne.selenide.Selenide.page;

public class CheckoutStepOnePageSteps {
    CheckoutStepOnePage page;

    public CheckoutStepOnePageSteps() {
        page = page(CheckoutStepOnePage.class);
    }

    public void fillCheckoutInfo(String fName, String lName, String zip) {
        page.firstNameInput.setValue(fName);
        page.lastNameInput.setValue(lName);
        page.zipcodeInput.setValue(zip);
        page.continueButton.click();
    }
}
