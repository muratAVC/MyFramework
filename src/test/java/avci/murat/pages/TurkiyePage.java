package avci.murat.pages;

import avci.murat.utilities.Driver;
import com.google.j2objc.annotations.Weak;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.sql.DriverManager;
import java.util.List;

public class TurkiyePage {

    public TurkiyePage(){
        PageFactory.initElements(Driver.getWebDriver(),this);
    }

    @FindBy(xpath = "//*[@id='mainActionsBlock']/ul/li[5]")
    public WebElement girisButton;

    @FindBy(id = "tridField")
    public WebElement idNameField;

    @FindBy(id = "egpField")
    public WebElement passField;

    @FindBy(name = "submitButton")
    public WebElement submitButton;

    @FindBy(id = "userMenu")
    public WebElement userMenu;

    @FindBy(xpath = "//li[@id='userMenu']/a")
    public WebElement nameButton;

    @FindBy(xpath = "//a[@class='logout']")
    public WebElement safeExit;


}
