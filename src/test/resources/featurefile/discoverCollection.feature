Feature: Discover more about the museum and Vincent van Gogh

  Background:
#  Given : Home page is loaded and user click on link "Ontdek de collectie"
    Given : Website cookie is accepted and Home page is loaded
    And   :  verify home page title as "Van Gogh Museum - Hét museum over Vincent van Gogh in Amsterdam"
    Then : Click on link "Ontdek de collectie" in the home page


  @CollectionPageTitle
  Scenario Outline: Discover Van Gogh museum collection with <ScenarioCondition>
    Then  : Collection page is loaded with title <PageTitle>
    And   : Verify that you get more than <PaintingsCount> results

    Examples:
      | ScenarioCondition                           | PageTitle                     | PaintingsCount |
      | valid title and atleast 1 painting is shown | "Collectie - Van Gogh Museum" | 0              |
      | invaliid title                              | "Collectie - Van Gogh Museu"  | 0              |

  @SearchCollection
  Scenario Outline: Search the painting with title “Het Gele Huis” from the search box with <ScenarioCondition>
    Given : painting with title <PaintingName> is searched from the search box
    Then  : Verify that you get more than <PaintingsCount> results


    Examples:
      | ScenarioCondition                             | PaintingName    | PaintingsCount    |
      | Correct PaintingName and PaintingCount >700   | "Het Gele Huis" | 700               |
      | Incorrect PaintingName and valid count number | "123a"          | 700               |
      | Incorrect PaintingName                        | "123"           | "Geen resultaten" |


  @VerifyPainting
  Scenario Outline: Search the painting with title “Het Gele Huis” from the search box with <ScenarioCondition>
    Given : painting with title <PaintingName> is searched from the search box
    And   : Click on the <PaintingNumber> result
    Then  : Verify the painting you get by checking <F-nummer>, <JH-nummer> and <Inventarnummer>

    Examples:
      | ScenarioCondition                    | PaintingName    | PaintingNumber | F-nummer | JH-nummer | Inventarnummer |
      | all correct test data                | "Het Gele Huis" | 1              | "F0464"  | "JH1589"  | "s0032V1962"   |
      | mismatch in Painting Name and number | "Het Gele Huis" | 2              | "F0464"  | "JH1589"  | "s0032V1962"   |
      | incorrect Fnummer                    | "Het Gele Huis" | 1              | "F046"   | "JH1589"  | "s0032V1962"   |
      | incorrect JHnummer                   | "Het Gele Huis" | 1              | "F0464"  | "JH15"    | "s0032V1962"   |
      | incorrect Inventarnummer             | "Het Gele Huis" | 1              | "F0464"  | "JH1589"  | "s003"         |

