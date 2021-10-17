package com.gerimedica.helper.pageobject;

import com.gerimedica.helper.javascript.JavaScriptHelper;
import com.gerimedica.helper.logger.LoggerHelper;
import com.gerimedica.utility.ObjectRepo;
import com.gerimedica.wait.WaitHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;
import java.util.stream.Collectors;

public class Collection extends PageBase{

    private WebDriver driver;
    private final Logger log = LoggerHelper.getLogger(HomePage.class);
    JavaScriptHelper javascripthelper;
    private WaitHelper waitHelper =new WaitHelper(ObjectRepo.driver,ObjectRepo.reader);

    public Collection(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

//below can also be returned as span.results
    @FindBy(how= How.CSS,using=".results")
    public WebElement resultCount;

    @FindBy(how=How.CSS,using="input.collection-search-input")
    public WebElement searchCollection;

    @FindBy(how=How.CSS,using=".btn-icon.collection-search-search-button")
    public WebElement clickOnSearch;

    @FindBy(how=How.CSS,using=".collection-art-object-list-item>a")
    public List<WebElement> allCollectionsLink;

    public int getPaintingsCount(){
    int countArtObject = Integer.parseInt(resultCount.getText());
    return countArtObject;
    }

    public boolean collectionListisPositive(int count){
       if(getPaintingsCount()>count)
           return true;
       else return false;
    }


    public void searchCollection(String collectionName) throws InterruptedException {
       // Thread.sleep(5000);
        waitHelper.waitForElementVisible(searchCollection);
        searchCollection.sendKeys(collectionName);
        clickOnSearch.click();
    }
   //List<WebElement> allCollectionsList;
    public List<String> getAllCollectionsList(List<WebElement> allCollectionsList){
     //  allCollectionsList = allCollectionsLink;
        List<String> CollectionListByName = allCollectionsList.stream().map(i->i.getAttribute("title")).collect(Collectors.toList());
        return CollectionListByName;
    }

    public  boolean clickOnPainting(int collectionIndex){
if(allCollectionsLink.get(collectionIndex-1).isDisplayed()) {
    allCollectionsLink.get(collectionIndex - 1).click();
    return true;
}
else
    return false;

    }
}
