package ru.itis.test.helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.itis.test.assertHelper.AddressHelperAssert;
import ru.itis.test.assertHelper.AuthHelperAssert;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class ApplicationManager {
    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors;
    JavascriptExecutor js;
    private boolean acceptNextAlert = true;

    private AddAddressHelper addAddress;
    private LoginHelper loginHelper;
    private NavigationHelper navigationHelper;
    private EditAddressHelper editAddressHelper;

    private AuthHelperAssert authHelper;
    private AddressHelperAssert addressHelperAssert;

    private static ThreadLocal<ApplicationManager> app = null;

    public ApplicationManager() {
        System.setProperty("webdriver.chrome.driver", "D:\\Games\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        js = (JavascriptExecutor) driver;
        verificationErrors = new StringBuffer();
        addAddress = new AddAddressHelper(this);
        loginHelper = new LoginHelper(this);
        navigationHelper = new NavigationHelper(this, baseUrl);
        editAddressHelper = new EditAddressHelper(this);
        authHelper = new AuthHelperAssert(this);
        addressHelperAssert = new AddressHelperAssert(this);

    }

    public WebDriver getDriver() {
        return driver;
    }

    public AddAddressHelper getAddAddress() {
        return addAddress;
    }

    public LoginHelper getLoginHelper() {
        return loginHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public EditAddressHelper getEditAddressHelper() {
        return editAddressHelper;
    }

    public AuthHelperAssert getAuthHelper() {
        return authHelper;
    }

    public AddressHelperAssert getAddressHelperAssert() {
        return addressHelperAssert;
    }

    public void stop() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    public static ApplicationManager getInstance() {
        if (app == null) {
            app = new ThreadLocal<>();
            ApplicationManager newInstance = new ApplicationManager();
            newInstance.navigationHelper.openHomePage();
            app.set(newInstance);
        }
        return app.get();
    }

    public boolean checkLogin() {
        return driver.getCurrentUrl().equals("https://www.adidas.ru/my-account");
    }


}
