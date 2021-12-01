package ru.itis.test.helpers;

public class NavigationHelper extends HelperBase{
    private String baseUrl;

    public NavigationHelper(ApplicationManager manager, String baseUrl) {
        super(manager);
        this.baseUrl = baseUrl;
    }


    public void openHomePage() {
        driver.get("https://www.adidas.ru/account-login");
    }

    public void openBookPage(){
        driver.get("https://www.adidas.ru/my-account/address-book");
    }
}
