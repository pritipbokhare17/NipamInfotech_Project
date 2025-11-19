package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerPage
{
    WebDriver driver;

By customerTab = By.xpath("//a[contains(text(),'Customer')]");
By addCustomerBtn = By.xpath("//button[contains(text(),'Add Customer')]");
By customerName = By.id("customerName");
By saveBtn = By.xpath("//button[contains(text(),'Save')]");
By toastMsg = By.className("Toastify__toast-body");

public CustomerPage(WebDriver driver){
    this.driver = driver;
}

public void openCustomerTab(){
    driver.findElement(customerTab).click();
}

public void clickAddCustomer(){
    driver.findElement(addCustomerBtn).click();
}

public void enterCustomerName(String name){
    driver.findElement(customerName).sendKeys(name);
}

public void clickSave(){
    driver.findElement(saveBtn).click();
}

public String getToastMsg(){
    return driver.findElement(toastMsg).getText();
}
}
