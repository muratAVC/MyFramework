@Turkiye
Feature: www.turkiye.gov.tr sayfasının örnek testi

Scenario:As a citizen, I should be able to successfully log in and out of turkiye.gov.tr
(Vatandaş Olarak turkiye.gov.tr sayfasında başarılı bir şekilde oturum açıp kapatabilmeliyim)
  Given Start the browser
  When Go to the turkiye web page
  And Verify that the home page appears successfully
  And Click the Register Sign In button
  And Verify that Sign in to your account appears
  And Enter the correct username and password
  And Click the Sign In button
  And Verify that Logged in as username is visible
  And Click the Safe Exit button
  Then Verify that the user is redirected to the login page