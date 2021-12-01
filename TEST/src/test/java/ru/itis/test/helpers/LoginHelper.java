package ru.itis.test.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import ru.itis.test.data.AccountData;

public class LoginHelper extends HelperBase {



    public LoginHelper(ApplicationManager manager) {
        super(manager);
    }


    public void login(AccountData user) throws InterruptedException {
        driver.findElement(By.id("login-email")).click();
        driver.findElement(By.id("login-email")).clear();
        driver.findElement(By.id("login-email")).sendKeys(user.getUsername());
        applicationManager.getAuthHelper().setUsername(driver.findElement(By.id("login-email")).getAttribute("value"));
        driver.findElement(By.id("login-password")).click();
        driver.findElement(By.id("login-password")).clear();
        driver.findElement(By.id("login-password")).sendKeys(user.getPassword());
        Thread.sleep(5000);
        driver.findElement(By.id("login-password")).sendKeys(Keys.ENTER);
        applicationManager.getAuthHelper().setPassword(driver.findElement(By.id("login-password")).getAttribute("value"));



    }

    public void logout(){
        driver.findElement(By.id("ACCOUNT")).click();
        driver.findElement(By.linkText("Выйти")).click();
    }


}
