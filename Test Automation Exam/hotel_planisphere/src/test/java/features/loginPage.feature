Feature: Hotel Planisphere Login Page
  # To the hiring manager, I am unable to script a positive test for the login since I don't have a valid login
  # credential to use. I tried registering, but I am not able to use the account that I registered. I added a
  # test case for it below but did not script it.

#  Scenario: Verify that user is able to login when using correct email and password combination
#    Given I am in Hotel Planisphere login page
#    When I click on the login button
#    And I enter a valid email in email field
#    And I enter a valid password in password field
#    And I click on the login button
#    Then I am unable to login
#    And the error message is correct for blank username input
#    And the error message is correct for blank password input
#    And the browser should close

######### Header scripts #########
  Scenario: Verify that header and navbar is displayed
    Given I am in Hotel Planisphere login page
    When I get the header element text
    Then the header should be displayed correctly
    When I check each navbar element
    Then the navbar elements should be displayed correctly
    And the browser should close

  Scenario: Verify that clicking on each navbar item sends you to the correct page
    Given I am in Hotel Planisphere login page
    When I click the Home link
    Then I should be redirected to the Home page
    When I go back to the previous page
    And I click the Plans link
    Then I should be redirected to the Plans page
    When I go back to the previous page
    And I click the Signup link
    Then I should be redirected to the Signup page
    When I go back to the previous page
    And I click the Login button
    Then I should be redirected to the login page
    And the browser should close

######### Login body scripts #########

  Scenario: Verify that login page elements are displayed
    Given I am in Hotel Planisphere login page
    When I get each of the element text displayed in the login page
    Then the login page elements are displayed correctly
    And the browser should close

  Scenario: Verify that user is unable to login when using an incorrect email and password
    Given I am in Hotel Planisphere login page
    When I enter test@test.com in email field
    And I enter Password1234 in password field
    And I click on the login button
    Then I am unable to login
    And all the error messages are correct
    And the browser should close

  Scenario: Verify that user is unable to login when using a blank email
    Given I am in Hotel Planisphere login page
    When I enter Password1234 in password field
    And I click on the login button
    Then I am unable to login
    And the error message is correct for blank email input
    And the browser should close

  Scenario: Verify that user is unable to login when using a blank password
    Given I am in Hotel Planisphere login page
    When I enter test@test.com in email field
    And I click on the login button
    Then I am unable to login
    And the error message is correct for blank password input
    And the browser should close

  Scenario: Verify that user is unable to login when using a blank email and password
    Given I am in Hotel Planisphere login page
    When I click on the login button
    Then I am unable to login
    And the error message is correct for blank email input
    And the error message is correct for blank password input
    And the browser should close

######### Footer scripts #########

  Scenario: Verify that footer elements are displayed
    Given I am in Hotel Planisphere login page
    When I check the footer Github element text
    Then the footer Github element text should be displayed correctly
    When I check each copyright text
    Then the copyright text should be displayed correctly
    And the browser should close

  Scenario: Verify that clicking the footer link will send the user to the correct page
    Given I am in Hotel Planisphere login page
    When I click the footer link
    Then I should be redirected to the GitHub page
    And the browser should close

