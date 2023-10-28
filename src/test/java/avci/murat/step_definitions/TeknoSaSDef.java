package avci.murat.step_definitions;

import avci.murat.utilities.BrowserTools;
import avci.murat.utilities.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.security.Key;

public class TeknoSaSDef {

    @Test
    public void teknoSa_Shadoww(){
        Driver.getWebDriver().navigate().to("https://www.teknosa.com");
        SearchContext src=Driver.getWebDriver().findElement(By.xpath("//efilli-layout-dynamic")).getShadowRoot();
        WebElement elem=src.findElement(By.cssSelector("div[data-name='Accept Button']"));//xpath çalışmadı

        elem.click();
        Driver.getWebDriver().findElement(By.id("ins-editable-button-1580496494")).click();
        //Driver.getWebDriver().switchTo().alert().dismiss();
    }

    @AfterMethod
    public void closeBrowser(){
        BrowserTools.waitFor(5);
        //Driver.closeDriver();
    }
    @Test
    public void registerUserToTeknoSa(){
//        Given Navigate to url 'http://www.teknosa.com'
        Driver.getWebDriver().navigate().to("http://www.teknosa.com");
//        And Verify that home page is visible successfully
        SearchContext src=Driver.getWebDriver().findElement(By.xpath("//efilli-layout-dynamic")).getShadowRoot();
        WebElement elem=src.findElement(By.cssSelector("div[data-name='Accept Button']"));//xpath çalışmadı
        elem.click();
        Driver.getWebDriver().findElement(By.id("ins-editable-button-1580496494")).click();
        Assert.assertTrue(Driver.getWebDriver().findElement(By.id("site-header")).isDisplayed());

//        4. Click on 'Signup / Login' button
        Driver.getWebDriver().findElement(By.xpath("//*[@id=\"site-header\"]/div/div[3]/div[3]/a[2]")).click();
        Driver.getWebDriver().findElement(By.xpath("//*[@id=\"user-menu\"]//div//div[1]//a[2]")).click();
        //Assert.assertTrue(Driver.getWebDriver().findElement(By.xpath("//*[@id=\"site-main\"]/div/div[1]/div[1]")).isDisplayed());//üye ol ekranının görüntülendiğini sorgular

//        6. Enter name and email address
        Driver.getWebDriver().findElement(By.xpath("//*[@id=\"site-main\"]//div//div[1]//div[3]//div//div//div//div[1]//div//a[2]")).click();
        Actions action=new Actions(Driver.getWebDriver());
        action.sendKeys(Driver.getWebDriver().findElement(By.id("register.firstName")),"Mergen")
                .sendKeys(Keys.TAB)
                .sendKeys("caza")
                .sendKeys(Keys.TAB)
                .sendKeys("cazador123@yopmail.com")
                .sendKeys(Keys.TAB)//telefon kısmı çalışmadığı için ayrı bir web element şeklinde yaptım
                .sendKeys(Keys.TAB)
                .sendKeys("9637650584MHT_thy").perform();
        Driver.getWebDriver().findElement(By.id("phone")).sendKeys("(541)9681150");

//        7. Click 'Signup' button
        Driver.getWebDriver().findElement(By.id("customerRegisterButton")).click();
//        8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
//        9. Fill details: Title, Name, Email, Password, Date of birth
//        10. Select checkbox 'Sign up for our newsletter!'
//        11. Select checkbox 'Receive special offers from our partners!'
//        12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
//        13. Click 'Create Account button'
//        14. Verify that 'ACCOUNT CREATED!' is visible
//        15. Click 'Continue' button
//        16. Verify that 'Logged in as username' is visible
//        17. Click 'Delete Account' button
//        18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
    }

    @Test
    public void loginAccountToTeknoSa(){
//        2. Navigate to url 'http://www.teknosa.com'
        Driver.getWebDriver().navigate().to("https://www.teknosa.com");
//        3. Verify that home page is visible successfully
        SearchContext src=Driver.getWebDriver().findElement(By.xpath("//efilli-layout-dynamic")).getShadowRoot();
        WebElement elem=src.findElement(By.cssSelector("div[data-name='Accept Button']"));//xpath çalışmadı
        elem.click();
        try {
            Driver.getWebDriver().findElement(By.id("ins-editable-button-1580496494")).click();
        }catch (Exception e){
            e.printStackTrace();
        }
        Assert.assertTrue(Driver.getWebDriver().findElement(By.id("site-header")).isDisplayed());

//        4. Click on 'Signup / Login' button
        Driver.getWebDriver().findElement(By.cssSelector(".btn-user")).click();
        Driver.getWebDriver().findElement(By.cssSelector(".secondCallLogin")).click();

//        5. Verify 'Login to your account' is visible
//        6. Enter correct email address and password
//        7. Click 'login' button
//        8. Verify that 'Logged in as username' is visible
//        9. Click 'Delete Account' button
//        10. Verify that 'ACCOUNT DELETED!' is visible
    }

    @Test
    public void testSearchProduct(){
//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
        Driver.getWebDriver().navigate().to("https://www.teknosa.com");
        SearchContext src=Driver.getWebDriver().findElement(By.xpath("//efilli-layout-dynamic")).getShadowRoot();
        WebElement elem=src.findElement(By.cssSelector("div[data-name='Accept Button']"));//xpath çalışmadı
        elem.click();
        try {
            Driver.getWebDriver().findElement(By.id("ins-editable-button-1580496494")).click();
        }catch (Exception e){
            e.printStackTrace();
        }
        Assert.assertTrue(Driver.getWebDriver().findElement(By.id("site-header")).isDisplayed());

        //Driver.getWebDriver().switchTo().alert().dismiss();
//        3. Click on 'Products' button
        Driver.getWebDriver().findElement(By.cssSelector(".search-button")).click();
        Driver.getWebDriver().findElement(By.id("search-input")).sendKeys("Elektrik Destekli Bisiklet");
        Driver.getWebDriver().findElement(By.cssSelector(".sbx-search")).click();

//        4. Verify user is navigated to ALL PRODUCTS page successfully
//        5. Enter product name in search input and click search button
//        6. Verify 'SEARCHED PRODUCTS' is visible
//        7. Verify all the products related to search are visible
//        8. Add those products to cart
//        9. Click 'Cart' button and verify that products are visible in cart
//        10. Click 'Signup / Login' button and submit login details
//        11. Again, go to Cart page
//        12. Verify that those products are visible in cart after login as well
    }
}
