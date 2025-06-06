package com.pages;

import com.utils.CommonBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightPage extends HomePage {

    public WebDriver driver;
    public CommonBase commonBase;

    public FlightPage(CommonBase commonBase) {
        this.commonBase = commonBase;
        this.driver = commonBase.driver;
    }
    private By srcFrom = By.xpath("//span[@id='srcCode']");
    private By srcTo = By.xpath("//span[@id='destCode']");
    private By inputSrc = By.xpath("//input[@placeholder='Source']");
    private By inputDest = By.xpath("//input[@placeholder='Destination']");
    private By searchSuggestion = By.xpath("//div[@id='popularCityName'][1]");
    private By searchFlight = By.xpath("//button[@id='flightSearch']");

    public void searchFlight(String srcCity, String destCity) {


        commonBase.seleniumUtils.clickElement(srcFrom);
        commonBase.seleniumUtils.enterText(inputSrc, srcCity);
        commonBase.seleniumUtils.clickElement(searchSuggestion);
        commonBase.seleniumUtils.clickElement(srcTo);
        commonBase.seleniumUtils.enterText(inputDest, destCity);
        commonBase.seleniumUtils.clickElement(searchSuggestion);
        commonBase.seleniumUtils.clickElement(searchFlight);


    }
}
