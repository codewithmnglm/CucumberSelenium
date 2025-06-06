package com.pages;

import com.utils.CommonBase;
import org.openqa.selenium.WebDriver;

public class TrainPage extends HomePage {

    WebDriver driver;
    CommonBase commonBase;

    public TrainPage(CommonBase commonBase){
        this.commonBase=commonBase;
        this.driver=commonBase.driver;

    }






}
