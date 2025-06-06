package com.utils;

import com.pages.HomePage;
import com.pages.PageObjectManager;
import com.pages.TrainPage;
import org.openqa.selenium.WebDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CommonBase {

    public WebDriver driver;
    public HomePage homePage;
    public TrainPage trainPage;
    public PageObjectManager pageObjectManager;
    public TestBase testBase;
    public Properties prop;
    public SeleniumUtils seleniumUtils;

    public CommonBase() throws IOException {

    }

    public void initializeDriver() throws IOException {
        loadPropFile();
        testBase = new TestBase(prop.getProperty("browser"));
        this.driver = testBase.getWebdriverManager();
        pageObjectManager = new PageObjectManager(this);
        seleniumUtils=new SeleniumUtils(this);

    }

    public void loadPropFile() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/global.properties");
        prop.load(fis);
    }
}
