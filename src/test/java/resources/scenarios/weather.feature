Feature: Testing weather API for one city

  Scenario: Testing weather data for London
    Given city is: "London"
    And country is: "UK"

  When we are requesting weather data

    Then lon is: -0.13
    And lat is: 51.51
    And temp is: 280.32
    And pressure is: 1012
    And humidity is: 81
