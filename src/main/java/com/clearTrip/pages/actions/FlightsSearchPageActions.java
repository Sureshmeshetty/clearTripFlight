package com.clearTrip.pages.actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.clearTrip.pages.locators.FlightsSearchPageLocators;
import com.clearTrip.utils.BaseClasss;
import com.clearTrip.utils.SafeActions;
import com.google.common.base.Function;

public class FlightsSearchPageActions extends SafeActions{
	FlightsSearchPageLocators flightsSearchPageLocators=null;
	Logger logger = Logger.getLogger(FlightsSearchPageActions.class);
	
	public  FlightsSearchPageActions()
	{
		flightsSearchPageLocators=new FlightsSearchPageLocators();
		PageFactory.initElements(BaseClasss.getDriver(), flightsSearchPageLocators);
	}
	public void clickonFlights()
	{
		click(flightsSearchPageLocators.searchPage_FlightsBtn);
	}

	public void chooseToHaveOneWayJourney() {
		click(flightsSearchPageLocators.searchPage_OneWayRadioBtn);
	}

	public void enterSourceAs(String destination) {
		clear(flightsSearchPageLocators.searchPage_FromTag);
		fillText(flightsSearchPageLocators.searchPage_FromTag, destination);
	}


	public void enterDestinationAs(String origin) {
		clear(flightsSearchPageLocators.searchPage_ToTag);
		fillText(flightsSearchPageLocators.searchPage_ToTag, origin);
	}


	public void enterDepartureDateAs(String date) {
		clear(flightsSearchPageLocators.searchPage_DepartDate);
		fillText(flightsSearchPageLocators.searchPage_DepartDate, date);
	}

	public void clickSearchButton()
	{
		click(flightsSearchPageLocators.searchPage_SearchBtn);
		staticWait();
	}

	@SuppressWarnings("deprecation")
	public void selectTheFirstAvailableAutoCompleteOptionFromSource() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(BaseClasss.getDriver())
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		WebElement optionListElement = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.cssSelector("#ui-id-1"));
			}
		});

		//select the first item from the auto complete list
		WebElement originOptionsElement = optionListElement;
		List<WebElement> originOptions = originOptionsElement.findElements(By.tagName("li"));
		originOptions.get(0).click();
	}

	@SuppressWarnings("deprecation")
	public void selectTheFirstAvailableAutoCompleteOptionFromDestination() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(BaseClasss.getDriver())
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		WebElement optionListElement = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.cssSelector("#ui-id-2"));
			}
		});
		//select the first item from the auto complete list
		WebElement originOptionsElement = optionListElement;
		List<WebElement> originOptions = originOptionsElement.findElements(By.tagName("li"));
		originOptions.get(0).click();
	}

}
