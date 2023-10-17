package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(css = "input[name=\"Email\"]")
    WebElement email_input;

    @FindBy(css = "input[name=\"Password\"]")
    WebElement password_input;

    @FindBy(css = "button[type=\"submit\"]")
    WebElement submit_button;

    public void setEmail_input(String email)
    {
        email_input.clear();
        this.email_input.sendKeys(email);
    }

    public void setPassword_input(String password) {
        password_input.clear();
        password_input.sendKeys(password);
    }

    public void clickSubmitButton()
    {
        submit_button.click();
    }
}
