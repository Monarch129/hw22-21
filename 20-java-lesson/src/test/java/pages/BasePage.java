package pages;

import static com.codeborne.selenide.Selenide.open;

public class BasePage {
    private String pageUrl;
    public BasePage(String url) {
        this.pageUrl = url;
    }

    public void openPage(){
        open(pageUrl);
    }
}
