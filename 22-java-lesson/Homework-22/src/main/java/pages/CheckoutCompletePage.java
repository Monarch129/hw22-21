package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CheckoutCompletePage {
    @FindBy(how = How.NAME, using = "back-to-products")
    public SelenideElement backToProductsButton;
}
