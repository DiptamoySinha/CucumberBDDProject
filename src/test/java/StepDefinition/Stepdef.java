package StepDefinition;

import PageObjects.AdminPage;
import PageObjects.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Stepdef {

    public static WebDriver driver;
    public static LoginPage loginPage;
    public static AdminPage adminPage;
    public static Logger logger;

    @BeforeStep
    public void beforeStep()
    {
        System.out.println("Before step is executed.....");
    }

    @Given("user Launch chrome browser")
    public void user_launch_chrome_browser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        logger = LogManager.getLogger(this.getClass());
        logger.info("SETUP1 IS EXECUTED");
        loginPage = new LoginPage(driver);
        adminPage = new AdminPage(driver);
    }

    @When("user open url {string}")
    public void user_open_url(String string) {
        driver.get(string);
        logger.info("%s - NAVIGATE TO URL".formatted(string));

    }

    @When("user enter email {string} and password {string}")
    public void user_enter_email_and_password(String email, String password) {
        loginPage.setEmail_input(email);
        loginPage.setPassword_input(password);
        logger.info("email %s and password %s is given".formatted(email, password));

    }

    @When("user click submit")
    public void user_click_submit() {
        loginPage.clickSubmitButton();
        logger.info("clicked on submit button");
    }

    @Then("page title should include {string}")
    public void page_title_should_include(String expectedTitle) {
        String currTitle = adminPage.getTitle();
        if(!currTitle.contains(expectedTitle))
        {
            Assert.fail("%s - is not included in Title".formatted(expectedTitle));
        }
        logger.info("VERIFIED PAGE TITLE with %s".formatted(expectedTitle));
    }

    @When("user click logout")
    public void user_click_logout() {
        adminPage.clickLogout();
        logger.info("ADMIN LOGOUT");

    }

    @Then("browser close")
    public void browser_close() {
        driver.close();
    }

    @When("user click on customers Menu")
    public void user_click_on_customers_menu() {
        adminPage.clickOnCustomerMenu();
        logger.info("CLICKED ON CUSTOMER MENU");
    }

    @When("click on customer menu item")
    public void click_on_customer_menu_item() {
        adminPage.clickOnCustomerMenuItem();
        logger.info("ADMIN LOGOUT");
    }

    @Then("user can view add new customer page")
    public void user_can_view_add_new_customer_page() {
        boolean isDisplayed = adminPage.addNewCustomerButton.isDisplayed();
        Assert.assertTrue(isDisplayed, "Add New Customer Button is not Displayed");
        adminPage.clickOnAddNewCustomerButton();
        logger.info("CLICKED ON ADD NEW CUSTOMER BUTTON");
    }

    @When("user enter customer details")
    public void user_enter_customer_details() {
        int a = (int) (Math.random() * 10);

        adminPage.setEmailInput("cs20" + a + "@gmail.com");
        adminPage.setPasswordInput("12345");
        adminPage.setFirstNameInput("Diptamoy");
        adminPage.setLastNameInput("Sinha");
        adminPage.setGenderMaleRadioButton();
        logger.info("ENTERED THE DETAILS OF THE CUSTOMER");
    }

    @When("click on save button")
    public void click_on_save_button() {
        adminPage.clickSaveButton();
        logger.info("CLICKED ON SAVE BUTTON AND ADDED THE CUSTOMER");
    }

    @Then("user can view confirmation message")
    public void user_can_view_confirmation_message() {
        String confirmationMessage = adminPage.getAlertMessage();
        System.out.println(confirmationMessage);
        Assert.assertTrue(confirmationMessage.contains("The new customer has been added successfully."));
        logger.info("VERIFIED THE CONFIRMATION MESSAGE");
    }



    @When("Enter Customer Email {string}")
    public void enterCustomerEmail(String email) {
        adminPage.setSearchEmailInput(email);
        logger.info("ENTERED THE EMAIL %s FOR SEARCHING THE CUSTOMER".formatted(email));
    }

    @When("Click On Search button")
    public void clickOnSearchButton() throws InterruptedException {
        adminPage.clickOnSearchButton();
        Thread.sleep(2000);
        logger.info("CLICKED ON SEARCH BUTTON");
    }

    @Then("User should found Email {string} in search table")
    public void userShouldFoundEmailInSearchTable(String email) {
        boolean isPresent = adminPage.findEmailInTheColumn(email);
        logger.info("SEARCHING THE USER WITH GIVEN MAIL");
        Assert.assertTrue(isPresent, "%s input email is not present in the table".formatted(email));
    }

    @And("Enter Customer Name {string}")
    public void enterCustomerName(String name) {
        adminPage.setSearchFirstName(name);
        logger.info("ENTERED THE NAME %s FOR SEARCHING THE CUSTOMER".formatted(name));
    }

    @Then("User should found Name {string} in search table")
    public void userShouldFoundNameInSearchTable(String name) {
        boolean isPresent = adminPage.findFirstNameInTheColumn(name);
        logger.info("SEARCHING THE USER WITH GIVEN NAME");
        Assert.assertTrue(isPresent, "%s name is not present in the table".formatted(name));
    }

    @Then("close the browser")
    public void close_the_browser() {
        logger.info("BROWSER QUIT");
        driver.quit();
//        logger.info("BROWSER CLOSE");
    }


}
