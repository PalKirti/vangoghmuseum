package com.gerimedica.stepdefinition;

import com.gerimedica.helper.pageobject.HomePage;
import com.gerimedica.utility.ObjectRepo;
import cucumber.api.java.en.Given;


public class Home {

      private HomePage hPage = new HomePage(ObjectRepo.driver); ;


    @Given(": Website cookie is accepted and Home page is loaded")
    public void website_cookie_is_accepted_and_Home_page_is_loaded() {
        ObjectRepo.driver.get(ObjectRepo.reader.getWebsite());
            hPage.acceptOrRejectCookies();
    }

    @Given(":  verify home page title as {string}")
    public void verify_home_page_title_as(String homePageTitle) {

    //    hPage = new HomePage(ObjectRepo.driver);
        if(hPage.checkForTitle(homePageTitle)){
            System.out.println("Home page title match");

        }
        else{
            System.out.println("Home page title does not match");
        }
    }


    @Given(": Click on link {string} in the home page")
    public void click_on_link_in_the_home_page(String ontdekCollectieLink) throws InterruptedException {
        ObjectRepo.driver.get(ObjectRepo.reader.getWebsite());
        hPage.discoverCollection(ontdekCollectieLink);
    }




}
