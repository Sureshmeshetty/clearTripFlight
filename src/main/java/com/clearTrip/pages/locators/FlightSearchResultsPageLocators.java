package com.clearTrip.pages.locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FlightSearchResultsPageLocators {
	@FindBy(how=How.CSS,using="a[class*='c-secondary-500'] span")
	public List<WebElement> SearchResults_SortOptions;
	
	@FindBy(how = How.CSS,using = "a[class*='c-secondary-500'] svg")
	public WebElement SearchResults_SelectedSortOrder;
	
	@FindBy(xpath="//div[@class='ow-tuple-container__details ms-grid-row-2']")
	public List<WebElement> SearchResults_FlightsListView;
	
	@FindBy(xpath="//div[contains(@class,'ms-grid-column-3 ms-grid-row-1')]")
	public List<WebElement> SearchResults_Durations;
	
	@FindBy(xpath="//div[contains(@class,'ow-tuple-container__details__price')]//p")
	public List<WebElement> SearchResults_Prices;
	
	@FindBy(how=How.XPATH,using="(//*[@type='submit' and text()='Book'])[2]")
	public WebElement SearchResults_BookTicket;
}
