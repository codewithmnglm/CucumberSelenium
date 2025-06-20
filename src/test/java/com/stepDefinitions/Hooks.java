package com.stepDefinitions;

import com.aventstack.extentreports.reporter.FileUtil;
import com.utils.CommonBase;
import com.utils.TestBase;
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


    @Before
    public void setUp() throws IOException {
        commonBase.initializeDriver();
        System.out.println("Drivers Intialized");
    }


    @After
    public void closeBrowser(){
        if(commonBase.driver!=null){
           // commonBase.driver.quit();
        }
        log.info("All Driver Closed");

    }

    @AfterStep
    public void addScreedShot(Scenario scenario) throws IOException {
        if(!scenario.isFailed()){
            File file= ((TakesScreenshot)commonBase.driver).getScreenshotAs(OutputType.FILE);
            FileUtils.readFileToByteArray(file);
            scenario.attach(FileUtils.readFileToByteArray(file),".png" ,"Failed Case");
        }

    }
}
