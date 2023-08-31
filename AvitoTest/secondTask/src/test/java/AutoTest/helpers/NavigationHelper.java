package AutoTest.helpers;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {
    private String baseUrl;

    public NavigationHelper(ApplicationManager manager, String baseUrl) {
        super(manager);
        this.baseUrl = baseUrl;
    }

    public void openHomePage() {
        driver.get("https://www.avito.ru/nikel/knigi_i_zhurnaly/domain-driven_design_distilled_vaughn_vernon_2639542363");
    }

    public void clickAddFavoritesButton() {
        driver.findElement(By.xpath("//div[@id='app']/div/div[3]/div/div/div[2]/div[3]/div/div/div/div[3]/div/div/div/div/button/span")).click();
        driver.findElement(By.cssSelector("svg[name=\"favorites-filled\"] > path")).click();
    }

    public void openFavoritesPage() {
        driver.get("https://www.avito.ru/favorites");
    }

    public void openSearchPage() {
        driver.get("https://www.avito.ru/");
        driver.findElement(By.xpath("//div[@id='app']/div/div[3]/div/div/div/div[3]/div/div/div/div/div/button/span/span/div/div/span")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Авито Польза'])[3]/following::strong[1]")).click();
    }

    public void addProduct() {
        driver.findElement(By.xpath("//div[@id='app']/div/div[4]/div/div[2]/div[2]/div[2]/div[3]/div/div/div[2]/div/div/div/div/div")).click();
        driver.findElement(By.xpath("//div[@id='app']/div/div[4]/div/div[2]/div[2]/div[2]/div[3]/div/div/div[2]/div[2]/div/div/div/div")).click();
        driver.findElement(By.xpath("//div[@id='app']/div/div[4]/div/div[2]/div[2]/div[2]/div[3]/div/div/div[2]/div[3]/div/div/div/div")).click();
    }

    public void deleteProduct() {
        driver.findElement(By.xpath("//div[@id='app']/div/div[4]/div/div/favorite-items-list/div/div/div/div[2]/div/div/div/div[2]/div/div")).click();
        driver.findElement(By.xpath("//div[@id='app']/div/div[4]/div/div/favorite-items-list/div/div/div/div[2]/div[2]/div/div/div[2]/div/div")).click();
        driver.findElement(By.xpath("//div[@id='app']/div/div[4]/div/div/favorite-items-list/div/div/div/div[2]/div[3]/div/div/div[2]/div/div")).click();
    }
}
