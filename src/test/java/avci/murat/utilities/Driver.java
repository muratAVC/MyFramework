package avci.murat.utilities;

import io.github.bonigarcia.wdm.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver(){}//singelton asarım modeli gereği public değil private olacak
    private static WebDriver webDriver;//singelton asarım modeli gereği public değil private olacak
 //   private static final InheritableThreadLocal<WebDriver> driverPool =new InheritableThreadLocal<>();

    public static WebDriver getWebDriver(){
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--lang=en");

        if (webDriver==null){
            String browserName=ConfigurationReader.getProperties("browser");
            switch (browserName){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    webDriver=new ChromeDriver(options);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    webDriver=new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    webDriver=new EdgeDriver();
                    break;
            }

        }
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        return webDriver;
    }


/*
    public static WebDriver getDriver(){
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--lang=en");

        if (driverPool.get()==null){
            String browserName=ConfigurationReader.getProperties("browser");
            switch (browserName){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    WebDriver driver=new ChromeDriver(options);
                    driverPool.set(driver);
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "remote-chrome":
                    String gridAdress = "54.89.242.106"; // put your own Linux grid IP here
                    try {
                        URL url = new URL("http://"+gridAdress+":4444/wd/hub");
                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                        desiredCapabilities.setBrowserName("chrome");
                        driverPool.set(new RemoteWebDriver(url,desiredCapabilities));
                        driverPool.get().manage().window().maximize();
                        driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "saucelab-chrome":
                    try{
                        URL url = new URL("https://oauth-sdetoscar-844c8:66e7117f-390e-4556-8105-07af96a01f7a@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                        desiredCapabilities.setBrowserName("chrome");
                        driverPool.set(new RemoteWebDriver(url,desiredCapabilities));
                        driverPool.get().manage().window().maximize();
                        driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    }catch (MalformedURLException e){
                        e.printStackTrace();
                    }
                    break;
                case "saucelab-edge":
                    EdgeOptions browserOptions = new EdgeOptions();
                    browserOptions.setCapability("platformName", "Windows 11");
                    browserOptions.setCapability("browserVersion", "latest");
                    Map<String, Object> sauceOptions = new HashMap<>();
                    sauceOptions.put("build", "<your build id>");
                    sauceOptions.put("name", "<your test name>");
                    browserOptions.setCapability("sauce:options", sauceOptions);
                    URL url = null;
                    try {
                        url = new URL("https://oauth-sdetoscar-844c8:66e7117f-390e-4556-8105-07af96a01f7a@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
                        driverPool.set(new RemoteWebDriver(url,browserOptions));
                        driverPool.get().manage().window().maximize();
                        driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
        webDriver=driverPool.get();
        return webDriver;
    }*/
    public static void closeDriver(){
        if (webDriver != null){
            webDriver.quit(); // this line will terminate the existing session. value will not even be null
            webDriver = null;
        }
    }

}
