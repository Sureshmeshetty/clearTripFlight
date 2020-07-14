@Book_Tikect
Feature: Acceptance testing.
  In order to book the tickets verify that cleartrip page is loading and able to book the tickets
  

  @clearTripExecise
  Scenario Outline: Validate ticketBooking
    Given I am on the Home Page "https://www.cleartrip.com" of cleartrip Website
    When I click on Flights Button
    When I select OneWay radioButton
    When I enter <From> and <To> values 
    When I enter <Departure>
    When I click on Search Flights
    When I Sort by "Duration"
    When I Get All the fastest Flights
    Then I Get All the Cheapest And Fastest Flights
    
    Examples:  
    |  From    			|  To   			 |Departure 	|
    | "Hyderabad"     	| "New Delhi"        |"23/07/2020"  |