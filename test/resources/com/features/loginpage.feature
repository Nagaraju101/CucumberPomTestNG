Feature: Login page feature

  Scenario Outline: Login with correct credentials
    Given user is on login page
    When forgot our password link should be displayed
    When user enters username "ankamreddi2450@gmail.com"
    And user enters password "Test12345"
    And user clicks on Login button
    Then username should be displayed on the page
    Then I click on contacts tab
    And I click on one Category

