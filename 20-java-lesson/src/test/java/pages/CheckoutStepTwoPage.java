package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.element;

public class CheckoutStepTwoPage extends BasePage {
    private static String pageUrl = "";
    public CheckoutStepTwoPage() {
        super(pageUrl);
    }

    public SelenideElement getFinishButton() {
        return element(By.xpath("//button[@id='finish']"));
    }
}
