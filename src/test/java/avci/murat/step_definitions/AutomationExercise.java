package avci.murat.step_definitions;

import avci.murat.pages.AutomationExercisePage;
import avci.murat.utilities.BrowserTools;
import avci.murat.utilities.Driver;

import com.github.javafaker.Faker;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.an.E;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import io.restassured.internal.common.assertion.AssertionSupport;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import java.time.Duration;
import java.util.*;

public class AutomationExercise {

    private Map<String,String> address= new HashMap<>();

    private ArrayList<String> productTitleList=new ArrayList<>();
    AutomationExercisePage autoEPage=new AutomationExercisePage();
    static Map<String,String> infoPerson=new HashMap<>();



    static {
        Faker faker=new Faker();
        infoPerson.put("name",faker.name().firstName());
        infoPerson.put("email", infoPerson.get("fullName")+"@mail.com");
        infoPerson.put("fullName",faker.name().fullName());
        infoPerson.put("fullAddress",faker.address().fullAddress());
        infoPerson.put("pass",faker.bothify("########"));
        infoPerson.put("dob",faker.date().birthday().getDay()+"");
        infoPerson.put("mob",faker.date().birthday().getMonth()+"");
        infoPerson.put("yob",faker.date().birthday().getYear()+"");
        infoPerson.put("lname",faker.name().lastName());
        infoPerson.put("compName",faker.company().name());
        infoPerson.put("countryName",faker.country().name());
        infoPerson.put("state",faker.address().state());
        infoPerson.put("city",faker.address().city());
        infoPerson.put("zipcode",faker.address().zipCode());
        infoPerson.put("phoneNum",faker.phoneNumber().phoneNumber());
        infoPerson.put("CreditCartNo",faker.finance().creditCard());
    }
    @Given("Navigate to url {string}")
    public void navigate_to_url(String string) {
        Driver.getWebDriver().navigate().to(string);
    }
    @Given("Verify that home page is visible successfully")
    public void verify_that_home_page_is_visible_successfully() {

        BrowserTools.waitFor(10);
        //System.out.println("çalıştım 111111111111111111111111111111111111111");
        Assert.assertTrue(autoEPage.mainPageFoto.isDisplayed());
    }
    @Given("Scroll down page to bottom")
    public void scroll_down_page_to_bottom() {
        BrowserTools.scrollToElement(autoEPage.subcription);
        //BrowserTools.waitFor(5);succes
    }
    @Given("Verify {string} is visible")
    public void verify_is_visible(String string) {
        Assert.assertEquals(string,autoEPage.getSubcription.getText());
    }
    @Given("Scroll up page to top")
    public void scroll_up_page_to_top() {
        BrowserTools.scrollToElement(autoEPage.mainPageFoto);

    }

    @When("Verify {string} text is visible on screen")
    public void verify_text_is_visible_on_screen(String string) {
        Assert.assertEquals(string,autoEPage.text.get(0).getText());

    }

    @And("Click on arrow at bottom right side to move upward")
    public void clickOnArrowAtBottomRightSideToMoveUpward() {
        BrowserTools.scrollToElement(autoEPage.upButton);
        autoEPage.upButton.click();
    }

    @Given("Add products to cart")
    public void add_products_to_cart() {
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            int sayi = random.nextInt(10);
            BrowserTools.scrollToElement(autoEPage.productList.get(sayi));
            autoEPage.productList.get(sayi).click();
            autoEPage.continueShoppingButton.click();
        }

    }
    @Given("Verify that cart page is displayed")
    public void verify_that_cart_page_is_displayed() {
        Assert.assertTrue(autoEPage.cartPage.isDisplayed());
    }
    @Given("Click Proceed To Checkout")
    public void click_proceed_to_checkout() {
            autoEPage.checkoutButton.click();
           // BrowserTools.clickWithJavaScript(autoEPage.checkoutButton);
    }

    @And("Click Register Login button")
    public void clickRegisterLoginButton() {
        autoEPage.regLogButton.click();
    }
    @Given("Fill all details in Signup and create account")
    public void fill_all_details_in_signup_and_create_account() {
        Faker faker=new Faker();
        infoPerson.put("name",faker.name().firstName());
        infoPerson.put("email",faker.name().firstName()+"@mail.com");
        BrowserTools.scrollToElement(autoEPage.signupButton);
        autoEPage.nameInput.sendKeys(infoPerson.get("name"));
        autoEPage.emailInput.sendKeys(infoPerson.get("email"));
        BrowserTools.clickWithJavaScript(autoEPage.signupButton);  // autoEPage.signupButton.click();

    }
    @Given("Verify ACCOUNT CREATED! and click Continue button")
    public void verify_account_created_and_click_continue_button() {
        fill();
        autoEPage.createAccountButton.click();
        autoEPage.continueButton.click();
    }
    @Given("Verify  Logged in as username at top")
    public void verify_logged_in_as_username_at_top() {
        BrowserTools.scrollToElement(autoEPage.topUserName);
        Assert.assertTrue(autoEPage.topUserName.isDisplayed());
    }

    @Given("Click Cart button")
    public void click_cart_button() {
        autoEPage.cartButton.click();
        //BrowserTools.clickWithJavaScript(autoEPage.cartButton);

    }
    @Given("Verify Address Details and Review Your Order")
    public void verify_address_details_and_review_your_order() {
        Assert.assertTrue(autoEPage.addressDelivery.isDisplayed());
        Assert.assertTrue(autoEPage.addressBilling.isDisplayed());
        Assert.assertTrue(autoEPage.cartInfo.isDisplayed());

    }
    @Given("Enter description in comment text area and click Place Order")
    public void enter_description_in_comment_text_area_and_click_place_order() {
        autoEPage.commentArea.sendKeys("merhaba bu işi seviyorum");
        autoEPage.placeOrder.click();

        Actions actions = new Actions(Driver.getWebDriver());
        actions.sendKeys(autoEPage.nameOnCreditCart,infoPerson.get("name"))
                .sendKeys(Keys.TAB)
                .sendKeys(infoPerson.get("CreditCartNo"))
                .sendKeys(Keys.TAB)
                .sendKeys("234")
                .sendKeys(Keys.TAB)
                .sendKeys("05")
                .sendKeys(Keys.TAB)
                .sendKeys("10").perform();

    }
    @Given("Enter payment details Name on Card, Card Number, CVC, Expiration date")
    public void enter_payment_details_name_on_card_card_number_cvc_expiration_date() {
        Actions actions=new Actions(Driver.getWebDriver());
        Faker faker=new Faker();

        actions.sendKeys(autoEPage.nameOnCard,faker.name().name())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.finance().creditCard())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.finance().bic())
                .sendKeys(Keys.TAB)
                .sendKeys("12")
                .sendKeys(Keys.TAB)
                .sendKeys("2031")
                .perform();




    }

    @Given("Click Pay and Confirm Order button")
    public void click_pay_and_confirm_order_button() {
        autoEPage.submitButton.click();
    }

    @Given("Verify success message {string}")
    public void verify_success_message(String string) {
        Assert.assertEquals(string,autoEPage.succesMessage.getText());
    }
    @Given("Click Download Invoice button and verify invoice is downloaded successfully.")
    public void click_download_invoice_button_and_verify_invoice_is_downloaded_successfully() {
        autoEPage.downloadButton.click();
        String filePath="C:\\Users\\murat\\Downloads\\"+"invoice.txt";
        //System.out.println(filePath);
        //System.out.println("dosya vadmı"+BrowserTools.verifyFileDownloaded(filePath));
        BrowserTools.waitFor(2);
        Assert.assertTrue(BrowserTools.verifyFileDownloaded(filePath));


    }
    @Given("Click Continue button")
    public void click_continue_button() {
        autoEPage.downloadButton.click();
    }
    @Given("Click Delete Account button")
    public void click_delete_account_button() {
        System.out.println(infoPerson.get("name"));
        System.out.println(infoPerson.get("email"));
        autoEPage.deleteAccount.click();
    }

    @Given("Verify ACCOUNT DELETED! and click Continue button")
    public void verify_account_deleted_and_click_continue_button() {
        //Assert.assertTrue(autoEPage.accountDeleted.isDisplayed());
        //autoEPage.continueButtonAfterDeleted.click();
    }


    @And("Click Signup-Login button")
    public void clickSignupLoginButton() {
        autoEPage.singupLoinButton.click();
    }

    @And("Verify that the delivery address is same address filled at the time registration of account")
    public void verifyThatTheDeliveryAddressIsSameAddressFilledAtTheTimeRegistrationOfAccount() {
        Assert.assertEquals(infoPerson.get("fullAddress"),autoEPage.deliveryAddress.getText());
    }

    @And("Verify that the billing address is same address filled at the time registration of account")
    public void verifyThatTheBillingAddressIsSameAddressFilledAtTheTimeRegistrationOfAccount() {
        Assert.assertEquals(infoPerson.get("fullAddress"),autoEPage.billingAddress.getText());
    }

    @And("Scroll to bottom of page")
    public void scrollToBottomOfPage() {
        BrowserTools.scrollToElement(autoEPage.recommendedItems);
    }

    @And("Verify RECOMMENDED ITEMS are visible")
    public void verifyRECOMMENDEDITEMSAreVisible() {
        Assert.assertTrue(autoEPage.recommendedItems.isDisplayed());
    }

    @And("Click on Add To Cart on Recommended product")
    public void clickOnAddToCartOnRecommendedProduct() {
        for (int i = 0; i < autoEPage.recomProList.size()-2; i++) {
            if (!BrowserTools.waitElementIsDisplayed(autoEPage.recomProList.get(i))){
                autoEPage.recomProList.get(7).click();
            }
            autoEPage.recomProList.get(i).click();
            productTitleList.add(autoEPage.getRecomProListTitle.get(i).getText());
            if (i!=autoEPage.recomProList.size()-3) autoEPage.continueShoppingButton.click();
            else autoEPage.viewCartButton.click();

        }
    }

    @And("Click on Products button")
    public void clickOnProductsButton() {
        autoEPage.productsButton.click();

    }

    @And("Verify user is navigated to ALL PRODUCTS page successfully")
    public void verifyUserIsNavigatedToALLPRODUCTSPageSuccessfully() {
        Assert.assertTrue(autoEPage.allProductsHeadText.isDisplayed());
        int countProduct=autoEPage.allProductList.size();//gösterilen tüm ürünlerin sayısı

        int productCount=0;
        for (int i = 0; i < autoEPage.differentProductCount.size(); i++) {
            String str=autoEPage.differentProductCount.get(i).getText();
            str=str.substring(1,str.length()-1);
            productCount+=Integer.parseInt(str);
        }
        Assert.assertEquals(countProduct,productCount);
    }

    @And("Click on View Product button")
    public void clickOnViewProductButton() {
        autoEPage.allPoductViewList.get(2).sendKeys(Keys.ENTER);

    }

    @And("Verify Write Your Review is visible")
    public void verifyWriteYourReviewIsVisible() {
        Assert.assertTrue(autoEPage.reviewMessage.isDisplayed());
        Assert.assertTrue(autoEPage.nameArea.isDisplayed());
        Assert.assertTrue(autoEPage.emailArea.isDisplayed());
        Assert.assertTrue(autoEPage.reviewArea.isDisplayed());
    }

    @And("Enter name, email and review")
    public void enterNameEmailAndReview() {
        Faker faker =new Faker();
        autoEPage.nameArea.sendKeys(faker.name().fullName());
        autoEPage.emailArea.sendKeys(faker.name().firstName()+"@mail.com");
        autoEPage.reviewArea.sendKeys(faker.elderScrolls().firstName());//hahahaha
    }

    @And("Click Submit button")
    public void clickSubmitButton() {
        BrowserTools.waitFor(5);
        autoEPage.reviewSubmitButton.click();
    }

    @And("Verify success message Thank you for your review.")
    public void verifySuccessMessageThankYouForYourReview() {
        Assert.assertTrue(autoEPage.successAlert.isDisplayed());
    }

    @And("Enter product name in search input and click search button")
    public void enterProductNameInSearchInputAndClickSearchButton() {
        autoEPage.searchInput.sendKeys("Dress");
        autoEPage.submitSearch.click();
    }

    @And("Verify SEARCHED PRODUCTS is visible")
    public void verifySEARCHEDPRODUCTSIsVisible() {
        for (WebElement element:autoEPage.searchedProductList) {
            BrowserTools.verifyElementIsDisplayed(element);
        }
    }

    @And("Verify all the products related to search are visible")
    public void verifyAllTheProductsRelatedToSearchAreVisible() {
        for (WebElement element:autoEPage.searchedProductList) {
            BrowserTools.verifyElementIsDisplayed(element);
            productTitleList.add(element.getText());
        }



    }

    @And("Add those products to cart")
    public void addThoseProductsToCart() {
        for (WebElement e :autoEPage.SPLAddButton) {
            BrowserTools.scrollToElement(e);
            e.click();
            autoEPage.continueShoppingButton.click();
        }
    }

    @And("Click Cart button and verify that products are visible in cart")
    public void clickCartButtonAndVerifyThatProductsAreVisibleInCart() {
        int i=0;
        autoEPage.cartButton.click();
        for (WebElement element : autoEPage.productInCartTitle) {
            Assert.assertEquals(element.getText(),productTitleList.get(i));
            i++;
        }
    }

    @And("Click Signup Login button and submit login details")
    public void clickSignupLoginButtonAndSubmitLoginDetails() {
            clickSignupLoginButton();
            fill_all_details_in_signup_and_create_account();
            verify_account_created_and_click_continue_button();
            verify_logged_in_as_username_at_top();
    }

    @And("Again, go to Cart page")
    public void againGoToCartPage() {
        autoEPage.cartButton.click();
    }

    @And("Verify that those products are visible in cart after login as well")
    public void verifyThatThoseProductsAreVisibleInCartAfterLoginAsWell() {
        int i=0;
        for (WebElement element : autoEPage.productInCartTitle) {
            Assert.assertEquals(element.getText(),productTitleList.get(i));
            i++;
        }

        click_delete_account_button();
        verify_account_deleted_and_click_continue_button();
    }
    @And("Verify New User Signup! is visible")
    public void verifyNewUserSignupIsVisible() {
        Assert.assertTrue(autoEPage.newUserSignupMessage.isDisplayed());
    }
    @And("Enter name and email address")
    public void enterNameAndEmailAddress() {
        BrowserTools.scrollToElement(autoEPage.signupButton);
        autoEPage.nameInput.sendKeys(infoPerson.get("name"));
        autoEPage.emailInput.sendKeys(infoPerson.get("email"));
        //BrowserTools.clickWithJavaScript(autoEPage.signupButton);  // autoEPage.signupButton.click();

    }

    @And("Click Signup button")
    public void clickSignupButton() {
        autoEPage.signupButton.click();
    }

    @And("Verify that ENTER ACCOUNT INFORMATION is visible")
    public void verifyThatENTERACCOUNTINFORMATIONIsVisible() {
        for (WebElement elem: autoEPage.infoPersonTitle) {
            BrowserTools.scrollToElement(elem);
            Assert.assertTrue(elem.isDisplayed());
        }
    }

    @And("Fill details: Title, Name, Email, Password, Date of birth")
    public void fillDetailsTitleNameEmailPasswordDateOfBirth() {
        fill();
    }

    private void fill(){
        Actions actions= new Actions(Driver.getWebDriver());
        Random random=new Random();
        if (random.nextBoolean()){
            actions.click(autoEPage.genderMale)
                    .sendKeys(Keys.TAB)
                    //.sendKeys(faker.name().name())
                    .sendKeys(Keys.TAB)
                    .sendKeys(infoPerson.get("pass"))
                    .sendKeys(Keys.TAB)
                    .sendKeys(infoPerson.get("dob"))
                    .sendKeys(Keys.TAB)
                    .sendKeys(infoPerson.get("mob"))
                    .sendKeys(Keys.TAB)
                    .sendKeys(infoPerson.get("yob"))
                    .sendKeys(Keys.TAB)
                    .sendKeys(Keys.TAB)
                    .sendKeys(Keys.TAB)
                    .sendKeys(infoPerson.get("name"))
                    .sendKeys(Keys.TAB)
                    .sendKeys(infoPerson.get("lname"))
                    .sendKeys(Keys.TAB)
                    .sendKeys(infoPerson.get("compName"))
                    .sendKeys(Keys.TAB)
                    .sendKeys(infoPerson.get("fullAddress"))
                    .sendKeys(Keys.TAB)
                    .sendKeys(Keys.TAB)
                    .sendKeys(infoPerson.get("countryName"))//burda kaldım
                    .sendKeys(Keys.TAB)
                    .sendKeys(infoPerson.get("state"))
                    .sendKeys(Keys.TAB)
                    .sendKeys(infoPerson.get("city"))
                    .sendKeys(Keys.TAB)
                    .sendKeys(infoPerson.get("zipcode"))
                    .sendKeys(Keys.TAB)
                    .sendKeys(infoPerson.get("phoneNum"))
                    .sendKeys(Keys.TAB)
                    .click().perform();

        }else{
            actions.click(autoEPage.genderFemale)
                    .sendKeys(Keys. TAB)
                    .sendKeys(Keys.TAB)
                    .sendKeys(infoPerson.get("pass"))
                    .sendKeys(Keys.TAB)
                    .sendKeys(infoPerson.get("dob"))
                    .sendKeys(Keys.TAB)
                    .sendKeys(infoPerson.get("mob"))
                    .sendKeys(Keys.TAB)
                    .sendKeys(infoPerson.get("yob"))
                    .sendKeys(Keys.TAB)
                    .sendKeys(Keys.TAB)
                    .sendKeys(Keys.TAB)
                    .sendKeys(infoPerson.get("name"))
                    .sendKeys(Keys.TAB)
                    .sendKeys(infoPerson.get("lname"))
                    .sendKeys(Keys.TAB)
                    .sendKeys(infoPerson.get("compName"))
                    .sendKeys(Keys.TAB)
                    .sendKeys(infoPerson.get("fullAddress"))
                    .sendKeys(Keys.TAB)
                    .sendKeys(Keys.TAB)
                    .sendKeys(infoPerson.get("countryName"))//burda kaldım
                    .sendKeys(Keys.TAB)
                    .sendKeys(infoPerson.get("state"))
                    .sendKeys(Keys.TAB)
                    .sendKeys(infoPerson.get("city"))
                    .sendKeys(Keys.TAB)
                    .sendKeys(infoPerson.get("zipcode"))
                    .sendKeys(Keys.TAB)
                    .sendKeys(infoPerson.get("phoneNum"))
                    .sendKeys(Keys.TAB)
                    .click().perform();
        }
    }

    @And("Select checkbox Sign up for our newsletter!")
    public void selectCheckboxSignUpForOurNewsletter() {
        if(!autoEPage.newsletterCheckBox.isSelected()) autoEPage.newsletterCheckBox.click();
    }

    @And("Select checkbox Receive special offers from our partners!")
    public void selectCheckboxReceiveSpecialOffersFromOurPartners() {
        if(!autoEPage.optinCheckBox.isSelected()) autoEPage.optinCheckBox.click();
    }

    @And("Click Create Account button")
    public void clickCreateAccountButton() {
        BrowserTools.scrollToElement(autoEPage.createAccountButton);
        autoEPage.createAccountButton.click();
    }

    @And("Verify that ACCOUNT CREATED! is visible")
    public void verifyThatACCOUNTCREATEDIsVisible() {

    }

    @And("Verify that ACCOUNT DELETED! is visible and click Continue button")
    public void verifyThatACCOUNTDELETEDIsVisibleAndClickContinueButton() {
        Assert.assertTrue(autoEPage.accountDeleted.isDisplayed());
        autoEPage.continueButtonAfterDeleted.click();
    }

    @And("Verify that Logged in as username is visible in Auto")
    public void verifyThatLoggedInAsUsernameIsVisibleInAuto() {
        Assert.assertEquals(infoPerson.get("name"),autoEPage.userName.getText());
        Assert.assertTrue(autoEPage.userName.isDisplayed());
    }

    @And("Verify Login to your account is visible")
    public void verifyLoginToYourAccountIsVisible() {
        Assert.assertTrue(autoEPage.loginYourAccountMessage.isDisplayed());
    }

    @Given("Sign up")
    public void signUp() {
        navigate_to_url("http://automationexercise.com");
        autoEPage.singupLoinButton.click();
        Faker faker=new Faker();
        infoPerson.put("name",faker.name().firstName());
        BrowserTools.scrollToElement(autoEPage.signupButton);
        autoEPage.nameInput.sendKeys(infoPerson.get("name"));
        infoPerson.put("email",infoPerson.get("name")+"@mail.com");
        autoEPage.emailInput.sendKeys(infoPerson.get("email"));
        BrowserTools.clickWithJavaScript(autoEPage.signupButton);  // autoEPage.signupButton.click();

        fill();
        autoEPage.createAccountButton.click();
        autoEPage.continueButton.click();
        BrowserTools.scrollToElement(autoEPage.topUserName);
        Assert.assertTrue(autoEPage.topUserName.isDisplayed());
        System.out.println(infoPerson.get("name"));
        System.out.println(infoPerson.get("email"));
        System.out.println(infoPerson.get("pass"));
        BrowserTools.writeExel(infoPerson);



    }

    @And("Enter correct email address and password")
    public void enterCorrectEmailAddressAndPassword() {
        infoPerson=BrowserTools.exelRead();
        autoEPage.loginEMailBox.sendKeys(infoPerson.get("email"));
        autoEPage.loginPasswordBox.sendKeys(BrowserTools.exelRead().get("pass"));
        autoEPage.loginButton.click();
    }

    @And("Verify that Logged in as user name is visible")
    public void verifyThatLoggedInAsUserNameIsVisible() {
        Assert.assertTrue(autoEPage.userName.isDisplayed());
    }


    @And("Verify error Your email or password is incorrect! is visible")
    public void verifyErrorYourEmailOrPasswordIsIncorrectIsVisible() {
        Assert.assertTrue(autoEPage.incorrectInfoMessage.isDisplayed());
    }

    @And("Enter incorrect {string} address and {string}")
    public void enterIncorrectAddressAnd(String arg0, String arg1) {
        autoEPage.loginEMailBox.sendKeys(arg0);
        autoEPage.loginPasswordBox.sendKeys(arg1);
        autoEPage.loginButton.click();
    }

    @And("Verify that Logged in as username is visible")
    public void verifyThatLoggedInAsUsernameIsVisible() {
        Assert.assertTrue(autoEPage.userName.isDisplayed());
    }

    @And("Click Logout button")
    public void clickLogoutButton() {
        autoEPage.logoutButton.click();
    }

    @And("Verify that user is navigated to login page")
    public void verifyThatUserIsNavigatedToLoginPage() {
            Assert.assertTrue(autoEPage.loginPageMessages.size()!=0);
    }

    @And("Verify that product is displayed in cart page")
    public void verifyThatProductIsDisplayedInCartPage() {
        for (int i = 0; i < productTitleList.size(); i++) {
            System.out.println(autoEPage.productInCartTitle.get(i).getText()+"--"+productTitleList.get(i));
            Assert.assertEquals(autoEPage.productInCartTitle.get(i).getText(),productTitleList.get(i));
        }
    }

    @And("Enter name and already registered email address")
    public void enterNameAndAlreadyRegisteredEmailAddress() {
        autoEPage.nameInput.sendKeys(BrowserTools.exelRead().get("name"));
        autoEPage.emailInput.sendKeys(BrowserTools.exelRead().get("email"));
    }

    @And("Verify error Email Address already exist! is visible")
    public void verifyErrorEmailAddressAlreadyExistIsVisible() {
        Assert.assertTrue(autoEPage.emailAlreadyExistMessage.isDisplayed());
    }

    @And("Click on Contact Us button")
    public void clickOnContactUsButton() {
        autoEPage.contactUsButton.click();
    }

    @And("Verify GET IN TOUCH is visible")
    public void verifyGETINTOUCHIsVisible() {
        Assert.assertTrue(autoEPage.getInTouchMessage.isDisplayed());
    }

    @And("Enter name, email, subject and message")
    public void enterNameEmailSubjectAndMessage() {
            autoEPage.nameBoxWithContactUs.sendKeys(infoPerson.get("fullName"));
            autoEPage.emailBoxWithContactUs.sendKeys(infoPerson.get("email"));
            autoEPage.subjectBoxWithContactUs.sendKeys("harika bir ürün");
            autoEPage.messageBoxWithContactUs.sendKeys("aldığım en harika ürün bu. gerçekten güzel. falan filan lsjfkjhgkdjngdk ");

    }

    @And("Upload file")
    public void uploadFile() {
        String filePath="C:\\Users\\murat\\Downloads\\"+"invoice.txt";
        autoEPage.uploadFileButton.sendKeys(filePath);
    }

    @And("Click Submit button With Contact Us")
    public void clickSubmitButtonWithContactUs() {
        BrowserTools.scrollToElement(autoEPage.submitButtonWithContactUs);
        autoEPage.submitButtonWithContactUs.click();
    }

    @And("Click OK button")
    public void clickOKButton() {

        WebDriverWait wait = new WebDriverWait(Driver.getWebDriver(), Duration.ofSeconds(5000));
        wait.until(ExpectedConditions.alertIsPresent());
        Driver.getWebDriver().switchTo().alert().accept();

    }

    @And("Verify success message Success! Your details have been submitted successfully. is visible")
    public void verifySuccessMessageSuccessYourDetailsHaveBeenSubmittedSuccessfullyIsVisible() {
        Assert.assertTrue(autoEPage.successMessage.isDisplayed());
    }

    @And("Click Home button and verify that landed to home page successfully")
    public void clickHomeButtonAndVerifyThatLandedToHomePageSuccessfully() {
        autoEPage.homeButton.click();
        Assert.assertTrue(autoEPage.mainPageFoto.isDisplayed());
    }

    @And("Click on Test Cases button")
    public void clickOnTestCasesButton() {
        Driver.getWebDriver().findElement(By.xpath("//ul[contains(@class,\"nav navbar-nav\")]//li[5]")).click();
    }

    @And("Verify user is navigated to test cases page successfully")
    public void verifyUserIsNavigatedToTestCasesPageSuccessfully() {
        Assert.assertTrue(Driver.getWebDriver().findElement(By.xpath("//*[contains(@class,\"title text-center\")]")).isDisplayed());
    }


    @And("Click on View Product of first product")
    public void clickOnViewProductOfFirstProduct() {
        BrowserTools.scrollToElement(autoEPage.getAllProductListWiewButton.get(0));
        autoEPage.getAllProductListWiewButton.get(0).click();

    }

    @And("User is landed to product detail page")
    public void userIsLandedToProductDetailPage() {
        Assert.assertTrue(autoEPage.productDetailPage.isDisplayed());
    }

    @And("Verify that detail detail is visible: product name, category, price, availability, condition, brand")
    public void verifyThatDetailDetailIsVisibleProductNameCategoryPriceAvailabilityConditionBrand() {
        Assert.assertTrue(autoEPage.productDetailName.isDisplayed());
        Assert.assertTrue(autoEPage.productDetailPrice.isDisplayed());
        Assert.assertTrue(autoEPage.productDetailCategory.isDisplayed());
        for (WebElement e:autoEPage.productNCB) {
            Assert.assertTrue(e.isDisplayed());
        }

    }

    @And("Scroll down to footer")
    public void scrollDownToFooter() {
        BrowserTools.scrollToElement(autoEPage.getSubcription);
    }

    @And("Verify text SUBSCRIPTION")
    public void verifyTextSUBSCRIPTION() {
        Assert.assertTrue(autoEPage.getSubcription.isDisplayed());
    }

    @And("Enter email address in input and click arrow button")
    public void enterEmailAddressInInputAndClickArrowButton() {
        autoEPage.subscribeEmail.sendKeys(BrowserTools.exelRead().get("email"));
        autoEPage.subscribeButton.click();
    }

    @And("Verify success message You have been successfully subscribed! is visible")
    public void verifySuccessMessageYouHaveBeenSuccessfullySubscribedIsVisible() {
        Assert.assertTrue(autoEPage.hiddenSubscribeMessage.isDisplayed());
    }


    @And("Hover over first product and click Add to cart")
    public void hover_over_first_product_and_click_add_to_cart() {
        productTitleList.add(autoEPage.allProductTitleList.get(0).getText());

        JavascriptExecutor jse=(JavascriptExecutor) Driver.getWebDriver();
        jse.executeScript("window.scrollBy(0, 30);");
        BrowserTools.clickWithJavaScript(autoEPage.allProductAddtoCartButtonList.get(0));
        //autoEPage.allProductAddtoCartButtonList.get(0).click();
        BrowserTools.waitFor(10);
    }

/*    @AfterMethod
    public void addDefect(){
        try {
            if(autoEPage.addOn1.isDisplayed()){
                autoEPage.addOn1.click();
            }
        } catch (Exception e)
        {
            System.out.println("çıkmadı namussuz");
        }
    }*/

    @And("Click Continue Shopping button")
    public void clickContinueShoppingButton() {
        autoEPage.continueShoppingButton.click();
    }

    @And("Hover over second product and click Add to cart")
    public void hoverOverSecondProductAndClickAddToCart() {
        BrowserTools.scrollToElement(autoEPage.allProductAddtoCartButtonList.get(1));
        productTitleList.add(autoEPage.allProductTitleList.get(1).getText());
        autoEPage.allProductAddtoCartButtonList.get(1).click();
    }

  /*  @Given("Click View Cart button")
    public void click_view_cart_button() {
        autoEPage.viewCartButton.click();
    }*/

    @And("Click View Cart button")
    public void clickViewCartButton() {
        autoEPage.viewCartButton.click();
    }

    @And("Verify both products are added to Cart")
    public void verifyBothProductsAreAddedToCart() {
        int i=0;
        for (WebElement e:autoEPage.productInCartTitle) {
            Assert.assertEquals(productTitleList.get(i), e.getText());
            i++;
        }

    }

    @And("Verify their prices, quantity and total price")
    public void verifyTheirPricesQuantityAndTotalPrice() {
        for (int i = 0; i < autoEPage.productInCartTitle.size(); i++) {
            String str=autoEPage.productInCartPrice.get(i).getText().substring(4);
            int a=Integer.parseInt(str);
            int b=Integer.parseInt(autoEPage.productInCartQuantity.get(i).getText());
            int c=Integer.parseInt(autoEPage.productInCartTotalPrice.get(i).getText().substring(4));
            Assert.assertEquals(a*b,c);
        }
    }

    @Given("Click View Product for any product on home page")
    public void click_view_product_for_any_product_on_home_page() {
        BrowserTools.clickWithJavaScript(autoEPage.allPoductViewList.get(1));//restgele bir element
        //BrowserTools.scrollToElement(autoEPage.allPoductViewList.get(1));
//        JavascriptExecutor jse=(JavascriptExecutor) Driver.getWebDriver();
//        jse.executeScript("window.scrollBy(0, 30);");
//        autoEPage.allPoductViewList.get(1).click();


    }

    @Given("Verify product detail is opened")
    public void verify_product_detail_is_opened() {
        Assert.assertTrue(autoEPage.productDetailsPicture.isDisplayed());
        infoPerson.put("ProductName",autoEPage.productInfoDetailsTitle.getText());
    }

    @Given("Increase quantity to {int}")
    public void increase_quantity_to(Integer int1) {
        Actions actions=new Actions(Driver.getWebDriver());
        actions.keyDown(autoEPage.productDetailsQuantity,Keys.CONTROL)
               .sendKeys("a")//bu kısım bir input box taki varolan bilgiyi silmek için kullanılır
               .keyUp(Keys.CONTROL)
               .sendKeys(Keys.DELETE)
               .perform();
        autoEPage.productDetailsQuantity.sendKeys(String.valueOf(int1));
    }

    @Given("Click Add to cart button")
    public void click_add_to_cart_button() {
        autoEPage.addToCartButtonInProductDetailsPage.click();
    }

    @Given("Verify that product is displayed in cart page with exact quantity")
    public void verify_that_product_is_displayed_in_cart_page_with_exact_quantity() {
        int i=0;
        for (WebElement element :autoEPage.productInCartTitle) {
            if (element.getText().equals(infoPerson.get("ProductName"))){
                Assert.assertEquals("4",autoEPage.productInCartQuantity.get(i).getText());
            }
            i++;
        }
    }


    @And("Enter payment details")
    public void enterPaymentDetails() {
        Actions actions = new Actions(Driver.getWebDriver());
        actions.sendKeys(autoEPage.nameOnCreditCart,infoPerson.get("name"))
                .sendKeys(Keys.TAB)
                .sendKeys(infoPerson.get("CreditCartNo"))
                .sendKeys(Keys.TAB)
                .sendKeys("234")
                .sendKeys(Keys.TAB)
                .sendKeys("05")
                .sendKeys(Keys.TAB)
                .sendKeys("10").perform();

    }
}
