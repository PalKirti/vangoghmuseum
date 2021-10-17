# Project Name: vangoghmuseum
UI Automation with Selenium, Cucumber, Java8, Page Object Model, Maven , Git and circleci

## Requirements:
Below dependencies needs to be installed/configured
- Java 8 or higher (JAVA_HOME and PATH in environmental variables)
- Maven (M2, MAVEN_HOME and PATH in environmental variables)
- cucumber plugins preferred
- IDE (IntelliJ is preferred)

## Downloading Project:
- Using git command: https://github.com/PalKirti/vangoghmuseum.git


## Execution:
1.. Run via TestRunner

Click on the run button on your IDE or right click on your TestRunner file and click RUN
Execute only pom.xml file

Below scenarios are mentioned in disciverCollection.feature file:

 1) Validate Van Gogh museum collection page with both postive and negative test data
 2) Search the painting with title “Het Gele Huis” from the search box with both postive and negative test data
 3) Verify selected painting details by checking Fnummer, JHnummer and Inventarnummer with positive and negative test data

2.. Run via terminal

Running a specific tag from specific feature file
mvn test -Dcucumber.options=<path of the featurefile.feature> -Dcucumber.options="--tags @Smoke"
example:
mvn clean test -Dcucumber.options=src/test/resources/featurefile/discoverCollection.feature -Dcucumber.options="--tags CollectionPageTitle"

Running a Feature file only from Command Line
mvn test -Dcucumber.options="src/test/resources/featurefile/discoverCollection.feature"

Running Scenarios using Tags from Command Line
mvn test -Dcucumber.options="--tags @tag Name"


3.. Continuous Integration
Project is configured in circleCI


##Important points to remember:
- ***Logging:*** Logs with INFO ,ERROE and DEBUG level are implemented. Log level can be modified by updating log4j.properties
- ***Unused Methods:*** Methods to return RemoteWebDriver are not used in the project
- ***Test Report:*** Test Report is saved in Target folder.Each feature html report can be viewed under cucumber-reports and Cucumber report can  be viewed in cucumber-report-html ->cucumber-html-reports->feature-overview.html
- ***Screenshots:*** Screenshots are capturted for failure scenarios and are stored in folder screenshots
- ***Logs:*** Logs are saved in location - log
- ***.gitignore:*** reports/, .idea/, log/, target/ are covered in .gitignore file

***There are still some bit & pieces to be completed to make the framework perfect***

