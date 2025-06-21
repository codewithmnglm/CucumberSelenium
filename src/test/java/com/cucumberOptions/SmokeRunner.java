package com.cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(
        features = "src/test/resources/features",
        monochrome = true,
        tags = "@smoke",
        glue="com.stepDefinitions",
        plugin = {
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }

)
    public class SmokeRunner extends AbstractTestNGCucumberTests { }

