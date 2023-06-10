Feature: Users Google page Search to it is wants

  @Google
  Scenario: As a user search
    Given user open google page
    And user write to "zalim" in search box
    And user click to search button or enter key
    And user read to result

