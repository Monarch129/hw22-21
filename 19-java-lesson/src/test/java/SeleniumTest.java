import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Test;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;

class SeleniumTest {
    public static WebDriver driver;

    @BeforeEach
    void InitializeDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\bin\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        String baseUrl = "https://github.com/";
        driver.get(baseUrl);
    }

    @Test
    void CheckInputEmail() {
        String inputPath = "//input[@name='user_email']";
        String expectedEmail = "pua18013@xcoxc.com";

        WebElement inputElement = driver.findElement(By.xpath(inputPath));
        inputElement.sendKeys(expectedEmail);
        String actualEmail = inputElement.getAttribute("value");

        assertEquals(expectedEmail, actualEmail);
    }

    @Test
    void CheckButtonSignUp() {
        String expectedUrl = "https://github.com/signup?user_email=&source=form-home-signup";

        WebElement buttonElement = driver.findElement(By.className("btn-mktg"));
        buttonElement.click();
        String actualUrl = driver.getCurrentUrl();

        assertEquals(expectedUrl, actualUrl);
    }

    @Nested
    public class PositiveTests {
        @Test
        void CheckDirectToYoutubeLink() {
            String youtubeButtonPath = "a[href='https://www.youtube.com/github']";
            String expectedUrl = "https://www.youtube.com/github";

            WebElement youtubeElement = driver.findElement(By.cssSelector(youtubeButtonPath));
            youtubeElement.click();
            String actualUrl = driver.getCurrentUrl();

            assertEquals(expectedUrl, actualUrl);
        }

        @Test
        void CheckDirectToCareersLink() {
            String careersLink = "a[href='/about/careers']";
            String expectedUrl = "https://github.com/about/careers";

            WebElement youtubeElement = driver.findElement(By.cssSelector(careersLink));
            youtubeElement.click();
            String actualUrl = driver.getCurrentUrl();

            assertEquals(expectedUrl, actualUrl);
        }

        @Test
        void CheckSignInButton() {
            String expectedUrl = "https://github.com/login?return_to=https%3A%2F%2Fgithub.com%2Fsignup%3Fuser_email%3D%26source%3Dform-home-signup";

            WebElement buttonElement = driver.findElement(By.className("btn-mktg"));
            buttonElement.click();
            WebElement signInElement = driver.findElement(By.xpath("//a[contains(text(),'Sign in')]"));
            signInElement.click();
            String actualUrl = driver.getCurrentUrl();

            assertEquals(expectedUrl, actualUrl);
        }

        @Test
        void CheckSearchField() {
            String searchPath = "//input[@placeholder='Search GitHub']";
            String expectedUrl = "https://github.com/search?q=commit&type=";

            WebElement searchElement = driver.findElement(By.xpath(searchPath));
            searchElement.sendKeys("commit" + "\n");
            String actualUrl = driver.getCurrentUrl();

            assertEquals(expectedUrl, actualUrl);
        }

        @Test
        void CheckAuthorization() {
            String userValue = "Ynettako";
            String passwordValue = "2pH7p9DW";
            String signInButton = "a[href='/login']";
            String expectedGreetingText = "The home for all developers";

            WebElement signInElement = driver.findElement(By.cssSelector(signInButton));
            signInElement.click();
            WebElement loginFieldElement = driver.findElement(By.xpath("//input[@id='login_field']"));
            loginFieldElement.sendKeys(userValue);
            WebElement passwordFieldElement = driver.findElement(By.xpath("//input[@id='password']"));
            passwordFieldElement.sendKeys(passwordValue);
            WebElement submitButtonElement = driver.findElement(By.xpath("//input[@value='Sign in']"));
            submitButtonElement.click();
            String greetingElement = driver.findElement(By.xpath("//h1[@class='h1 lh-condensed mb-2']")).getText();
            assertTrue(greetingElement.contains(expectedGreetingText));
        }

        @Test
        void CheckForgotPasswordButton() {
            String signInButton = "a[href='/login']";
            String passwordResetLink = "a[href='/password_reset']";
            String expectedUrl = "https://github.com/password_reset";

            WebElement signInElement = driver.findElement(By.cssSelector(signInButton));
            signInElement.click();
            WebElement passwordResetElement = driver.findElement(By.cssSelector(passwordResetLink));
            passwordResetElement.click();
            String actualUrl = driver.getCurrentUrl();

            assertEquals(expectedUrl, actualUrl);
        }
    }

    @Nested
    public class NegativeTests {
        @Test
        void CheckSignInWithInvalidCredentials() {
            String userValue = "Ynetako";
            String passwordValue = "2pH7p9DV";
            String signInButton = "a[href='/login']";
            String expectedInvalidCredentialsMessage = "Incorrect username or password.";

            WebElement signInElement = driver.findElement(By.cssSelector(signInButton));
            signInElement.click();
            WebElement loginFieldElement = driver.findElement(By.xpath("//input[@id='login_field']"));
            loginFieldElement.sendKeys(userValue);
            WebElement passwordFieldElement = driver.findElement(By.xpath("//input[@id='password']"));
            passwordFieldElement.sendKeys(passwordValue);
            WebElement submitButtonElement = driver.findElement(By.xpath("//input[@value='Sign in']"));
            submitButtonElement.click();
            String invalidCredentialsElement = driver.findElement(By.xpath("//div[@class='px-2']")).getText();

            assertEquals(expectedInvalidCredentialsMessage, invalidCredentialsElement);
        }

        @Test
        void CheckSignUpWithInvalidEmail() {
            String emailValue = "123456";
            String expectedMessage = "Email is invalid or already taken";
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));

            WebElement buttonElement = driver.findElement(By.className("btn-mktg"));
            buttonElement.click();
            WebElement emailFieldElement = driver.findElement(By.xpath("//input[@id='email']"));
            wait.until(ExpectedConditions.elementToBeClickable(emailFieldElement));
            emailFieldElement.sendKeys(emailValue);
            WebElement invalidEmailError = driver.findElement(By.xpath("//p[@id='email-err']"));
            String invalidEmailErrorMessage = wait.until(ExpectedConditions.elementToBeClickable(invalidEmailError))
                    .getText();

            assertEquals(expectedMessage, invalidEmailErrorMessage);
        }

        @Test
        void CheckSignUpWithTooLongEmail() {
            String checkingEmail = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@mail.ru";
            String expectedMessage = "Email is invalid or already taken";
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));

            WebElement buttonElement = driver.findElement(By.className("btn-mktg"));
            buttonElement.click();
            WebElement emailFieldElement = driver.findElement(By.xpath("//input[@id='email']"));
            wait.until(ExpectedConditions.elementToBeClickable(emailFieldElement));
            emailFieldElement.sendKeys(checkingEmail);
            WebElement invalidEmailError = driver.findElement(By.xpath("//p[@id='email-err']"));
            wait.until(ExpectedConditions.elementToBeClickable(invalidEmailError));
            String invalidEmailErrorMessage = invalidEmailError.getText();

            assertEquals(expectedMessage, invalidEmailErrorMessage);

        }
        @Test
        void CheckSignUpWithTooShortPassword() {
            String checkingEmail = "superuniquepost@hotpost.com";
            String checkingPassword = "pass";
            String expectedMessage = "Password is too short";
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));

            WebElement buttonElement = driver.findElement(By.className("btn-mktg"));
            buttonElement.click();
            WebElement emailFieldElement = driver.findElement(By.xpath("//input[@id='email']"));
            wait.until(ExpectedConditions.elementToBeClickable(emailFieldElement));
            emailFieldElement.sendKeys(checkingEmail);
            wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[contains(@class,'signup-continue-button') and not(@disabled)]"))
                    )
                    .click();
            WebElement passwordFieldElement = driver.findElement(By.xpath("//input[@id='password']"));
            wait.until(ExpectedConditions.elementToBeClickable(passwordFieldElement));
            passwordFieldElement.sendKeys(checkingPassword);
            String invalidPasswordErrorMessage = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//p[contains(@class, 'password-validity-summary-fail')]"))
                    )
                    .getText();

            assertEquals(expectedMessage, invalidPasswordErrorMessage);
        }
        @Test
        void CheckSignUpWithWeakPassword() {
            String checkingEmail = "superuniquepost@hotpost.com";
            String checkingPassword = "SuperPassword";
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));

            WebElement buttonElement = driver.findElement(By.className("btn-mktg"));
            buttonElement.click();
            WebElement emailFieldElement = driver.findElement(By.xpath("//input[@id='email']"));
            wait.until(ExpectedConditions.elementToBeClickable(emailFieldElement));
            emailFieldElement.sendKeys(checkingEmail);
            wait.until(ExpectedConditions.elementToBeClickable(
                            By.xpath("//button[contains(@class,'signup-continue-button') and not(@disabled)]"))
                    )
                    .click();
            WebElement passwordFieldElement = driver.findElement(By.xpath("//input[@id='password']"));
            wait.until(ExpectedConditions.elementToBeClickable(passwordFieldElement));
            passwordFieldElement.sendKeys(checkingPassword);

            WebElement continuButton = driver.findElement(
                    By.xpath("//button[contains(@class,'signup-continue-button') and contains(@data-optimizely-event, 'password')]"));

            assertTrue(!continuButton.isEnabled());
        }
    }

    @AfterEach
    void QuitWebDriver() {
        driver.quit();
    }
}