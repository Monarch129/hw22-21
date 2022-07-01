package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.element;

public class CheckoutCompletePage extends BasePage {
    public CheckoutCompletePage() {
        super();
    }
    public SelenideElement backToProductsButton() {
        return element(By.name("back-to-products"));
    }
}
