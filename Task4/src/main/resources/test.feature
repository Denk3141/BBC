Feature: Test
  In these tests, I check the negative scenarios
  of the form of sending messages on the site BBC

  Scenario Outline: checkStoriesErrorMassage
    Given User opens '<homePage>' page
    And User click on News button
    And User click on Coronavirus button
    And User click on contact BBC News button
    And User click on send Us a story button
    And User click on Submit
    Then User checks for an error message near the message text field

    Examples:
      | homePage             |
      | https://www.bbc.com/ |

  Scenario Outline: checkNameErrorMassage
    Given User opens '<homePage>' page
    And User click on News button
    And User click on Coronavirus button
    And User click on contact BBC News button
    And User click on send Us a story button
    And User click on Submit
    Then User check for an error message next to the username input

    Examples:
      | homePage              |
      |  https://www.bbc.com/ |

  Scenario Outline: checkEmailErrorMassage
    Given User opens '<homePage>' page
    And User click on News button
    And User click on Coronavirus button
    And User click on contact BBC News button
    And User click on send Us a story button
    And User typing '<mail>' in email footer and click on Submit
    Then User check for an error message near the email field


    Examples:
      | homePage             |     mail      |
      | https://www.bbc.com/ |     mail      |