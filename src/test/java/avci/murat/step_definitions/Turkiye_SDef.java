package avci.murat.step_definitions;

import avci.murat.pages.TurkiyePage;
import avci.murat.utilities.BrowserTools;
import avci.murat.utilities.ConfigurationReader;
import avci.murat.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Turkiye_SDef {

    public TurkiyePage tpage=new TurkiyePage();

    @Given("Start the browser")
    public void start_the_browser() {
        Driver.getWebDriver();

    }
    @When("Go to the turkiye web page")
    public void go_to_the_turkiye_web_page() {
        Driver.getWebDriver().navigate().to("http://www.turkiye.gov.tr");
    }
    @When("Verify that the home page appears successfully")
    public void verify_that_the_home_page_appears_successfully() {
        Assert.assertTrue(tpage.girisButton.isDisplayed());
    }
    @And("Click the Register Sign In button")
    public void clickTheRegisterSignInButton() {
        tpage.girisButton.click();
    }
    @When("Verify that Sign in to your account appears")
    public void verify_that_sign_in_to_your_account_appears() {
        Assert.assertTrue(tpage.idNameField.isDisplayed());
    }
    @When("Enter the correct username and password")
    public void enter_the_correct_username_and_password() {
        tpage.idNameField.sendKeys(ConfigurationReader.getProperties("TurName"));
        tpage.passField.sendKeys(ConfigurationReader.getProperties("TurPass"));
    }
    @When("Click the Sign In button")
    public void click_the_sign_in_button() {
        tpage.submitButton.click();
    }

    @When("Verify that Logged in as username is visible1")
    public void verify_that_logged_in_as_username_is_visible1() {
        Assert.assertTrue(tpage.userMenu.isDisplayed());
    }

    @When("Click the Safe Exit button")
    public void click_the_safe_exit_button() {
        tpage.nameButton.click();
        tpage.safeExit.click();

    }
    @Then("Verify that the user is redirected to the login page")
    public void verify_that_the_user_is_redirected_to_the_login_page() {
     Assert.assertTrue(tpage.girisButton.isDisplayed());

    }


}
