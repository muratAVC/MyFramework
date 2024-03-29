package avci.murat.pages;

import avci.murat.utilities.Driver;
import io.cucumber.java.zh_cn.假如;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AutomationExercisePage {

    public AutomationExercisePage(){
        PageFactory.initElements(Driver.getWebDriver(),this);
    }

    ///////////main Page Elements
    @FindBy(xpath = "//*[contains(@class,'nav navbar-nav')]//li[2]//a")
    public WebElement productsButton;

    @FindBy(xpath = "//*[@class=\"fa fa-lock\"]")
    public WebElement singupLoinButton;

    @FindBy(xpath = "//div[contains(@class,\"logo\")]")
    public WebElement mainPageFoto;

    @FindBy(xpath = "//*[@class='nav navbar-nav']//b")
    public WebElement userName;

    @FindBy(id = "susbscribe_email")
    public WebElement subscribeEmail;

    @FindBy(id = "subscribe")
    public WebElement subscribeButton;

    @FindBy(xpath = "//div[@class='alert-success alert']")
    public WebElement hiddenSubscribeMessage;

    //////////// All products Page
    @FindBy(xpath = "//*[contains(@class,'title text-center')]")
    public WebElement allProductsHeadText;

    @FindBy(xpath = "//*[contains(@class,'choose')]")
    public List<WebElement> allProductList;

    @FindBy(xpath = "//*[@class='productinfo text-center']//a")
    public List<WebElement> allProductAddtoCartButtonList;

    @FindBy(xpath = "//*[@class='overlay-content']//h2")
    public List<WebElement> allProductTitleList;


    @FindBy(xpath = "//*[contains(@href,'brand_products')]//span")
    public List<WebElement> differentProductCount;

    @FindBy(xpath ="//*[@class='choose']//ul//li//a")
    public List<WebElement> allPoductViewList;

    @FindBy(id = "search_product")
    public WebElement searchInput;

    @FindBy(id = "submit_search")
    public WebElement submitSearch;

    @FindBy(xpath = "//*[@class='productinfo text-center']//p")
    public List<WebElement> searchedProductList;

    @FindBy(xpath = "//*[@class='productinfo text-center']//a")
    public List<WebElement> SPLAddButton;


    ////////////product review page
    @FindBy(xpath = "//*[contains(@class,'active')]//a")
    public WebElement reviewMessage;

    @FindBy(id = "name")
    public WebElement nameArea;

    @FindBy(id="email")
    public WebElement emailArea;

    @FindBy(id = "review")
    public WebElement reviewArea;

    @FindBy(id = "button-review")
    public WebElement reviewSubmitButton;

    @FindBy(xpath = "//*[@class='alert-success alert']//span")
    public WebElement successAlert;
    /////////////////
    ////////Cart Page
    @FindBy(xpath = "//td[@class='cart_description']//a")
    public List<WebElement> productInCartTitle;

    @FindBy(xpath = "//td[@class='cart_price']//p")
    public List<WebElement> productInCartPrice;

    @FindBy(xpath = "//td[@class='cart_quantity']//button")
    public List<WebElement> productInCartQuantity;

    @FindBy(xpath = "//td[@class='cart_total']//p")
    public List<WebElement> productInCartTotalPrice;


    ///Product Details page

    @FindBy(xpath = "//*[@class='product-information']")
    public WebElement productDetailsPicture;

    @FindBy(xpath = "//div[@class='product-information']//h2")
    public WebElement productInfoDetailsTitle;

    @FindBy(id = "quantity")
    public WebElement productDetailsQuantity;

    @FindBy(xpath = "//*[@class='btn btn-default cart']")
    public WebElement addToCartButtonInProductDetailsPage;



    ////
    //log In- Sign Up Page
    @FindBy(xpath = "//*[@class='login-form']//p")
    public WebElement incorrectInfoMessage;

    @FindBy(xpath = "//*[@data-qa='login-email']")
    public WebElement loginEMailBox;

    @FindBy(name = "password")
    public WebElement loginPasswordBox;

    @FindBy(xpath = "//*[@data-qa='login-button']")
    public WebElement loginButton;


    @FindBy(xpath = "//*[@class='login-form']//h2")
    public WebElement loginYourAccountMessage;

    @FindBy(xpath = "//*[@class='signup-form']//h2")
    public WebElement newUserSignupMessage;

    @FindBy(name = "name")
    public WebElement nameInput;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    public WebElement emailInput;

    @FindBy(xpath = "//*[@class='signup-form']//p")
    public WebElement emailAlreadyExistMessage;

    @FindBy(xpath = "//button[contains(@data-qa,'signup-button')]")
    public WebElement signupButton;

    @FindBy(xpath = "//div[contains(@class,'login-form')]//b")
    public List<WebElement> infoPersonTitle;

    @FindBy(id = "newsletter")
    public WebElement newsletterCheckBox;

    @FindBy(id = "optin")
    public WebElement optinCheckBox;




//////////////


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

        @FindBy(xpath = "//div[@class='modal-body']//p[2]")
    public WebElement viewCartButton;

    @FindBy(xpath = "//ul[contains(@class,\"nav navbar-nav\")]//li[3]")
    public WebElement cartButton;

    @FindBy(xpath = "//ul[contains(@class,\"nav navbar-nav\")]//li[8]")
    public WebElement contactUsButton;

    @FindBy(xpath = "//div[@class='product-information']")
    public WebElement productDetailPage;

    @FindBy(xpath = "//div[@class='product-information']//h2")
    public WebElement productDetailName;

    @FindBy(xpath = "//div[@class='product-information']//span//span")
    public WebElement productDetailPrice;

    @FindBy(xpath = "//div[@class='product-information']//p[1]")
    public WebElement productDetailCategory;

    @FindBy(xpath = "//div[@class='product-information']//p//b")
    public List<WebElement> productNCB;

    @FindBy(xpath = "//*[contains(@class,\"choose\")]//a")
    public List<WebElement> getAllProductListWiewButton;

    @FindBy(xpath = "//div[contains(@class,\"contact-form\")]//h2")
    public WebElement getInTouchMessage;

    @FindBy(name = "name")
    public WebElement nameBoxWithContactUs;

    @FindBy(name = "email")
    public WebElement emailBoxWithContactUs;

    @FindBy(name = "subject")
    public WebElement subjectBoxWithContactUs;

    @FindBy(id = "message")
    public WebElement messageBoxWithContactUs;

    @FindBy(name = "upload_file")
    public WebElement uploadFileButton;


    @FindBy(xpath = "//tr[@class='cart_menu']")
    public WebElement cartPage;

    @FindBy(xpath = "//*[@id=\"address_delivery\"]/li[4]")
    public WebElement deliveryAddress;

    @FindBy(xpath = "//*[@id=\"address_invoice\"]/li[4]")
    public WebElement billingAddress;

    @FindBy(xpath = "//div[@class='recommended_items']")
    public WebElement recommendedItems;

    @FindBy(xpath = "//*[@id='recommended-item-carousel']//a")
    public List<WebElement> recomProList;

    @FindBy(xpath = "//*[@id='recommended-item-carousel']//p")
    public List<WebElement> getRecomProListTitle;

    @FindBy(xpath = "//a[@class='btn btn-default check_out']")
    public WebElement checkoutButton;

    @FindBy(xpath = "//div[@class='modal-body']//p[2]")
    public WebElement regLogButton;




    @FindBy(id = "id_gender1")
    public WebElement genderMale;

    @FindBy(id = "id_gender2")
    public WebElement genderFemale;

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    public WebElement continueButton;

    @FindBy(xpath = "//ul[@class='nav navbar-nav']//li[10]//a//b")
    public WebElement topUserName;

    @FindBy(xpath = "//form[contains(@action,'signup')]//button")
    public WebElement createAccountButton;

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

    @FindBy(name = "submit")
    public WebElement submitButtonWithContactUs;

    @FindBy(xpath = "//div[contains(@class,\"contact-form\")]//div[2]")
    public WebElement successMessage;

    @FindBy(xpath = "//div[contains(@class,\"contact-form\")]//span")
    public WebElement homeButton;

    @FindBy(xpath = "//div[contains(@class,'col-sm-9')]//p")
    public WebElement succesMessage;

    @FindBy(xpath = "//div[contains(@class,'col-sm-9')]//a")
    public WebElement downloadButton;

    @FindBy(xpath = "//ul[@class='nav navbar-nav']//li[5]")
    public WebElement deleteAccount;

    @FindBy(xpath = "//div[contains(@class,'col-sm-9')]//h2//b")
    public WebElement accountDeleted;

    @FindBy(xpath = "//div[contains(@class,'col-sm-9')]//div")
    public WebElement continueButtonAfterDeleted;

    @FindBy(xpath = "//ul[contains(@class,\"nav navbar-nav\")]//li[4]")
    public WebElement logoutButton;

    @FindBy(xpath = "//section[@id='form']//h2")
    public List<WebElement> loginPageMessages;

    @FindBy(xpath = "//*[@class='form-control']")
    public WebElement nameOnCreditCart;

    @FindBy(id = "submit")
    public WebElement payAndComfirmOrder;




    @FindBy(xpath = "//div[@id=\"dismiss-button\"]//div//span")
    public WebElement addOn1;




}
