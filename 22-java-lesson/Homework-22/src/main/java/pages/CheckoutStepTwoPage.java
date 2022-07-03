package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CheckoutStepTwoPage {
    @FindBy(how = How.XPATH, using = "//button[@id='finish']")
    public SelenideElement finishButton;
}
