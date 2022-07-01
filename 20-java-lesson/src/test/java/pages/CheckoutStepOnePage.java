package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.element;

public class CheckoutStepOnePage extends BasePage {
    public CheckoutStepOnePage() {
        super();
    }
    public SelenideElement firstNameInput() {
        return element(By.xpath("//input[@id='first-name']"));
    }
    public SelenideElement lastNameInput() {
        return element(By.xpath("//input[@id='last-name']"));
    }
    public SelenideElement zipcodeInput() {
        return element(By.xpath("//input[@id='postal-code']"));
    }
    public SelenideElement getContinueButton() {
        return element(By.xpath("//input[@id='continue']"));
    }
}
