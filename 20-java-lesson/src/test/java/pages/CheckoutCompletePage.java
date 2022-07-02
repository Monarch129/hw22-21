package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.element;

public class CheckoutCompletePage extends BasePage {
    public CheckoutCompletePage() {
        super();
    }
    @FindBy(how = How.NAME, using = "back-to-products")
    public SelenideElement backToProductsButton;
}
