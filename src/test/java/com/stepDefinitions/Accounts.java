package com.stepDefinitions;

import com.utils.CommonBase;
import io.cucumber.java.en.When;

public class Accounts {
    private CommonBase data;

    public Accounts(CommonBase data){
        this.data=data;
    }

    @When("Starting of test case")
    public void startingOfTestCase() {

        System.out.println(data.driver.getTitle());
        
        

    }
}
