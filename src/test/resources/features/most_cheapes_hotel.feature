@tag
Feature: Book the cheapest hotel
  I want to book in the most cheapest hotel in any location offered


  @tag1
  Scenario:  Booking the most cheapest hotel in specific location
    Given I want to start in travel page
    When make a reservation at the cheapest 3 star hotel with the details
      | location    | datecheckin | numberofrooms | adultsnumber | childsnumber |
      | Los Angeles | 10/12/2024  | 2             | 3            | 2            |
    Then I should see the price most cheapest and the booking price is correctly for number of days
