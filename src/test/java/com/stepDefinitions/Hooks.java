package com.stepDefinitions;


import com.utils.CommonBase;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class Hooks {
    private static final Logger log = LoggerFactory.getLogger(Hooks.class);
    private CommonBase commonBase;


    public Hooks(CommonBase commonBase) {
        this.commonBase = commonBase;
    }


    @Before() //Runs before once executing a Scenario
    public void setUp() throws IOException {
        commonBase.initializeDriver();
        log.info("Drivers Intialized");
    }

    @After //Runs after once executing a Scenario
    public void closeBrowser() {
        if (commonBase.driver != null) {
            commonBase.driver.quit();
        }
        log.info("All Driver Closed");

    }

    @AfterStep // Runs after each step in a Scenario
    public void printAfterEachScenario(Scenario scenario) {
        log.info("Test Cases Running " + scenario.getName());
    }

    @AfterStep
    public void addScreedShot(Scenario scenario) throws IOException {
        if (!scenario.isFailed()) {
            File file = ((TakesScreenshot) commonBase.driver).getScreenshotAs(OutputType.FILE);
            FileUtils.readFileToByteArray(file);
            scenario.attach(FileUtils.readFileToByteArray(file), ".png", "Failed Case");
        }

    }
}
