package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.element;

public class CheckoutStepTwoPage extends BasePage {
    public CheckoutStepTwoPage() {
        super();
    }
    @FindBy(how = How.XPATH, using = "//button[@id='finish']")
    public SelenideElement finishButton;
}
