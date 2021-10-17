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
    private WaitHelper waitHelper =new WaitHelper(ObjectRepo.driver,ObjectRepo.reader);

    @Given(": Collection page is loaded with title {string}")
    public void collection_page_is_loaded_with_title(String title) throws InterruptedException {
        waitHelper.hardWait(3000);
        System.out.println("Page title is:"+collection.checkForTitle(title));
        Assert.assertTrue("Collection page title check",collection.checkForTitle(title));
        }

   /* @Then(": Check collection result is greater than zero")
    public void check_collection_result_is_greater_than_count() {
 Assert.assertTrue("Collection page has atlease 1 art object",collection.collectionListisPositive());
    }*/

    @Given(": painting with title {string} is searched from the search box")
    public void painting_with_title_is_searched_from_the_search_box(String paintingName) throws InterruptedException {
    collection.searchCollection(paintingName);
    System.out.println("search is pass");

    }

    @Then(": Verify that you get more than {int} results")
    public void verify_that_you_get_more_than_results(int PaintingResultCount) {
        Assert.assertTrue("Searched painting result count",collection.collectionListisPositive(PaintingResultCount));

    }


    @Given(": Search the painting with title “Het Gele Huis” from the search box")
    public void search_the_painting_with_title_Het_Gele_Huis_from_the_search_box() throws InterruptedException {
        collection.searchCollection("Het Gele Huis");
        System.out.println("search is pass");

    }

    @Given(": Click on the {int} result")
    public void click_on_the_result(int paintingNumber) {
    Assert.assertTrue("click on "+paintingNumber+"painting",collection.clickOnPainting(paintingNumber));
    }

    @Then(": Verify the painting you get by checking {string}, {string} and {string}")
    public void verify_the_painting_you_get_by_checking_and(String Fnummer, String JHnummer, String Inventarnummer) throws InterruptedException {
        CollectionDetails.scrollAndClickObjectgegevens();
        Assert.assertEquals("match F-nummer", CollectionDetails.getSectionValues().get("F-nummer"), Fnummer);
        Assert.assertEquals("match JH-nummer", CollectionDetails.getSectionValues().get("JH-nummer"), JHnummer);
        Assert.assertEquals("match Inventarisnummer", CollectionDetails.getSectionValues().get("Inventarisnummer"), Inventarnummer);
    }

}
