package avci.murat.step_definitions;

import avci.murat.pages.GooglePage;
import avci.murat.utilities.BrowserTools;
import avci.murat.utilities.ConfigurationReader;
import avci.murat.utilities.CustomTestListener;
import avci.murat.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Map;

@Listeners(CustomTestListener.class)//listener sınıfını bildiriyoruz
public class GoogleStepDef {

    GooglePage googlePage=new GooglePage();

    @Given("user open google page") @Test
    public void user_open_google_page() {
        Driver.getWebDriver().navigate().to("https://www.google.com");
    }
    @Given("user write to {string} in search box")
    public void user_write_to_in_search_box(String string) {
        googlePage.inbox.sendKeys(string);
    }
    @Given("user click to search button or enter key")
    public void user_click_to_search_button_or_enter_key() {
        googlePage.inbox.sendKeys(Keys.ENTER);
    }
    @Given("user read to result") @Test(invocationCount = 5)//burada bir işe yaramadı:)
    public void user_read_to_result() {


        System.out.println("googlePage.result.getText() = " + googlePage.result.getText());

    }

    @Given("I logged into suiteCRM")
    public void iLoggedIntoSuiteCRM() {
        System.out.println("selam");
    }


    @When("^I create a new contact:$")
    public void iCreateANewContact(Map<String,String> contact) {
        System.out.println(contact.get("first_name"));
        System.out.println(contact.get("last_name"));
        System.out.println(contact.get("cell_phone"));
    }

    @Then("I should see contact information for {string}") @Test(invocationCount = 5)
    public void iShouldSeeContactInformationFor(String arg0) {
        System.out.println(arg0);
    }
}
