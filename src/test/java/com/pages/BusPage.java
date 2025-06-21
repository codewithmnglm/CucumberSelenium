package com.pages;

import com.utils.CommonBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BusPage extends HomePage {

    public CommonBase commonBase;

    public BusPage(CommonBase commonBase) {
        super();
        this.commonBase = commonBase;
    }

    By oneWay = By.xpath("//label[@id='oneway']");
    By roundTrip = By.xpath("//label[@id='roundtrip']");
    By sourceInput = By.xpath("//input[@id='dwebSourceInput']");
    By destinationInput = By.xpath("//input[@id='dwebDestinationInput']");
    By swap = By.xpath("//img[contains(@src,'//travel-assets-akamai.paytm.com/travel/mweb-bus/assets/363f4432.svg')]");
    By searchBuses = By.xpath("//button[contains(text(), 'Search Buses')]");
    By searchSuggestion = By.xpath("//div[contains(text(), 'Search Results')]//ancestor::div[1]//div[3]");
    By today = By.xpath("//div[contains(text(), 'Today')]");
    By sleeper = By.xpath("//div[@class='gF+o3' and text()='Sleeper']");
    By seater = By.xpath("//div[@class='gF+o3' and text()='Seater']");
    By semiSleeper = By.xpath("//div[@class='gF+o3' and text()='Semi-Sleeper']");
    By acBusFilterCheckBox = By.xpath("//label[@id='busFilterCheckBox']");

    public void searchAllBuses(String srcCity, String destCity) throws InterruptedException {

        commonBase.seleniumUtils.enterText(sourceInput, srcCity);
        commonBase.seleniumUtils.clickElement(searchSuggestion);
        commonBase.seleniumUtils.enterText(destinationInput, destCity);
        commonBase.seleniumUtils.clickElement(searchSuggestion);
        commonBase.seleniumUtils.clickElement(today);
        commonBase.seleniumUtils.clickElement(searchBuses);


    }

    public void searchSleeperBuses(String srcCity, String destCity) {

        commonBase.seleniumUtils.clickElement(oneWay);
        commonBase.seleniumUtils.clickElement(sleeper);
        commonBase.seleniumUtils.enterText(sourceInput, srcCity);
        commonBase.seleniumUtils.clickElement(searchSuggestion);
        commonBase.seleniumUtils.enterText(destinationInput, destCity);
        commonBase.seleniumUtils.clickElement(searchSuggestion);
        commonBase.seleniumUtils.clickElement(today);
        commonBase.seleniumUtils.clickElement(sleeper);
        commonBase.seleniumUtils.clickElement(searchBuses);


    }

    public void searchSemiSleeperBuses(String srcCity, String destCity) {

        commonBase.seleniumUtils.clickElement(oneWay);
        commonBase.seleniumUtils.enterText(sourceInput, srcCity);
        commonBase.seleniumUtils.clickElement(searchSuggestion);
        commonBase.seleniumUtils.enterText(destinationInput, destCity);
        commonBase.seleniumUtils.clickElement(searchSuggestion);
        commonBase.seleniumUtils.clickElement(today);
        commonBase.seleniumUtils.clickElement(semiSleeper);
        commonBase.seleniumUtils.clickElement(searchBuses);


    }

    public void searchSeaterSleeperBuses(String srcCity, String destCity) {

        commonBase.seleniumUtils.clickElement(oneWay);
        commonBase.seleniumUtils.enterText(sourceInput, srcCity);
        commonBase.seleniumUtils.clickElement(searchSuggestion);
        commonBase.seleniumUtils.enterText(destinationInput, destCity);
        commonBase.seleniumUtils.clickElement(searchSuggestion);
        commonBase.seleniumUtils.clickElement(today);
        commonBase.seleniumUtils.clickElement(seater);
        commonBase.seleniumUtils.clickElement(searchBuses);


    }


}
