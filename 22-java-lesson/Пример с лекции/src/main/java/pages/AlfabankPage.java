package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class AlfabankPage {

    public static AlfabankPage alfabankPage() {
        return page(AlfabankPage.class);
    }

    @FindBy(xpath = "(.//input[@placeholder='Я ищу'])[1]")
    public SelenideElement searchInput;

    @FindBy(xpath = "(//span[text()='Найти'])[1]")
    public SelenideElement searchBtn;

    @FindBy(css = ".b-head__counter")
    public SelenideElement resultCounter;
}
