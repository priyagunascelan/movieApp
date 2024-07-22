Feature: Test the movie app

  Scenario: We Test the Login Page UI
    When Test whether the Website logo image is displayed
    And Test whether the Heading text is Login present
    And Test whether the Username label text is USERNAME is display
    But Test whether the Password label text is PASSWORD is display
    Then Test the Login button is present

  Scenario Outline: We Test the Login Page Functionalities
    And user enters username as "<Username>"
    And user enters password as "<Password>"
    Then user click login button

    Examples: 
      | Username | Password   |
      |          |            |
      |          | rahul@2021 |
      | rahul    |            |
      | rahul    | rahul      |
      | rahul    | rahul@2021 |

  Scenario: Test the Home Page
    And user enters username as "rahul"
    And user enters password as "rahul@2021"
    Then user click login button
    When Test the heading texts of each section
    And Test whether the play button is displayed or not
    And Test whether the Movies are displayed, in the corresponding movies sections
    Then Test the Contact Us Section

  Scenario: Test the Header Section UI
    And Test whether the Website logo is displayed
    Then Test the Navbar elements
