
Feature: Registration functionlity
  
  
  Scenario: User create account with mandatory fields
    Given User open to register account page
    When User provides infomation into the below fields
    |Md rafiquel Islam
    |lastName|islam|
    |telephone|5125019660|
    |password|Raita9660|
    And User selects privacy policy
    And User clicks continue button
    And User account should create successfully

    Scenario: User create account without fields
    Given User open to register account page
    When User not write any details into fields
    And User clicks continue button
    And User shoult get important message for every blank fields
   
  
  
  
  
  
  