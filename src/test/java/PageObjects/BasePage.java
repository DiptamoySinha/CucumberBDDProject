package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;

public class BasePage {
    public WebDriver driver;
    Actions actions;
    public BasePage(WebDriver driver)
    {
        this.driver = driver;
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }
}
