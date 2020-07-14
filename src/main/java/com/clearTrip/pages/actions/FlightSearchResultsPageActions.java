package com.clearTrip.pages.actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.clearTrip.pages.locators.FlightSearchResultsPageLocators;
import com.clearTrip.utils.BaseClasss;
import com.clearTrip.utils.SafeActions;

public class FlightSearchResultsPageActions extends SafeActions {

	FlightSearchResultsPageLocators flightSearchResultsPageLoc = null;
	Logger logger = Logger.getLogger(FlightSearchResultsPageActions.class);
	
	int numberOfFlights;
	List<WebElement> allFastestFlights;
	
	public FlightSearchResultsPageActions() {
		flightSearchResultsPageLoc = new FlightSearchResultsPageLocators();
		PageFactory.initElements(BaseClasss.getDriver(), flightSearchResultsPageLoc);
	}

	public void clickToSortSearchResults(String sortBy) {
		for (WebElement sortOption : flightSearchResultsPageLoc.SearchResults_SortOptions)
			if (sortOption.getText().equalsIgnoreCase(sortBy)) {
				click(sortOption);
				while (!flightSearchResultsPageLoc.SearchResults_SelectedSortOrder.getAttribute("style")
						.contains("-180deg"))
					click(sortOption);
				break;
			}
		staticWait();
	}

	public List<WebElement> getAllfastestFlight()
	{
		String lowestDuration = flightSearchResultsPageLoc.SearchResults_Durations.get(0).getText();
		logger.info("Lowest Duration: "+lowestDuration);
		numberOfFlights = flightSearchResultsPageLoc.SearchResults_Durations.size();
		allFastestFlights = new ArrayList<WebElement>();
		for(int i=0;i<numberOfFlights;i++)
		{
			if(flightSearchResultsPageLoc.SearchResults_Durations.get(i).getText().equalsIgnoreCase(lowestDuration))
				allFastestFlights.add(flightSearchResultsPageLoc.SearchResults_FlightsListView.get(i));
		}
		return allFastestFlights;
	}
	
	public void getAllTheCheapestFlights()
	{
		logger.info(allFastestFlights.size());
		 ArrayList<Integer> allFastestFlightCosts = new ArrayList<Integer>();
		 int numberOfFastestFlights = allFastestFlights.size();
		 for(int i=0;i<numberOfFastestFlights;i++)
		 {
			 int cost = Integer.parseInt(flightSearchResultsPageLoc.SearchResults_Prices.get(i).getText().substring(1).replace(",", ""));
			 allFastestFlightCosts.add(cost);
		 }
		 int lowestCost = Collections.min(allFastestFlightCosts);
		 logger.info("Lowest Cost: "+lowestCost);
	}
}
