package steps;

import pages.CheckoutStepOnePage;

public class CheckoutStepOnePageSteps {
    CheckoutStepOnePage page;

    public CheckoutStepOnePageSteps() {
        page = new CheckoutStepOnePage();
    }

    public void fillCheckoutInfo(String fName, String lName, String zip) {
        page.firstNameInput().setValue(fName);
        page.lastNameInput().setValue(lName);
        page.zipcodeInput().setValue(zip);
        page.getContinueButton().click();
    }
}
