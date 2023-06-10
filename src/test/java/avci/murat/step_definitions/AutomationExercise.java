package avci.murat.step_definitions;

import avci.murat.pages.AutomationExercisePage;
import avci.murat.utilities.BrowserTools;
import avci.murat.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.Random;

public class AutomationExercise {
    AutomationExercisePage autoEPage=new AutomationExercisePage();
    @Given("Navigate to url {string}")
    public void navigate_to_url(String string) {
        Driver.getWebDriver().navigate().to(string);
    }
    @Given("Verify that home page is visible successfully")
    public void verify_that_home_page_is_visible_successfully() {
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
    @Given("Click {string} button")
    public void click_button(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Given("Verify that cart page is displayed")
    public void verify_that_cart_page_is_displayed() {

        Assert.assertTrue(autoEPage.cartPage.isDisplayed());
    }
    @Given("Click Proceed To Checkout")
    public void click_proceed_to_checkout() {
            autoEPage.checkoutButton.click();
    }
    @And("Click Register Login button")
    public void clickRegisterLoginButton() {
        autoEPage.regLogButton.click();
    }

    @Given("Fill all details in Signup and create account")
    public void fill_all_details_in_signup_and_create_account() {
        Faker faker=new Faker();
        autoEPage.nameInput.sendKeys(faker.name().firstName());
        autoEPage.emailInput.sendKeys(faker.name().firstName()+"@mail.com");
        autoEPage.signupButton.click();

    }
    @Given("Verify ACCOUNT CREATED! and click Continue button")
    public void verify_account_created_and_click_continue_button() {
        Actions actions= new Actions(Driver.getWebDriver());
        Random random=new Random();
        Faker faker=new Faker();
        if (random.nextBoolean()){
            actions.click(autoEPage.genderMale)
                    .sendKeys(Keys.TAB)
                    .sendKeys(faker.name().name())
                    .sendKeys(Keys.TAB)
                    .sendKeys(faker.bothify("########"))
                    .sendKeys(Keys.TAB)
                    .sendKeys(random.nextInt(30)+"")
                    .sendKeys(Keys.TAB)
                    .sendKeys("May")
                    .sendKeys(Keys.TAB)
                    .sendKeys("2012")
                    .sendKeys(Keys.TAB)
                    .sendKeys(Keys.TAB)
                    .sendKeys(Keys.TAB)
                    .sendKeys(faker.name().firstName())
                    .sendKeys(Keys.TAB)
                    .sendKeys(faker.name().lastName())
                    .sendKeys(Keys.TAB)
                    .sendKeys(faker.company().name())
                    .sendKeys(Keys.TAB)
                    .sendKeys(faker.address().fullAddress())
                    .sendKeys(Keys.TAB)
                    .sendKeys(Keys.TAB)
                    .sendKeys(faker.address().country())
                    .sendKeys(Keys.TAB)
                    .sendKeys(faker.address().state())
                    .sendKeys(Keys.TAB)
                    .sendKeys(faker.address().city())
                    .sendKeys(Keys.TAB)
                    .sendKeys(faker.address().zipCode())
                    .sendKeys(Keys.TAB)
                    .sendKeys(faker.numerify("##########"))
                    .sendKeys(Keys.TAB)
                    .click().perform();

            autoEPage.buttonList.get(0).click();

            //BrowserTools.waitFor(5);
            autoEPage.continueButton.click();


        }
    }
    @Given("Verify  Logged in as username at top")
    public void verify_logged_in_as_username_at_top() {
        Assert.assertTrue(autoEPage.topUserName.isDisplayed());
    }
    @Given("Click Cart button")
    public void click_cart_button() {
        autoEPage.cartButton.click();

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
        autoEPage.downloadButton.get(0).click();
        String filePath="C:\\Users\\murat\\Downloads\\"+"invoice.txt";
        //System.out.println(filePath);
        //System.out.println("dosya vadmı"+BrowserTools.verifyFileDownloaded(filePath));
        BrowserTools.waitFor(2);
        Assert.assertTrue(BrowserTools.verifyFileDownloaded(filePath));


    }
    @Given("Click Continue button")
    public void click_continue_button() {
        autoEPage.downloadButton.get(1).click();
    }
    @Given("Click Delete Account button")
    public void click_delete_account_button() {
        autoEPage.deleteAccount.click();
    }
    @Given("Verify ACCOUNT DELETED! and click Continue button")
    public void verify_account_deleted_and_click_continue_button() {
        Assert.assertTrue(autoEPage.accountDeleted.isDisplayed());
        autoEPage.continueButtonAfterDeleted.click();
    }


}
