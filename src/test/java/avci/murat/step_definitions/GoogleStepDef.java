package avci.murat.step_definitions;

import avci.murat.pages.GooglePage;
import avci.murat.utilities.BrowserTools;
import avci.murat.utilities.ConfigurationReader;
import avci.murat.utilities.Driver;
import io.cucumber.java.en.Given;
import org.openqa.selenium.Keys;

public class GoogleStepDef {

    GooglePage googlePage=new GooglePage();

    @Given("user open google page")
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
    @Given("user read to result")
    public void user_read_to_result() {


        System.out.println("googlePage.result.getText() = " + googlePage.result.getText());

    }
}
