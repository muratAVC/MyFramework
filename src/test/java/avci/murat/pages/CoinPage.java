package avci.murat.pages;

import avci.murat.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoinPage {
    public CoinPage(){
        PageFactory.initElements(Driver.getWebDriver(),this);
    }

    @FindBy(xpath = "//div[@class='sc-a1afcbd4-0 dOfKAB'][4]")
    public WebElement element;

    @FindBy(xpath = "//div[contains(@class,'gPOCZd')]//ul//li[2]")
    public WebElement element1;



}
