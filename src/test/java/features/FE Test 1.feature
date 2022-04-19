Feature: Cryptocurrencies Ranking List

  Scenario Outline: Top 100 Cryptocurrencies List
    Given Navigated to Home Page <url>
    When  Hovers on CryptoCurrencies dropdown
    And   Clicks on Ranking dropdown option
    And   Clicks on Show rows dropdown
    And   Clicks on 100 option from the Show rows dropdown
    Then  Verify correct search results


    Examples:
    |url                       |
    |https://coinmarketcap.com/|