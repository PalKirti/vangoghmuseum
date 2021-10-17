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

public class Collection extends PageBase {

    private WebDriver driver;
    private final Logger log = LoggerHelper.getLogger(HomePage.class);
    JavaScriptHelper javascripthelper;
    private WaitHelper waitHelper = new WaitHelper(ObjectRepo.driver, ObjectRepo.reader);

    public Collection(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    //below can also be returned as span.results
    @FindBy(how = How.CSS, using = ".results")
    public WebElement resultCount;

    @FindBy(how = How.CSS, using = "input.collection-search-input")
    public WebElement searchCollection;

    @FindBy(how = How.CSS, using = ".btn-icon.collection-search-search-button")
    public WebElement clickOnSearch;

    @FindBy(how = How.CSS, using = ".collection-art-object-list-item>a")
    public List<WebElement> allCollectionsLink;

    public String getPaintingsResultCount() {
        String countArtObject = resultCount.getText();
        return countArtObject;
    }

    public boolean noPaintingFound(String noResultMessage) {
        if (getPaintingsResultCount().equalsIgnoreCase(noResultMessage)) {
            log.info(getPaintingsResultCount());
            return true;
        }

        log.info(getPaintingsResultCount());
        return false;
    }

    public boolean collectionListisPositive(int count) {
        try {
            if (Integer.parseInt(getPaintingsResultCount()) > count) {
                log.info("Search result count is "+getPaintingsResultCount());
                return true;
            }
            else {
                log.info("Search result count is "+getPaintingsResultCount());
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }


    }

    /**
     * Search for the painting with the collectionName passed in parameter
     *
     * @param collectionName
     * @return true if the painting search is successfull elsse return false
     * @throws InterruptedException
     */
    public boolean searchCollection(String collectionName) throws InterruptedException {
        waitHelper.waitForElementVisible(searchCollection);
        searchCollection.sendKeys(collectionName);
        if (clickOnSearch.isDisplayed()) {
            clickOnSearch.click();
            log.info("Painting is searched successfully");
            return true;
        } else {
            log.info("Painting is not searched");
            return false;
        }
    }


    /**
     * return all the paintings name present in collection page,this function is not used anywhere
     *
     * @param allCollectionsList
     * @return List of all paintings name
     */
    public List<String> getAllCollectionsList(List<WebElement> allCollectionsList) {
        List<String> CollectionListByName = allCollectionsList.stream().map(i -> i.getAttribute("title")).collect(Collectors.toList());
        return CollectionListByName;
    }

    /**
     * Click on painting based on the Index passed in parameter
     *
     * @param collectionIndex
     * @return true if the click is successful else return false
     */
    public boolean clickOnPainting(int collectionIndex) {
        if (allCollectionsLink.get(collectionIndex - 1).isDisplayed()) {
            allCollectionsLink.get(collectionIndex - 1).click();
            log.info("Painting at index "+collectionIndex+" is clicked");
            return true;
        } else
            log.info("Painting at index "+collectionIndex+" is not clicked");
            return false;

    }
}
