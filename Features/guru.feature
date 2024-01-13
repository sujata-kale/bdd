  Feature: Test Guru99 Application

  Scenario: Validate The ragister page functionality
    Given User is on home page
    When user enter valid firstname, lastname, phone and email
    And user enter valid address, city, state,postol code and select country
    And user enter valid username, password, confirm password and click on submit button
    Then user is on regester sucess page
