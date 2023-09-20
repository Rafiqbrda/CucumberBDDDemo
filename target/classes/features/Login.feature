
Feature: Login functionality
  

 
    Scenario : Login with valid credentials
    Given User navigates to login page
    When User enters valid email address "rafiqueltaj@yahoo.com" into email field
    And User enters valid password "Raita9660" into password field
    And User clicks on login button
    Then User should get successfully logged in
    
  
  
    Scenario: Login with invalid credentials
    Given User navigates to login page
    When User enters invalid email address into email field
    And User enters invalid password "raita9880" into password field
    And User clicks on login button
    Then User should get a proper warning message about credentials mismatch
  
  Scenario: Login with valid email and invalid pasword
    Given User navigates to login page
    When User enters valid email address "rafiqueltaj@yahoo.com" into email field
    And User enters invalid password "raita9880" into password field
    And User clicks on login button
    Then User should get a proper warning message about credentials mismatch
  
  Scenario: Login with invalid email and valid password
    Given User navigates to login page
    When User enters invalid email address into email field
    And User enters valid password "Raita9660" into password field
    And User clicks on login button
    Then User should get a proper warning message about credentials mismatch
  
  Scenario: Login without any credentials
    Given User navigates to login page
    When User does not enter  email address into email field
    And User does not enter  password into password field
    And User clicks on login button
    Then User should get a proper warning message about credentials mismatch
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
   
  