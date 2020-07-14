package steps;

import com.clearTrip.pages.actions.FlightsSearchPageActions;
import com.clearTrip.utils.BaseClasss;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class SearchFlightSteps {
	
	FlightsSearchPageActions flightSearchPageActions=new FlightsSearchPageActions();
	
	@Given("^I am on the Home Page \"([^\"]*)\" of cleartrip Website$")
	public void i_am_on_the_Home_Page_of_cleartrip_Website(String url) throws Throwable {
	    BaseClasss.openPage(url);
	}
	
	@When("^I click on Flights Button$")
	public void i_click_on_Flights_Button() throws Throwable {
		flightSearchPageActions.clickonFlights();
	}

	@When("^I select OneWay radioButton$")
	public void i_select_RoundTrip_dropdown() throws Throwable {
		flightSearchPageActions.chooseToHaveOneWayJourney();
	}
	
	@When("^I enter \"([^\"]*)\" and \"([^\"]*)\" values$")
	public void i_enter_and_values(String from, String to) throws Throwable {
		flightSearchPageActions.enterSourceAs(from);
		flightSearchPageActions.selectTheFirstAvailableAutoCompleteOptionFromSource();
		flightSearchPageActions.enterDestinationAs(to);
		flightSearchPageActions.selectTheFirstAvailableAutoCompleteOptionFromDestination();
	}
	
	@When("^I enter \"([^\"]*)\"$")
	public void i_enter(String departDate) throws Throwable {
		flightSearchPageActions.enterDepartureDateAs(departDate);
	}

	@When("^I click on Search Flights$")
	public void i_click_on_Search_Flights() throws Throwable {
		flightSearchPageActions.clickSearchButton();
	}
}
