package avci.murat.utilities;

import io.cucumber.java.Scenario;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.time.Duration;
import java.util.*;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BrowserTools {

    public static void switchToWindow(String switchWindow){
        String current=Driver.getWebDriver().getWindowHandle();
        for(String str:Driver.getWebDriver().getWindowHandles()){
            Driver.getWebDriver().switchTo().window(str);
            if (Driver.getWebDriver().getTitle().equals(switchWindow)){
                return;
            }
        }//geçerli sekmeyi değiştirir / replaces the current tab
        Driver.getWebDriver().switchTo().window(current);
    }

    public static void moveToMouse(WebElement webElement){//imleci istenilen web elementin üzerine getirir
        Actions actions=new Actions(Driver.getWebDriver());
        actions.moveToElement(webElement).perform();
    }

    public static List<String> getElementsText(List<WebElement> elements){//verilen element listesinin text değerlerini yine liste olarak döndürür
        List<String> result = new ArrayList<>();
        for (WebElement element:elements){
            result.add(element.getText());
        }
        return result;
    }

    public static List<String> getElementsText(By locator){//verilen yer bulucuyu kullanarak web element listesinin text sedeğlerini döndürür
        List<WebElement> element=Driver.getWebDriver().findElements(locator);
        List<String> result=new ArrayList<>();
        for (WebElement webElement:element){
            result.add(webElement.getText());
        }
        return result;
    }

    public static void waitFor(int second){
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static WebElement waitForVisibility(WebElement element,int second){//verilen web elementin ekranda görünmesi için verilen süre kadar bekler
        WebDriverWait wait=new WebDriverWait(Driver.getWebDriver(),Duration.ofSeconds(second));
        WebElement webElement=wait.until(ExpectedConditions.visibilityOf(element));
        return webElement;
    }

    public static WebElement waitForVisibility(By locator,int second){//verilen yer bulucuya göre elementin ekranda görününceye kadar verilen süre kadar bekler
        WebElement result;
        WebDriverWait wait=new WebDriverWait(Driver.getWebDriver(),Duration.ofSeconds(second));
        result=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return result;
    }

    public static WebElement waitForClickability(WebElement element,int second){
        WebElement result;
        WebDriverWait wait=new WebDriverWait(Driver.getWebDriver(),Duration.ofSeconds(second));
        result=wait.until(ExpectedConditions.elementToBeClickable(element));
        return result;
    }

    public static WebElement waitForClickability(By locator,int second){
        WebDriverWait wait=new WebDriverWait(Driver.getWebDriver(),Duration.ofSeconds(second));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitForPageLoad(long second){
        ExpectedCondition<Boolean> expectedConditions=new ExpectedCondition<Boolean>(){
            public Boolean apply(WebDriver driver){
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            WebDriverWait wait=new WebDriverWait(Driver.getWebDriver(),Duration.ofSeconds(second));
            wait.until(expectedConditions);
        }catch (Throwable throwable){
            throwable.printStackTrace();
        }

    }

    public static void verifyElementIsDisplayed(By locator){
        try{
            WebElement element=Driver.getWebDriver().findElement(locator);
            Assert.assertTrue(element.isDisplayed());
        } catch (NoSuchElementException e){
            Assert.fail("Element is not found");
        }
    }

    public static void verifyElementIsNotDisplayed(By locator){
       try {
           WebElement element=Driver.getWebDriver().findElement(locator);
           Assert.assertFalse("Element not visible",element.isDisplayed());
       }catch (NoSuchElementException e){
           e.printStackTrace();
       }
    }

    public static boolean waitElementIsDisplayed(WebElement element){
        try {
            return element.isDisplayed();
        }catch (NoSuchElementException e){
            return  false;
        }
    }


    public static void verifyElementIsDisplayed(WebElement element){
        try{
            Assert.assertTrue(element.isDisplayed());

        } catch (NoSuchElementException e){
            Assert.fail("Element is not found");
        }
    }
    public static void verifyElementIsNotDisplayed(WebElement element){
        try {
            Assert.assertFalse("Element not visible",element.isDisplayed());
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
    }

    public static void waitForStaleElement(WebElement element) {
        int y = 0;
        while (y <= 15) {
            if (y == 1)
                try {
                    element.isDisplayed();
                    break;
                } catch (StaleElementReferenceException st) {
                    y++;
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } catch (WebDriverException we) {
                    y++;
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        }
    }

    public static void clickWithJavaScript(WebElement element){
        JavascriptExecutor jse=(JavascriptExecutor)Driver.getWebDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);",element);
        jse.executeScript("arguments[0].click();",element);
    }

    public static void scrollToElement(WebElement element){
        JavascriptExecutor jse=(JavascriptExecutor)Driver.getWebDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);",element);
    }

    public static boolean isBig(double x, double y){
        if (x>y) return true;
        else return false;
    }

    public static boolean isCorrectEmailFormat(String email){
        String emailDeseni = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        Pattern pattern = Pattern.compile(emailDeseni);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static void doubleClick(WebElement element){
        Actions actions=new Actions(Driver.getWebDriver());
        actions.doubleClick(element).build().perform();
    }

    public static void setAttribute(WebElement element, String attributeName, String attributeValue) {
        JavascriptExecutor jse=(JavascriptExecutor)Driver.getWebDriver();
        jse.executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", element, attributeName, attributeValue);
    }

    public static void selectCheckBox(WebElement element, boolean check) {
        if (check) {
            if (!element.isSelected()) {
                element.click();
            }
        } else {
            if (element.isSelected()) {
                element.click();
            }
        }
    }

    public static void clickWithTimeOut(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                waitFor(1);
            }
        }
    }

    public static void executeJSCommand(WebElement element, String command) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getWebDriver();
        jse.executeScript(command, element);
    }

    public static void executeJSCommand(String command) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getWebDriver();
        jse.executeScript(command);

    }

    public static void clickWithWait(By by, int attempts) {
        WebElement element=Driver.getWebDriver().findElement(by);
        int counter = 0;
        //click on element as many as you specified in attempts parameter
        while (counter < attempts) {
            try {
                //selenium must look for element again
                clickWithJavaScript(element);
                //if click is successful - then break
                break;
            } catch (WebDriverException e) {
                //if click failed
                //print exception
                //print attempt
                e.printStackTrace();
                ++counter;
                //wait for 1 second, and try to click again
                waitFor(1);
            }
        }
    }

    public static void waitForPresenceOfElement(By by, long time) {
        new WebDriverWait(Driver.getWebDriver(), Duration.ofSeconds(time)).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static void screenShoot(Scenario scenario){
        final byte[] screenshot = ((TakesScreenshot) Driver.getWebDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot,"image/png","screenshot");
    }

    public static boolean verifyFileDownloaded(String path){
        File file=new File(path);
        return file.exists();
    }

    public static void writeExel(Map<String,String> map) {
        String filePath = System.getProperty("user.dir") + "\\recordFile.xlsx";
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("sheet1");
        int rowIndex = 0;

        for (Map.Entry<String, String> entry : map.entrySet()) {
            Row row = sheet.createRow(rowIndex);
            Cell cellIndex = row.createCell(0);//index bilgisini saklayacak hücre
            Cell cellValue = row.createCell(1);//value bilgisini saklayacak
            cellIndex.setCellValue(entry.getKey());
            cellValue.setCellValue(entry.getValue());
            rowIndex++;
        }
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            workbook.write(fos);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Map<String,String> exelRead(){
        String filePath = System.getProperty("user.dir") + "\\recordFile.xlsx";
        Map<String,String> result=new HashMap<>();
        try(FileInputStream readFile=new FileInputStream(filePath)) {
                Workbook workbook=new XSSFWorkbook(readFile);
                Sheet sheet=workbook.getSheet("sheet1");
                int rowIndex=0;
                int rowCount=sheet.getPhysicalNumberOfRows();
                while (rowIndex<rowCount){
                    Row row= sheet.getRow(rowIndex);
                    Cell cellA=row.getCell(0);
                    Cell cellB=row.getCell(1);
                    result.put(cellA.getStringCellValue(),cellB.getStringCellValue());
                    rowIndex++;
                }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public static void exelTask(){
        String filePath = "C:\\Users\\murat\\OneDrive\\Belgeler\\SaatTaskExel.xlsx";
        int columnIndexA = 0;// A kolonu için
        int columnIndexB = 1;// B kolonu için

        //yazılacak exel dosyasının  bilgileri
        String filePathW = "C:\\Users\\murat\\OneDrive\\Belgeler\\SaatTaskExelW.xlsx";
        String sheetName = "SAAT";
        int rowCount = 0; // Verilerin yazılacağı satırın indeksi
        int columnIndex = 0; // Verilerin yazılacağı sütunun indeksi
        Workbook workbookW = new XSSFWorkbook();//verilerin dosyaya yazılmasını sağlayacak çalışmaKtabını hazırlar
        Sheet sheetW = workbookW.createSheet(sheetName);//Çalışma sayfasını hazırlar
        //---------------------------------------------

        try (FileInputStream fis = new FileInputStream(filePath)) {//Exel dosyasından okuma
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet("Sayfa1");
            if (sheet == null) {//Exel dosyasında ilgili çalışma sayfası yoksa
                System.out.println("Belirtilen sayfa bulunamadı.");
                System.exit(1);
            }
            for (Row row : sheet) {
                Cell cellA = row.getCell(columnIndexA);//kaynak exel dosyasının A sütunundaki veriyi okur
                Cell cellB = row.getCell(columnIndexB);//B sütunundaki veriyi okur
                if (cellA != null) {
                    int cellValueB = (int) cellB.getNumericCellValue();//hücredeki nümerik değeri int değerine dönüştürür
                    if (isPrimeNumber(cellValueB)) {//Okunan değerin asal olup olmadığını kontrol eder
                        //eğer değer asal ise
                        // Yeni Exel dosyasına veri yazma
                        Row rowWA = sheetW.createRow(rowCount);
                        Cell cell = rowWA.createCell(columnIndex);
                        Cell cellWB = rowWA.createCell(1);
                        cell.setCellValue(cellA.getRichStringCellValue());//kaynak dosyadaki harf
                        cellWB.setCellValue( cellValueB);//kaynak dosyadaki asal sayı
                        rowCount++; //sonraki satıra geçer
                    }
                }
            }
            try (FileOutputStream fos = new FileOutputStream(filePathW)) {
                workbookW.write(fos);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    workbookW.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public static boolean isPrimeNumber(int num){
        boolean result=true;
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= num/2; i++) {
            if (num%i==0) return false;
        }
        return result;
    }


}
