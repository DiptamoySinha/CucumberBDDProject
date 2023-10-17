Feature: Customer

 Background: common steps for all the scenarios
  Given user Launch chrome browser
  When user open url "https://admin-demo.nopcommerce.com/login"
  And user enter email "admin@yourstore.com" and password "admin"
  And user click submit
  Then page title should include "Dashboard / nopCommerce administration"
  When user click on customers Menu
  And click on customer menu item

 @Smoke
 Scenario: Add New Customer
  Then user can view add new customer page
  When user enter customer details
  And click on save button
  Then user can view confirmation message
  And browser close

 @Regression
 Scenario: Search Customer by Email
  And Enter Customer Email "diptamoy.sinha@gmail.com"
  When Click On Search button
  Then User should found Email "diptamoy.sinha@gmail.com" in search table
  And browser close

 @Smoke
 Scenario: Search Customer by First Name
  And Enter Customer Name "Diptamoy"
  When Click On Search button
  Then User should found Name "Diptamoy" in search table
  And browser close
