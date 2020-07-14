package steps;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.clearTrip.pages.actions.FlightSearchResultsPageActions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FlightsSearchResults {
	Logger logger = Logger.getLogger(FlightsSearchResults.class);
	FlightSearchResultsPageActions searchActions=new FlightSearchResultsPageActions();
	
	@When("^I Sort by \"([^\"]*)\"$")
	public void i_Sort_by(String sortBy) {
		searchActions.clickToSortSearchResults(sortBy);
	}
	
	@When("^I Get All the fastest Flights$")
	public void i_Get_All_Fastest_Flights() {
		List<WebElement> allFastestFlights = searchActions.getAllfastestFlight();
		int numberOfFastestFlights = allFastestFlights.size();
		logger.info("Total Number Of Fastest Flights: "+numberOfFastestFlights);
	}
	
	@Then("^I Get All the Cheapest And Fastest Flights$")
	public void i_Get_All_the_Cheapest_And_Fastest_Flights() {
		searchActions.getAllTheCheapestFlights();
	}
}
