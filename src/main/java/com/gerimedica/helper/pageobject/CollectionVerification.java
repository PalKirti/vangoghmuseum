package com.gerimedica.helper.pageobject;

import com.gerimedica.helper.javascript.JavaScriptHelper;
import com.gerimedica.helper.logger.LoggerHelper;
import com.gerimedica.utility.ObjectRepo;
import com.gerimedica.wait.WaitHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionVerification extends PageBase{


        private WebDriver driver;
        private final Logger log = LoggerHelper.getLogger(HomePage.class);
        JavaScriptHelper javascripthelper;
    private WaitHelper waitHelper =new WaitHelper(ObjectRepo.driver,ObjectRepo.reader);

    public CollectionVerification(WebDriver driver) {
            super(driver);
            this.driver = driver;
        }

        //below can be made generic to expand all +
       @FindBy(how= How.CSS,using=".accordion-item-button>button[aria-label='Open Objectgegevens']")
        public WebElement openObjectgegevens;


    //div[1]/dd
    @FindBy(how=How.XPATH,using = "//*[@class='accordion-item-button']//following::section/dl/div")
    public List<WebElement> getOpenObjectgegevensSection;


    public void scrollAndClickObjectgegevens() throws InterruptedException {
        javascripthelper = new JavaScriptHelper(driver);
        javascripthelper.scrollToElemet(openObjectgegevens);
        waitHelper.hardWait(5000);
        openObjectgegevens.click();
    }

    public Map<String,String> getSectionValues(){
      List<WebElement> objectCollect =  getOpenObjectgegevensSection;
       Map<String,String> objectValue = new HashMap<>();
           for(int i=1;i<objectCollect.size();i++){
               objectValue.put(objectCollect.get(i).findElement(By.xpath("//div["+i+"]/dt")).getText(),objectCollect.get(i).findElement(By.xpath("//div["+i+"]/dd")).getText());
      }
           return objectValue;
    }


}
