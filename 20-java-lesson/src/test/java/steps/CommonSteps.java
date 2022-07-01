package steps;

import com.codeborne.selenide.Selenide;
import static com.codeborne.selenide.Selenide.open;

public class CommonSteps {
    public void openUrl(String url){
        open(url);
    }
    public void clearCookiesAndStorage(){
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }
}
