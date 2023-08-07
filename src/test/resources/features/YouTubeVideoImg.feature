Feature: Get the latest video's picture from the videos tab on any youtube channel
  (Herhangi bir youtube kanalındaki ilk videonun resmini alma)


Scenario: Get the latest video's picture from the videos tab on any youtube channel
Given open browser and go to youtube channel
When go to the videos tab
And find the latest video and get your picture