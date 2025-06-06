package com.utils;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SeleniumUtils {

    public CommonBase commonBase;

    public SeleniumUtils(CommonBase commonBase) {
        this.commonBase = commonBase;
    }

    public void enterText(By locator, String text) {
        try {

            WebDriverWait wait = new WebDriverWait(commonBase.driver, Duration.ofSeconds(20));
            commonBase.driver.findElement(locator).click();
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
            element.sendKeys(text);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void clickElement(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(commonBase.driver, Duration.ofSeconds(10));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void hoverOverElement(By locator) {
        Actions actions = new Actions(commonBase.driver);
        WebElement webElement = commonBase.driver.findElement(locator);
        actions.moveToElement(webElement);

    }

    public String getTitleOfCurrentPage() {
        return commonBase.driver.getTitle();
    }

}
