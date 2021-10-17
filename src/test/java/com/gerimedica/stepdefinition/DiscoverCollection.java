package com.gerimedica.stepdefinition;

import com.gerimedica.helper.pageobject.Collection;
import com.gerimedica.helper.pageobject.CollectionVerification;
import com.gerimedica.utility.ObjectRepo;
import com.gerimedica.wait.WaitHelper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class DiscoverCollection {

    private Collection collection = new Collection(ObjectRepo.driver);
    private CollectionVerification CollectionDetails = new CollectionVerification(ObjectRepo.driver);
    private WaitHelper waitHelper = new WaitHelper(ObjectRepo.driver, ObjectRepo.reader);

    @Given(": Collection page is loaded with title {string}")
    public void collection_page_is_loaded_with_title(String title) throws InterruptedException {
        waitHelper.hardWait(3000);
        Assert.assertTrue(title + " title is not correct or not found", collection.checkForTitle(title));
    }


    @Given(": painting with title {string} is searched from the search box")
    public void painting_with_title_is_searched_from_the_search_box(String paintingName) throws InterruptedException {
        Assert.assertTrue(paintingName + "search is failed", collection.searchCollection(paintingName));

    }

    @Then(": Verify that you get more than {int} results")
    public void verify_that_you_get_more_than_results(int PaintingResultCount) {
        Assert.assertTrue("searched painting result count is less than " + PaintingResultCount, collection.collectionListisPositive(PaintingResultCount));

    }

    @Then(": Verify that you get more than {string} results")
    public void verify_that_you_get_more_than_results(String noPaintingFound) {
        Assert.assertTrue("searched painting not found", collection.noPaintingFound(noPaintingFound));
    }


    @Given(": Click on the {int} result")
    public void click_on_the_result(int paintingNumber) {
        Assert.assertTrue("click on " + paintingNumber + "painting", collection.clickOnPainting(paintingNumber));
    }

    @Then(": Verify the painting you get by checking {string}, {string} and {string}")
    public void verify_the_painting_you_get_by_checking_and(String Fnummer, String JHnummer, String Inventarnummer) throws InterruptedException {
        Assert.assertTrue("Objact data + is not expanded", CollectionDetails.scrollAndClickObjectgegevens());
        Assert.assertEquals("mismatch in F-nummer", CollectionDetails.getSectionValues().get("F-nummer"), Fnummer);
        Assert.assertEquals("mismatch in JH-nummer", CollectionDetails.getSectionValues().get("JH-nummer"), JHnummer);
        Assert.assertEquals("mismatch in Inventarisnummer", CollectionDetails.getSectionValues().get("Inventarisnummer"), Inventarnummer);
    }

}
