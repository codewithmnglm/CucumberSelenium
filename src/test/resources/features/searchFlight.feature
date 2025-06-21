Feature: Website Login

  @smoke
  Scenario: Search Flights Between Delhi and Bengaluru ie: National Flight
    Given User is Paytm Page Login
    When User can book Flight Source "Delhi" and Destination "Patna"
    When Starting of test case

  @regression
  Scenario: Search Flights Between Delhi and London ie: International Flight
    Given User is Paytm Page Login
    When User can book Flight Source "Delhi" and Destination "London"
    When Starting of test case






