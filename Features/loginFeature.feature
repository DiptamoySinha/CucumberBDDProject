Feature: Login

  @Smoke
  Scenario: Successful login with valid credential
    Given user Launch chrome browser
    When user open url "https://admin-demo.nopcommerce.com/login"
    And user enter email "admin@yourstore.com" and password "admin"
    And user click submit
    Then page title should include "Dashboard / nopCommerce administration"
    When user click logout
    Then page title should include "Login"
    And browser close

  @Regression
  Scenario Outline: Successful login with credentials DDT
    Given user Launch chrome browser
    When user open url "https://admin-demo.nopcommerce.com/login"
    And user enter email "<email>" and password "<password>"
    And user click submit
    Then page title should include "Dashboard / nopCommerce administration"
    When user click logout
    Then page title should include "Login"
    And browser close

    Examples:
    |email|password|
    |admin@yourstore.com|admin|
    |test@yourstore.com|admin|


