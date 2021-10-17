package com.gerimedica.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:featurefile/"},
        glue = {"classpath:com.gerimedica.stepdefinition", "classpath:com.gerimedica.helper"},
        plugin = {"pretty", "html:target/cucumber-reports", "json:target/cucumber.json"},
        tags = "@CollectionPageTitle",
        monochrome = true
)
//   tags = "@CollectionPageTitle,@SearchCollection,@VerifyPainting")
public class TestRunner {


}
