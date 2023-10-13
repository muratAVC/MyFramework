package avci.murat.pages;

import avci.murat.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Queue;

public class CoinPage {
    public CoinPage(){
        PageFactory.initElements(Driver.getWebDriver(),this);
    }

    @FindBy(xpath = "//div[@class='sc-a1afcbd4-0 dOfKAB'][4]")
    public WebElement element;

    @FindBy(xpath = "//div[contains(@class,'gPOCZd')]//ul//li[2]")
    public WebElement element1;

    @FindBy(linkText = "Community")
    public  WebElement CommunityButton;

    @FindBy(xpath = "//div[contains(@role,'textbox')]")
    public WebElement messageBox;

    @FindBy(xpath = "//button[@data-btnname='Post']")
    public WebElement pastButton;

    @FindBy(xpath = "//button[@data-btnname='Log In']")
    public WebElement loginButton;

    @FindBy(css = "div >div > div > div:nth-child(2) > div:nth-child(1) > input")
    public WebElement logInputName;

    @FindBy(css = "div >div > div > div:nth-child(2) > div:nth-child(2) > input")
    public WebElement logPassIn;

    @FindBy(css = "div >div > div > div:nth-child(2) > div:nth-child(3) > button:nth-child(1)")
    public WebElement logButton;

    @FindBy(css = "div[class*='table-control-area']>div>div")
    public WebElement rowFilter;

    //table[contains(@class,'table')]//tbody//tr

    @FindBy(css = "div[class*='cciXVV'] button:nth-child(1)")
    public WebElement getRowFilterChose1;

    @FindBy(xpath = "//div[contains(@class,'dropdown-container')]//button")
    public List<WebElement> rowFilterChoiser;

    @FindBy(css = "div[class*='cciXVV'] button:nth-child(2)")
    public WebElement getRowFilterChose2;

    @FindBy(css = "div[class*='cciXVV'] button:nth-child(3)")
    public WebElement getRowFilterChose3;


    @FindBy(css = "div[class*='hide_on_mobile_wrapper'] button:nth-child(1)")
    public WebElement filterButton;

    @FindBy(xpath = "//tbody//td[2]")
    public List<WebElement> rowCount;

    @FindBy(css = "ul[class*='fsDYiB'] li:nth-child(5)> button")
    public WebElement filterButtonBig;

    @FindBy(css = "div[class*='iLGPnv'] div:nth-child(3)>button")
    public WebElement priceFilterButton;

    @FindBy(css = "div[class*='iqqamJ']>div input:nth-child(1)")
    public WebElement priceMinInput;

    @FindBy(css = "input[placeholder*='99']")
    public WebElement priceMaxInput;

    @FindBy(css = "div[class*='MwqwH'] button:nth-child(1)")
    public WebElement applyButton;

    @FindBy(css = "div[class*='clgqXO'] a span")
    public List<WebElement> priceList;

    @FindBy(css = "div[class*='hfka'] button:nth-child(1)")
    public WebElement showResultButton;

    @FindBy(xpath = "//span[contains(@class,'bKdJUK')]//button[2]")
    public WebElement customizeButton;

    @FindBy(xpath = "//div[contains(@class,'jINBuN')]/div")
    public WebElement chooseUPButton;

    @FindBy(xpath = "//div[contains(@class,'jINBuN')]/div/div[2]/div/div")
    public List<WebElement> chooseUPList;

    @FindBy(xpath = "//div[contains(@class,\"hVLGgx\")]")
    public WebElement bottomIcon;

    @FindBy(xpath = "//a[contains(@class,\"hwoLoF\")]//img")
    public WebElement navBar;

    @FindBy(xpath = "//div[contains(@class,\"fWcxPm\")]")
    public WebElement searchBox1;






}
