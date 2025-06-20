package com.stepDefinitions;


import com.pages.HomePage;
import com.utils.CommonBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class Search {


    private final CommonBase commonBase;
    private static final Logger log = LoggerFactory.getLogger(Search.class);

    public Search(CommonBase commonBase) {
        this.commonBase = commonBase;
    }

    @Given("User is Paytm Page Login")
    public void user_on_login_page() {
        String baseUrl= commonBase.prop.getProperty("url");
        commonBase.driver.get(baseUrl);

    }

    @When("User can book Bus And Train Ticket Source {string} and Destination {string}")
    public void user_logged_in(String source, String destination) throws InterruptedException {
        commonBase.homePage=(HomePage) commonBase.pageObjectManager.getPage("Home");
        log.info("Source {}", source);
        log.info("Destination {}", destination);
        commonBase.homePage.searchFlight(source, destination,"Fastest");

    }

}
