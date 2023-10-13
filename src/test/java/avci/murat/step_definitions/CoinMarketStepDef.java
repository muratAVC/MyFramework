package avci.murat.step_definitions;

import avci.murat.pages.CoinPage;
import avci.murat.utilities.BrowserTools;
import avci.murat.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;


import java.util.List;

public class CoinMarketStepDef {
    CoinPage coinPage=new CoinPage();

    @Given("open coin market")
    public void open_coin_market() {
        Driver.getWebDriver().navigate().to("https://coinmarketcap.com/");
    }
    @Given("guest enter")
    public void guest_enter() {

    }
    @Given("The user should be able to click the community module")
    public void the_user_should_be_able_to_click_the_community_module() {
        coinPage.CommunityButton.click();
    }

    @Given("The user should be able to see three options {string}")
    public void the_user_should_be_able_to_see_three_options(String string) {
        //Driver.getWebDriver().findElement(By.id("onetrust-accept-btn-handler")).click();
        BrowserTools.scrollToElement(coinPage.filterButton);
        coinPage.rowFilter.click();
        if (string.equals("100")){
            BrowserTools.waitFor(2);
            coinPage.rowFilterChoiser.get(0).click();
            //coinPage.getRowFilterChose1.click();
        } else if (string.equals("50")){
            BrowserTools.waitFor(2);
            coinPage.rowFilterChoiser.get(1).click();
            //coinPage.getRowFilterChose2.click();
        } else {
            BrowserTools.waitFor(2);
            coinPage.rowFilterChoiser.get(2).click();
            //coinPage.getRowFilterChose3.click();
        }

        //BrowserTools.waitFor(10);


    }

    @Given("The user should be able to click Filters")
    public void the_user_should_be_able_to_click_filters() {
        coinPage.filterButton.click();
        BrowserTools.waitFor(2);
        coinPage.filterButtonBig.click();
        BrowserTools.waitFor(2);
        coinPage.priceFilterButton.click();
        BrowserTools.waitFor(2);
        coinPage.priceMinInput.sendKeys("10");
        BrowserTools.waitFor(2);
        coinPage.priceMaxInput.sendKeys("20");
        BrowserTools.waitFor(2);
        coinPage.applyButton.click();
        coinPage.showResultButton.click();
        BrowserTools.waitFor(5);

    }


    @And("write and post {string}")
    public void writeAndPost(String message) {
        if (message.length()>99){
            System.out.println("cok uzun");
        }else {
            coinPage.messageBox.sendKeys(message + Keys.ENTER);
        }
    }

    @And("verify row count {string}")
    public void verifyRowCount(String row) {
        BrowserTools.waitFor(2);
        Assert.assertEquals(row,coinPage.rowFilter.getText());
        BrowserTools.waitFor(2);
        Assert.assertEquals(Integer.parseInt(row),Driver.getWebDriver().findElements(By.xpath("//div[contains(@class,'drKFAV')]//a")).size());
        System.out.println(row+ "is selected");
    }

    @And("verify all price")
    public void verifyAllPrice() {
        boolean verify=false;
        List<WebElement> pricelist=coinPage.priceList;
        //pricelist=pricelist.stream().sorted().collect(Collectors.toList());
        for (WebElement elm: pricelist) {
            double min=10, max=20;
            //System.out.println("elm.getText().substring(1) = " + elm.getText());
            double price=Double.parseDouble(elm.getText().substring(1));
            if (min>price) verify=true;
            if (max<price) verify=true;
        }
        if (verify) Assert.assertTrue(verify);
        else Assert.assertFalse(verify);
    }

    @Given("Open {string} page")
    public void openPage(String arg0) {
        Driver.getWebDriver().navigate().to(arg0);
        Assert.assertTrue(coinPage.navBar.isDisplayed());
    }

    @And("Scroll to page to element")
    public void scrollToPageToElement() {
        JavascriptExecutor jse=(JavascriptExecutor) Driver.getWebDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);",coinPage.bottomIcon);
    }

    @And("other steps")
    public void otherSteps() {
        WebElement element=Driver.getWebDriver().findElement(By.xpath("//div[contains(@class,\"fWcxPm\")]"));
        BrowserTools.scrollToElement(element);
        element.click();
        WebElement element1=Driver.getWebDriver().findElement(By.xpath("//input[contains(@class,\"desktop-input\")]"));
        element1.sendKeys("dfg");
        //List<WebElement> element2=Driver.getWebDriver().findElements(By.xpath("//*[@id=\"tippy-2\"]//div//div//div//div//div[2]//div//div[2]//a"));

        WebElement element4=Driver.getWebDriver().findElement(By.xpath("//div[contains(@class,'YlTVf')]"));
        List<WebElement> element3=Driver.getWebDriver().findElements(By.xpath("//div[contains(@class,'drKFAV')]//a"));
        element4.click();
        ////div[contains(@class,'YlTVf')]
        ////div[contains(@class,'drKFAV')]//a

        System.out.println("result="+element3.size());
    }
}
