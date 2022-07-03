package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.element;

public class CheckoutStepOnePage extends BasePage {
    public CheckoutStepOnePage() {
        super();
    }
    @FindBy(how = How.XPATH, using = "//input[@id='first-name']")
    public SelenideElement firstNameInput;
    @FindBy(how = How.XPATH, using = "//input[@id='last-name']")
    public SelenideElement lastNameInput;
    @FindBy(how = How.XPATH, using = "//input[@id='postal-code']")
    public SelenideElement zipcodeInput;
    @FindBy(how = How.XPATH, using = "//input[@id='continue']")
    public SelenideElement continueButton;
}
