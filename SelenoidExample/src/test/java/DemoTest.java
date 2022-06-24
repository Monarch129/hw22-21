import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utils.User;
import utils.UserNames;

import static com.codeborne.selenide.Selenide.*;

public class DemoTest {

    private final String url = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";

    @Test
    public void checkUserNameAfterLogin() {
        for (UserNames userName:UserNames.values()) {
            open(url);
            loginToBankWithPerson(userName);
            element(By.cssSelector("strong .ng-binding")).shouldBe(Condition.visible)
                    .shouldHave(Condition.exactText(userName.getUserName()));
        }
    }

    @Test
    public void checkAddNewCustomer() {
        User newUser = new User("Petrov", "Petr", "255444");
        open(url);
        element(By.xpath("//button[@ng-click=\"manager()\"]")).click();
        element(By.xpath("//button[@ng-click=\"addCust()\"]")).click();
        element(By.xpath("//input[@ng-model=\"fName\"]")).setValue(newUser.getFirstName());
        element(By.xpath("//input[@ng-model=\"lName\"]")).setValue(newUser.getLastName());
        element(By.xpath("//input[@ng-model=\"postCd\"]")).setValue(newUser.getPostCode());
        element(By.xpath("//button[@type=\"submit\"]")).shouldBe(Condition.visible).click();
        element(By.cssSelector(".home")).click();
        loginToBankWithPerson(newUser);
        element(By.cssSelector("strong .ng-binding")).shouldBe(Condition.visible)
                .shouldHave(Condition.exactText(newUser.getFirstName() + " " + newUser.getLastName()));
    }

    @Test
    public void checkSuccessfullDepositAmount() {
        open(url);
        loginToBankWithPerson(UserNames.HERMIONE_GRANGER);
        element(By.xpath("//button[@ng-click=\"deposit()\"]")).click();
        element(By.cssSelector("input")).shouldBe(Condition.visible).setValue("1000").pressEnter();
        element(By.xpath("//span[@ng-show=\"message\"]")).shouldHave(Condition.exactText("Deposit Successful"));
    }

    private void loginToBankWithPerson(UserNames user) {
        element(By.xpath("//button[@ng-click=\"customer()\"]")).click();
        element(By.xpath("//select[@name=\"userSelect\"]")).shouldBe(Condition.visible).click();
        element(By.xpath("//option[text()=\"" + user.getUserName() + "\"]")).click();
        element(By.xpath("//button[@type=\"submit\"]")).shouldBe(Condition.visible).click();
    }

    private void loginToBankWithPerson(User user) {
        element(By.xpath("//button[@ng-click=\"customer()\"]")).click();
        element(By.xpath("//select[@name=\"userSelect\"]")).shouldBe(Condition.visible).click();
        element(By.xpath("//option[text()=\"" + user.getFirstName() + " " + user.getLastName() + "\"]")).click();
        element(By.xpath("//button[@type=\"submit\"]")).shouldBe(Condition.visible).click();
    }
}
