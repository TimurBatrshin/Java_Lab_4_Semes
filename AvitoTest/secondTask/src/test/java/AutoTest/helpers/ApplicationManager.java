package AutoTest.helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.fail;

public class ApplicationManager {
    private final WebDriver driver;
    private final StringBuffer verificationErrors;
    JavascriptExecutor js;
    private final NavigationHelper navigationHelper;
    private static ThreadLocal<ApplicationManager> app = null;

    public ApplicationManager() {
        System.setProperty("webdriver.chrome.driver", "D:\\Java_Lab_4_Sem\\AvitoTest\\secondTask\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        String baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        js = (JavascriptExecutor) driver;
        verificationErrors = new StringBuffer();
        navigationHelper = new NavigationHelper(this, baseUrl);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
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
}
