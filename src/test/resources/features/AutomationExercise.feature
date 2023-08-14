@AutoEx
Feature: Automation Exercise Practice

  @AutoExCase01
  Scenario: Automation Exercise Practice Test Case 1
  Given Navigate to url 'http://automationexercise.com'
  And Verify that home page is visible successfully
  And Click Signup-Login button
  And Verify New User Signup! is visible
  And Enter name and email address
  And Click Signup button
  And Verify that ENTER ACCOUNT INFORMATION is visible
  And Fill details: Title, Name, Email, Password, Date of birth
  And Select checkbox Sign up for our newsletter!
  And Select checkbox Receive special offers from our partners!
#  And Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
  And Click Create Account button
  And Verify that ACCOUNT CREATED! is visible
  And Click Continue button
  And Verify that Logged in as username is visible in Auto
  And Click Delete Account button
  And Verify that ACCOUNT DELETED! is visible and click Continue button

    @AutoExCase02
  Scenario: Automation Exercize Practice 2
  Given Navigate to url 'http://automationexercise.com'
  And Verify that home page is visible successfully
  And Click Signup-Login button
  And Verify Login to your account is visible
  And Enter correct email address and password
#  And Click login button
  And Verify that Logged in as user name is visible
  And Click Delete Account button
  And Verify that ACCOUNT DELETED! is visible and click Continue button

      @SignUp
  Scenario: Sign up Automation exercise
    Given Sign up

    @AutoExCase03
Scenario Outline: Automation Exercise testCase 3
Given Navigate to url 'http://automationexercise.com'
And Verify that home page is visible successfully
And Click Signup-Login button
And Verify Login to your account is visible
And Enter incorrect "<email>" address and "<password>"
#And Click login button
And Verify error Your email or password is incorrect! is visible

      Examples: informations
        | email             | password |
        | cartcurt@mail.com | 1235685  |
        |murat@gmail.com    |6416856   |

@AutoExCase04
  Scenario: Automation exercise test case 4
  Given Navigate to url 'http://automationexercise.com'
  And Verify that home page is visible successfully
  And Click Signup-Login button
  And Verify Login to your account is visible
  And Enter correct email address and password
  #And Click login button
  And Verify that Logged in as username is visible
  And Click Logout button
  And Verify that user is navigated to login page

  @AutoExCase05
  Scenario: Automation Exercise Test Case  Register User with existing email
  Given Navigate to url 'http://automationexercise.com'
  And Verify that home page is visible successfully
  And Click Signup-Login button
  And Verify New User Signup! is visible
  And Enter name and already registered email address
  And Click Signup button
  And Verify error Email Address already exist! is visible


    @AutoExCase06
  Scenario: Automaton Exercise test case 06
  Given Navigate to url 'http://automationexercise.com'
  And Verify that home page is visible successfully
  And Click on Contact Us button
  And Verify GET IN TOUCH is visible
  And Enter name, email, subject and message
  And Upload file
  And Click Submit button With Contact Us
  And Click OK button
  And Verify success message Success! Your details have been submitted successfully. is visible
  And Click Home button and verify that landed to home page successfully


@AutoExCase07
  Scenario: Automation Exercise Test Case 7
Given Navigate to url 'http://automationexercise.com'
And Verify that home page is visible successfully
And Click on Test Cases button
And Verify user is navigated to test cases page successfully

  @AutoExCase08
    Scenario: Automation Exercise Tast case 08
  Given Navigate to url 'http://automationexercise.com'
  And Verify that home page is visible successfully
  And Click on Products button
  And Verify user is navigated to ALL PRODUCTS page successfully
#  And The products list is visible
  And Click on View Product of first product
  And User is landed to product detail page
  And Verify that detail detail is visible: product name, category, price, availability, condition, brand





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


  @AutoExCase23
    Scenario: Automation exercize trst case 23
    Given Navigate to url 'http://automationexercise.com'
    And Verify that home page is visible successfully
    And Click Signup-Login button
    And Fill all details in Signup and create account
    And Verify ACCOUNT CREATED! and click Continue button
    And Verify  Logged in as username at top
    And Add products to cart
    And Click Cart button
    And Verify that cart page is displayed
    And Click Proceed To Checkout
    And Verify that the delivery address is same address filled at the time registration of account
    And Verify that the billing address is same address filled at the time registration of account
    And Click Delete Account button
    And Verify ACCOUNT DELETED! and click Continue button

  @AutoExCase22
  Scenario: Automation exercize Test case 22
  Given Navigate to url 'http://automationexercise.com'
  And Scroll to bottom of page
  And Verify RECOMMENDED ITEMS are visible
  And Click on Add To Cart on Recommended product
  And Verify that product is displayed in cart page

    @AutoExCase21
    Scenario: Add review on product
    Given Navigate to url 'http://automationexercise.com'
    And Click on Products button
    And Verify user is navigated to ALL PRODUCTS page successfully
    And Click on View Product button
    And Verify Write Your Review is visible
    And Enter name, email and review
    And Click Submit button
    And Verify success message Thank you for your review.


      @AutoExCase20
  Scenario: Search Products and Verify Cart After Login
  Given Navigate to url 'http://automationexercise.com'
  And Click on Products button
  And Verify user is navigated to ALL PRODUCTS page successfully
  And Enter product name in search input and click search button
  And Verify SEARCHED PRODUCTS is visible
  And Verify all the products related to search are visible
  And Add those products to cart
  And Click Cart button and verify that products are visible in cart
  And Click Signup Login button and submit login details
  And Again, go to Cart page
  And Verify that those products are visible in cart after login as well