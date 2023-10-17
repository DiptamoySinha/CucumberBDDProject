package PageObjects;

import freemarker.cache.WebappTemplateLoader;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AdminPage extends BasePage{

    public AdminPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(css = "ul.nav-sidebar > li:nth-child(4)")
    WebElement customerMenu;

    @FindBy(css = "ul.nav-sidebar > li:nth-child(4) ul.nav-treeview > li")
    WebElement customerMenu_customerItem;

    @FindBy(css = "form a")
    public WebElement addNewCustomerButton;

    @FindBy(css = "input[name=\"Email\"]")
    WebElement emailInput;

    @FindBy(css = "input[name=\"Password\"]")
    WebElement passwordInput;

    @FindBy(css = "input[name=\"FirstName\"]")
    WebElement firstNameInput;

    @FindBy(css = "input[name=\"LastName\"]")
    WebElement lastNameInput;

    @FindBy(css = "input[name=\"Gender\"][value=\"M\"]")
    WebElement genderMaleRedioButton;

    @FindBy(css = "button[name=\"save\"]")
    WebElement SaveButton;

    @FindBy(css = ".alert-success")
    WebElement alertMessage;

    @FindBy(css = "input[name=\"SearchEmail\"]")
    WebElement searchEmailInput;

    @FindBy(css = "input[name=\"SearchFirstName\"]")
    WebElement searchFirstName;

    @FindBy(css = "button[id=\"search-customers\"]")
    WebElement searchButton;

    @FindBy(css = "tbody td:nth-child(2)")
    List<WebElement> emailColumn;

    @FindBy(css = "tbody td:nth-child(3)")
    List<WebElement> nameColumn;

    @FindBy(linkText = "Logout")
    WebElement logout_button;

    public String getTitle()
    {
//        boolean a = logout_button.isDisplayed();
        return  driver.getTitle();
    }

    public void clickLogout()
    {
        logout_button.click();
    }

    public void clickOnCustomerMenu()
    {
        customerMenu.click();
    }

    public void clickOnCustomerMenuItem()
    {
        customerMenu_customerItem.click();
    }

    public void clickOnAddNewCustomerButton()
    {
        addNewCustomerButton.click();
    }

    public void setEmailInput(String email)
    {
        emailInput.sendKeys(email);
    }

    public void setPasswordInput(String password)
    {
        passwordInput.sendKeys(password);
    }

    public void setFirstNameInput(String firstName)
    {
        firstNameInput.sendKeys(firstName);
    }

    public void setLastNameInput(String lastName)
    {
        lastNameInput.sendKeys(lastName);
    }

    public void setGenderMaleRadioButton()
    {
        genderMaleRedioButton.click();
    }

    public void clickSaveButton()
    {
        SaveButton.click();
    }

    public String getAlertMessage()
    {
        return alertMessage.getText();
    }

    public void setSearchEmailInput(String email)
    {
        searchEmailInput.sendKeys(email);
    }

    public void setSearchFirstName(String firstName)
    {
        searchFirstName.sendKeys(firstName);
    }

    public void clickOnSearchButton() {
        searchButton.click();
    }

    public boolean findEmailInTheColumn(String expectedEmail)
    {
        int len = emailColumn.size();
        System.out.printf("table has %d data", len);
        for(int i=0;i<len;i++)
        {
            String actualEmail = emailColumn.get(i).getText();
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", emailColumn.get(i));
            System.out.println(actualEmail);
            if(actualEmail.equals(expectedEmail))
            {
                return true;
            }
        }
        return false;
    }

    public boolean findFirstNameInTheColumn(String firstName)
    {
        int len = nameColumn.size();
        System.out.printf("table has %d data", len);
        for(int i=0;i<len;i++)
        {
            String actualname = nameColumn.get(i).getText();
            actions.moveToElement(nameColumn.get(i));
            System.out.println(actualname);
            if(actualname.contains(firstName))
            {
                return true;
            }
        }
        return false;
    }




}
