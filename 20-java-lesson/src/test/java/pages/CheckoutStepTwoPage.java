package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.element;

public class CheckoutStepTwoPage extends BasePage {
    public CheckoutStepTwoPage() {
        super();
    }
    public SelenideElement getFinishButton() {
        return element(By.xpath("//button[@id='finish']"));
    }
}
