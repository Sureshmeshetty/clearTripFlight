package com.clearTrip.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FlightsSearchPageLocators {
	@FindBy(how=How.CSS, using="ul.productNav a[href='/flights']")
	public WebElement searchPage_FlightsBtn;
	
	@FindBy(how=How.ID, using="OneWay")
	public WebElement searchPage_OneWayRadioBtn;
	
	@FindBy(how=How.ID, using="FromTag")
	public WebElement searchPage_FromTag;
	
	@FindBy(how=How.ID, using="ToTag")
	public WebElement searchPage_ToTag;
	
	@FindBy(how=How.ID, using="DepartDate")
	public WebElement searchPage_DepartDate;
	
	@FindBy(how=How.CSS, using="#SearchBtn")
	public WebElement searchPage_SearchBtn;
}
