@AutoEx
Feature: Automation Exercise Practice

  @AutoExCase26
  Scenario: Automation Exercise test case 26
  Given Navigate to url "http://automationexercise.com"
  And Verify that home page is visible successfully
  And Scroll down page to bottom
  And Verify 'SUBSCRIPTION' is visible
  And Scroll up page to top
  When Verify "Full-Fledged practice website for Automation Engineers" text is visible on screen

  @AutoExCase25
  Scenario:  Automation Exercise test case 25
  Given Navigate to url 'http://automationexercise.com'
  And Verify that home page is visible successfully
  And Scroll down page to bottom
  And Verify 'SUBSCRIPTION' is visible
  And Click on arrow at bottom right side to move upward
  When Verify "Full-Fledged practice website for Automation Engineers" text is visible on screen

  @AutoExCase24
  Scenario: Automation Exercise test case 24
  Given Navigate to url 'http://automationexercise.com'
  And Verify that home page is visible successfully
  And Add products to cart
  And Click Cart button
  And Verify that cart page is displayed
  And Click Proceed To Checkout
  And Click Register Login button
  And Fill all details in Signup and create account
  And Verify ACCOUNT CREATED! and click Continue button
  And Verify  Logged in as username at top
  And Click Cart button
  And Click Proceed To Checkout
  And Verify Address Details and Review Your Order
  And Enter description in comment text area and click Place Order
  And Enter payment details Name on Card, Card Number, CVC, Expiration date
  And Click Pay and Confirm Order button
  And Verify success message "Congratulations! Your order has been confirmed!"
  And Click Download Invoice button and verify invoice is downloaded successfully.
  And Click Continue button
  And Click Delete Account button
  And Verify ACCOUNT DELETED! and click Continue button