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

    private By ticketBooking = By.xpath("//li[contains(text(),'Ticket Booking')]");
    private By rechargeAndBills = By.xpath("//li[contains(text(),'Recharge & Bills')]");
    private By paymentAndServices = By.xpath("//li[contains(text(),'Payments & Services')]");
    private By paytmForBusiness = By.xpath("//li[contains(text(),'Paytm for Business')]");

    private By filter = By.xpath("//span[text()='Cheapest']");
    private By stops = By.xpath("//span[text()='Stops']");
    private By closeStops = By.xpath("//img[@src='//travel-assets-akamai.paytm.com/travel/mweb-flights/assets/a74e1835..svg']");

    // Stop filter buttons - Multiple XPath options
    private By nonStopButton = By.xpath("//div[@class='E8Adw']//input[@id='nonStop'][1]");
    private By oneStopButton = By.xpath("//div[@class='E8Adw']//input[@id='oneStop'][1]");
    private By twoStopsButton = By.xpath("//div[@class='E8Adw']//input[@id='multiple'][1]");

    // private By selectPassenger = By.xpath("//i[contains(@class,'jJnGu')]");

    private By clickOnSelectPassenger = By.xpath("//span[@id='numPax']");
    private By done = By.xpath("//div[text()='Done']");

    private By addAdult = By.xpath("//h2[contains(text(),'Add Travellers')]//ancestor::div[1]//div[1]//div[3]/img");
    private By removeAdult = By.xpath("//h2[contains(text(),'Add Travellers')]//ancestor::div[1]//div[1]//div[1]/img");
    private By addChildren = By.xpath("//h2[contains(text(),'Add Travellers')]//ancestor::div[1]//div[2]//div[3]/img");
    private By addInfants = By.xpath("//h2[contains(text(),'Add Travellers')]//ancestor::div[1]//div[2]//div[3]/img");

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

    public String returnTitle() {
        return commonBase.seleniumUtils.getTitleOfCurrentPage();
    }


    public void searchFlight(String srcCity, String destCity, String filterType) throws InterruptedException {


        commonBase.seleniumUtils.clickElement(srcFrom);
        commonBase.seleniumUtils.enterText(inputSrc, srcCity);
        commonBase.seleniumUtils.clickElement(searchSuggestion);
        commonBase.seleniumUtils.clickElement(srcTo);
        commonBase.seleniumUtils.enterText(inputDest, destCity);
        commonBase.seleniumUtils.clickElement(searchSuggestion);
        commonBase.seleniumUtils.clickElement(clickOnSelectPassenger);
        commonBase.seleniumUtils.clickElement(addAdult);
        addAdults(1);
        // commonBase.seleniumUtils.clickElement(selectedPassnger);

        commonBase.seleniumUtils.clickElement(done);
        commonBase.seleniumUtils.clickElement(searchFlight);
        commonBase.seleniumUtils.clickElement(filter);
        // String filterType="Fastest";
        commonBase.seleniumUtils.clickElement(By.xpath("//label[@id='onward " + filterType + "']"));

    }

    public void addAdults(int count) {
        for (int i = 0; i < count; i++) {
            commonBase.seleniumUtils.clickElement(addAdult);
        }
    }

    public void removeAdults(int count) {
        if (count < 2) {
            throw new IllegalArgumentException("No Of Passengers Should be Atleast 2 ");
        }
        for (int i = 0; i < count; i++) {
            commonBase.seleniumUtils.clickElement(removeAdult);
        }
    }


}
