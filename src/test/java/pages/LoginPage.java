package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage
{
    WebDriver driver;

By username = By.id("login-email");
By password = By.id("login-password");
By loginBtn = By.xpath("//button[contains(text(),'Login')]");

public LoginPage(WebDriver driver) {
    this.driver = driver;

}

public void enterUsername(String user) {
    driver.findElement(username).sendKeys(user);
}

public void enterPassword(String pass) {
    driver.findElement(password).sendKeys(pass);
}

public void clickLogin() {
    driver.findElement(loginBtn).click();
}

public boolean validateDashboard() {
    return driver.getCurrentUrl().contains("dashboard");
}

public String getTitle(){
        return driver.getTitle();
    }
}
