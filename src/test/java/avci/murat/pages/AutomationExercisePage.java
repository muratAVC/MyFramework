package avci.murat.pages;

import avci.murat.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AutomationExercisePage {

    public AutomationExercisePage(){
        PageFactory.initElements(Driver.getWebDriver(),this);
    }

    @FindBy(xpath = "//div[contains(@class,\"logo\")]")
    public WebElement mainPageFoto;

    @FindBy(xpath = "//form[@class=\"searchform\"]")
    public WebElement subcription;

    @FindBy(xpath = "//div[@class=\"single-widget\"]//h2")
    public WebElement getSubcription;

    @FindBy(xpath = "//div[@class=\"col-sm-6\"]//h2")
    public List<WebElement> text;

    @FindBy(xpath = "//i[@class=\"fa fa-angle-up\"]")
    public WebElement upButton;

    @FindBy(xpath = "//div[contains(@class,\"productinfo\")]//a")
    public List<WebElement> productList;

    @FindBy(xpath = "//button[contains(@class,\"btn-block\")]")
    public WebElement continueShoppingButton;

    @FindBy(xpath = "//ul[contains(@class,\"nav navbar-nav\")]//li[3]")
    public WebElement cartButton;

    @FindBy(xpath = "//li[@class='active']")
    public WebElement cartPage;

    @FindBy(xpath = "//a[@class='btn btn-default check_out']")
    public WebElement checkoutButton;

    @FindBy(xpath = "//div[@class='modal-body']//p[2]")
    public WebElement regLogButton;

    @FindBy(name = "name")
    public WebElement nameInput;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    public WebElement emailInput;

    @FindBy(xpath = "//button[contains(@data-qa,'signup-button')]")
    public WebElement signupButton;

    @FindBy(id = "id_gender1")
    public WebElement genderMale;

    @FindBy(id = "id_gender2")
    public WebElement genderFemale;

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    public WebElement continueButton;

    @FindBy(xpath = "//ul[@class='nav navbar-nav']//li[10]//a//b")
    public WebElement topUserName;

    @FindBy(xpath = "//button[contains(@class,'btn-default')]")
    public List<WebElement> buttonList;

    @FindBy(id = "address_delivery")
    public WebElement addressDelivery;

    @FindBy(id = "address_invoice")
    public WebElement addressBilling;

    @FindBy(id = "cart_info")
    public WebElement cartInfo;

    @FindBy(xpath = "//div[@id='ordermsg']//textarea")
    public WebElement commentArea;

    @FindBy(xpath = "//section[@id='cart_items']//div//div[7]//a")
    public WebElement placeOrder;

    @FindBy(name = "name_on_card")
    public WebElement nameOnCard;

    @FindBy(id = "submit")
    public WebElement submitButton;

    @FindBy(xpath = "//div[contains(@class,'col-sm-9')]//p")
    public WebElement succesMessage;

    @FindBy(xpath = "//div[contains(@class,'col-sm-9')]//a")
    public List<WebElement> downloadButton;

    @FindBy(xpath = "//ul[@class='nav navbar-nav']//li[5]")
    public WebElement deleteAccount;

    @FindBy(xpath = "//div[contains(@class,'col-sm-9')]//h2//b")
    public WebElement accountDeleted;

    @FindBy(xpath = "//div[contains(@class,'col-sm-9')]//div")
    public WebElement continueButtonAfterDeleted;





















}
