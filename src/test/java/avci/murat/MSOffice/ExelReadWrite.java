package avci.murat.MSOffice;

import io.netty.handler.codec.string.LineSeparator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExelReadWrite {
    public static void main(String[] args) {
        String filePath="C:\\Users\\murat\\Downloads\\American_Oxford_3000.xlsx";

////////////////////////////////////////////////////////////////
        String filePathW = "C:\\Users\\murat\\Downloads\\American_Oxford_3000_sorted.xlsx";
        String sheetName = "Sheet1";//çalışma sayfasının ismi
        int rowCount = 0; // Verilerin yazılacağı satırın indeksi

        Workbook workbookW = new XSSFWorkbook();//verilerin dosyaya yazılmasını sağlayacak çalışma Kitabını hazırlar
        Sheet sheetW = workbookW.createSheet(sheetName);//Çalışma sayfasını hazırlar

////////////////////////////////////////////////////////////////
        try(FileInputStream fis=new FileInputStream(filePath)) {//dosyamızı açtık
            Workbook workbook=new XSSFWorkbook(fis);//exel çalışma dosyasını açtım
            Sheet sheet= workbook.getSheet("Sheet1");//exel çalışma sayfasını açtım
            for (int j = 0; j <1500 ; j++) {
                Row row= sheet.getRow(j);
                if (row != null) {
                    for (int i = 0; i <4 ; i++) {
                        //buradaki her bir değer bir kolonu ifade eder
                        Cell cell= row.getCell(i);
                        if (cell!=null){
                            Row rowW=sheetW.createRow(rowCount);//ilk satırı oluşturduk
                            String cellValue=cell.getStringCellValue();
                            Cell celW=rowW.createCell(0);//daima ilk kolona yazacak
                            celW.setCellValue(cellValue);
                            rowCount++;
                        }
                    }
                }
            }
           /* List<String> array=new ArrayList<>();
            for (Row sortRow:sheetW ) {
                array.add(sortRow.getCell(0).getStringCellValue());
            }
            Collections.sort(array);
            for (int i = 0; i < array.size(); i++) {
                Row row=sheetW.getRow(i);
                Cell cell= row.getCell(0);
                cell.setCellValue(array.get(i));
            }*/


            try(FileOutputStream fos=new FileOutputStream(filePathW)) {
                workbookW.write(fos);
            }catch (IOException e){
                e.printStackTrace();
            }finally {
                workbookW.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
