package avci.murat.step_definitions;

import avci.murat.utilities.BrowserTools;
import avci.murat.utilities.Driver;
import io.cucumber.java.*;


public class Hooks {

    @Before
    public void beforeTest(){ Driver.getWebDriver(); }

    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()){
            BrowserTools.screenShoot(scenario);
        }
        //Driver.closeDriver();
    }

    @AfterStep
    public void vaitAfterSteps(){
        //BrowserTools.waitFor(2);
        //System.out.println("2 saniye Bekledim");
    }
}
