
Feature: Search functionality
  

  
  Scenario: Users search valid product
    Given Users open the application
    When Users enter valid product "HP" into search bos fields
    And Users click on search button
    Then Users should get valid product on display
   

Scenario: Users search invalid product
    Given Users open the application
    When Users enter invalid product "Honda" into search bos fields
    And Users click on search button
    Then Users should get warning message for product no matching

Scenario: Users search without any product
    Given Users open the application
    When Users do not  enter any product name into search box field 
    And Users click on search button
    Then Users should get warning message for product no matching




  
  
  
  
  
  
  
  
  
  
  