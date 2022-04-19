Feature: Add Cryptocurrencies to Watch List

  Scenario Outline: Predefined Cryptocurrency search
    Given Navigated to Home Page <url>
    And Logged in with <email> and <password>
    When Clicks on Filters button
    And Clicks on More Filter button
    And Clicks on Price option in the popup menu
    And Enters 50000 in the left price text box
    And Enters 99999 in the right price text box
    And Clicks on Apply Filter button
    And Clicks on Show Results button
    And Clicks on the chosen star buttons
    And Clicks on Watch List button
    Then Verify chosen Cryptocurrencies are in Watch List

    Examples:
      |url                       | email                  |password    |
      |https://coinmarketcap.com/| milanguzina84@gmail.com|micantheman1|



