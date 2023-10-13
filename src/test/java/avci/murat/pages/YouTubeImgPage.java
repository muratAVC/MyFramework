package avci.murat.pages;

import avci.murat.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class YouTubeImgPage {
    public YouTubeImgPage(){
        PageFactory.initElements(Driver.getWebDriver(),this);
    }



    @FindBy(xpath = "//img[contains(@class,'yt-core-image')]")
    public List<WebElement> videoImages;

    @FindBy(id="search")
    public WebElement searchArea;

    @FindBy(id = "search-icon-legacy")
    public WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"tabsContent\"]/tp-yt-paper-tab[2]/div")
    public WebElement videos;
}
