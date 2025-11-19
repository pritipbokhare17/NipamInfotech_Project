package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class PunchPage
{
    WebDriver driver;

By punchInBtn = By.xpath("//button[contains(text(),'Punch In')]");
By toastMsg = By.className("Toastify__toast-body");

public PunchPage(WebDriver driver){
    this.driver = driver;
}

public void clickPunchIn(){
    driver.findElement(punchInBtn).click();
}

public String getToastMessage(){
    return driver.findElement(toastMsg).getText();
}
}
