package avci.murat.pages;

import avci.murat.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage {

    public GooglePage(){
        PageFactory.initElements(Driver.getWebDriver(),this);
    }

    @FindBy(id = "APjFqb")
    public  WebElement inbox;

    @FindBy(xpath = "//div[@id='slim_appbar']//div//div")
    public WebElement result;


    @FindBy(id = "identifierId")
    public WebElement inputNameBox;

    @FindBy (id = "identifierNext")
    public WebElement nextButtonN;

    @FindBy (xpath = "//*[@name='Passwd']")
    public WebElement passBox;

    @FindBy(xpath = "//*[@id=\"passwordNext\"]/div/button/span")
    public WebElement nextButtonP;





}
