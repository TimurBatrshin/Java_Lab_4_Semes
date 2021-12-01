package ru.itis.test.helpers;

import org.openqa.selenium.By;
import ru.itis.test.data.MyAddress;

public class AddAddressHelper extends HelperBase {
    public AddAddressHelper(ApplicationManager manager) {
        super(manager);
    }

    public void addMyAddress(MyAddress myAddress) {
        driver.get("https://www.adidas.ru/my-account");
        driver.findElement(By.id("ACCOUNT")).click();
        driver.findElement(By.linkText("Сохраненные адреса")).click();
        driver.findElement(By.xpath("//div[@id='app']/div/div/div/div/div/div[3]/div/div[2]/div/div/div/div[2]/div/div/div")).click();
        driver.findElement(By.name("firstName")).click();
        driver.findElement(By.name("firstName")).clear();
        driver.findElement(By.name("firstName")).sendKeys(myAddress.getFirstName());
        applicationManager.getAddressHelperAssert().setFirstName(driver.findElement(By.name("firstName")).getAttribute("value"));
        driver.findElement(By.name("lastName")).click();
        driver.findElement(By.name("lastName")).clear();
        driver.findElement(By.name("lastName")).sendKeys(myAddress.getLastName());
        applicationManager.getAddressHelperAssert().setLastName(driver.findElement(By.name("lastName")).getAttribute("value"));
        driver.findElement(By.name("city")).click();
        driver.findElement(By.name("city")).clear();
        driver.findElement(By.name("city")).sendKeys(myAddress.getCity());
        applicationManager.getAddressHelperAssert().setCity(driver.findElement(By.name("city")).getAttribute("value"));
        driver.findElement(By.name("zipcode")).click();
        driver.findElement(By.name("zipcode")).clear();
        driver.findElement(By.name("zipcode")).sendKeys(myAddress.getZipCode());
        driver.findElement(By.name("address1")).click();
        driver.findElement(By.name("address1")).clear();
        driver.findElement(By.name("address1")).sendKeys(myAddress.getAddress1());
        driver.findElement(By.name("houseNumber")).click();
        driver.findElement(By.name("houseNumber")).clear();
        driver.findElement(By.name("houseNumber")).sendKeys(myAddress.getHouseNumber());
        driver.findElement(By.name("apartmentNumber")).click();
        driver.findElement(By.name("apartmentNumber")).clear();
        driver.findElement(By.name("apartmentNumber")).sendKeys(myAddress.getApartmentNumber());
        driver.findElement(By.name("phoneNumber")).click();
        driver.findElement(By.name("phoneNumber")).clear();
        driver.findElement(By.name("phoneNumber")).sendKeys(myAddress.getPhoneNumber());
        driver.findElement(By.xpath("//div[@id='modal-root']/div/div/div/div[2]/form/div/button/span")).click();
    }
}
