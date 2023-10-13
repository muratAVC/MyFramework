package avci.murat.step_definitions;

import avci.murat.pages.YouTubeImgPage;
import avci.murat.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class YouTubeImg {
    YouTubeImgPage youTubeImgPage=new YouTubeImgPage();

    @Given("open browser and go to youtube channel")
    public void openBrowserAndGoToYoutubeChannel() {
        Driver.getWebDriver().navigate().to("https://www.youtube.com/@PythonSimplified");
    }
    @When("go to the videos tab")
    public void goToTheVideosTab() {
        youTubeImgPage.videos.click();
    }

    @And("find the latest video and get your picture")
    public void findTheLatestVideoAndGetYourPicture() throws IOException {
        //String imageURL=tpage.videoImages.get(0).getAttribute("src");
        WebElement element=youTubeImgPage.videoImages.get(0);
        String imageURL= element.getAttribute("src");
        System.out.println("selam"+imageURL);
        URL imgURL=new URL(imageURL);
        BufferedImage sevaImage= ImageIO.read(imgURL);
        ImageIO.write(sevaImage,"png",new File("\\resim.png"));
    }

}
