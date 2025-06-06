package com.pages;

import com.utils.CommonBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    public WebDriver driver;
    public CommonBase commonBase;

    public HomePage(CommonBase commonBase) {
        this.commonBase = commonBase;
        this.driver = commonBase.driver;
    }


    private By flightLink = By.xpath("//a[@href='https://tickets.paytm.com/flights/']//i[@id='Flights']");
    private By busLink = By.xpath("//a[@href='https://tickets.paytm.com/bus/']//i[@id='Bus']");
    private By trainLink = By.xpath("//a[@href='https://tickets.paytm.com/trains/']//img[@id='Trains']");
    private By intFlightLink = By.xpath("//a[@href='https://tickets.paytm.com/international-flights/']//i[@id='Intl. Flights']");

    private By srcFrom = By.xpath("//span[@id='srcCode']");
    private By srcTo = By.xpath("//span[@id='destCode']");
    private By inputSrc = By.xpath("//input[@placeholder='Source']");
    private By inputDest = By.xpath("//input[@placeholder='Destination']");
    private By searchSuggestion = By.xpath("//div[@id='popularCityName'][1]");
    private By searchFlight = By.xpath("//button[@id='flightSearch']");

    By ticketBooking = By.xpath("//li[contains(text(),'Ticket Booking')]");
    private By rechargeAndBills = By.xpath("//li[contains(text(),'Recharge & Bills')]");
    private By paymentAndServices = By.xpath("//li[contains(text(),'Payments & Services')]");
    private By paytmForBusiness = By.xpath("//li[contains(text(),'Paytm for Business')]");
    private By Company = By.xpath("//li[contains(text(),'Company')]");

    public HomePage() {

    }


    public TrainPage navigateToTrainPage() {
        commonBase.seleniumUtils.clickElement(trainLink);
        return new TrainPage(commonBase);
    }

    public BusPage navigateToBusPage() {
        commonBase.seleniumUtils.clickElement(busLink);
        return new BusPage(commonBase);
    }

    public void hoverOverTicketSection() {
        commonBase.seleniumUtils.hoverOverElement(ticketBooking);
    }

    public void hoverOverRechargeAndBills() {
        commonBase.seleniumUtils.hoverOverElement(rechargeAndBills);
    }

    public void hoverOverPaymentAndServices() {
        commonBase.seleniumUtils.hoverOverElement(paymentAndServices);
    }

    public String returnTitle(){
        return commonBase.seleniumUtils.getTitleOfCurrentPage();
    }




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
