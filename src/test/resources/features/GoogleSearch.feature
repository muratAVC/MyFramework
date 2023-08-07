Feature: Users Google page Search to it is wants

  @Google
  Scenario: As a user search
    Given user open google page
    And user write to "zalim" in search box
    And user click to search button or enter key
    And user read to result

  Scenario: Send Google mail
    Given open browser and goto google.mail page
    Then open new mail page
    And write email informations
    And write email details
    And send email

