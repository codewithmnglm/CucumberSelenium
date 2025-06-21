package com.cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;




@CucumberOptions(
        features = "src/test/resources/features",
        monochrome = true,
        tags = "@regression",
        glue="com.stepDefinitions",
        plugin = {
                "pretty",                                                  // Console output
                "html:target/cucumber-reports/html-report.html",           // Basic HTML report
                "json:target/cucumber-reports/cucumber.json",              // JSON report (used by Allure)
                "junit:target/cucumber-reports/cucumber.xml",
        }

)
    public class RegressionRunner extends AbstractTestNGCucumberTests {



    }

