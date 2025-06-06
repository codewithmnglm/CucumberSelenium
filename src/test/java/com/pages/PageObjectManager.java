package com.pages;

import com.utils.CommonBase;
import org.openqa.selenium.WebDriver;

public class PageObjectManager  {

    WebDriver driver;
    public CommonBase commonBase;

    public PageObjectManager(CommonBase commonBase){
        this.commonBase=commonBase;
        this.driver= commonBase.driver;


    }

    public Object getPage(String pageName) {
        switch (pageName.toLowerCase()) {
            case "train":
                return new TrainPage(commonBase);
            case "bus":
                return new BusPage(commonBase);
            case "home":
                return new HomePage(commonBase);
                default:
                throw new IllegalArgumentException("Invalid page name: " + pageName);
        }
    }
}
