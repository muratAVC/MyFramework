package avci.murat.MSOffice;

import avci.murat.utilities.BrowserTools;
import avci.murat.utilities.Driver;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.swing.text.Utilities;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class Translate {
    public static void main(String[] args) throws IOException {
        Driver.getWebDriver().navigate().to("https://translate.google.com/?sl=auto&tl=tr&op=translate");

        String filePath = "C:\\Users\\murat\\Downloads\\American_Oxford_3000_sorted.xlsx";
        int rowCount=0;
        Workbook workbook2 = new XSSFWorkbook();
        Sheet sheet2 = workbook2.createSheet("Sheet1");

        try(FileInputStream fis = new FileInputStream(filePath)){
            Workbook workbook=new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet("Sheet1");


            do {
                Row row=sheet.getRow(rowCount);//okunan satır
                Row row2 = sheet2.createRow(rowCount);//yazılan satır
                if (row==null) break;
                Cell cell = row.getCell(0);
                Cell cell2 = row2.createCell(0);//ingilizce kelime
                Cell cell3 = row2.createCell(1);//türkçe karşılığı
                String str=cell.getStringCellValue();
                String value= str.substring(0,str.indexOf(" "));

                Driver.getWebDriver().findElement(By.xpath("//*[@class='er8xn']")).sendKeys( value);
                BrowserTools.waitFor(2);
                List<WebElement> elementList=Driver.getWebDriver().findElements(By.xpath("//*[@class='ryNqvb']"));

                String translate=elementList.get(0).getText();
                //System.out.println( value +" = " + translate);
                cell2.setCellValue(value);
                cell3.setCellValue(translate);
                Driver.getWebDriver().findElement(By.xpath("//*[@class='er8xn']")).clear();
                //Driver.getWebDriver().navigate().refresh();
                rowCount++;
            }while (true);


        }catch (IOException e){
            e.printStackTrace();
        }


        try (FileOutputStream fos = new FileOutputStream(filePath)){
            workbook2.write(fos);
        }catch (IOException e) {
            e.printStackTrace();
        } finally {
            workbook2.close();
        }



    }
}
