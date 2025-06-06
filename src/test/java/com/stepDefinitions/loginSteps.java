package com.stepDefinitions;


import com.pages.HomePage;
import com.utils.CommonBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class loginSteps {


    private CommonBase commonBase;
    private static final Logger log = LoggerFactory.getLogger(loginSteps.class);

    public loginSteps(CommonBase commonBase) {
        this.commonBase = commonBase;
    }

    @Given("User is Paytm Page Login")
    public void user_on_login_page() {
        String baseUrl= commonBase.prop.getProperty("url");
        commonBase.driver.get(baseUrl);

    }

    @When("User can book Bus And Train Ticket Source {string} and Destination {string}")
    public void user_logged_in(String source, String destination) {
        commonBase.homePage=(HomePage) commonBase.pageObjectManager.getPage("Home");
        System.out.println(source + " source");
        log.info("All Driver Closed");
        System.out.println(destination + " destination");
        commonBase.homePage.searchFlight(source, destination);


    }

}
