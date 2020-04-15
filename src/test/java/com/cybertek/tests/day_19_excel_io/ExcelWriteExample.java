package com.cybertek.tests.day_19_excel_io;

import com.cybertek.base.VytrackTestBase;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWriteExample extends VytrackTestBase {
    //path to the location of the excel file

    //    private String filePath = "/Users/EdilbekBrowne/IdeaProjects/fall2019seleniumproject/src/test/resources/Vytrack testusers.xlsx";
    private String filePath = "src/test/resources/Vytrack testusers.xlsx";

    //creates connection between jvm and the file
    private FileInputStream fileInputStream;

    //represent the excel file
    private Workbook workbook;

    //represents th sheet that contains the actual data
    private Sheet workSheet;

    @BeforeMethod
    public void setUp() throws IOException {
        // initialize the input stream by giving the file location
        fileInputStream = new FileInputStream(filePath);

        //create the workboo the input stream
        //WorkBook.create --> this used to create workbook from inputStream
        workbook = WorkbookFactory.create(fileInputStream);

        //get the sheet from excel based on 0 based count
//        workSheet = workbook.getSheetAt(5); --> same sheet that, we can find it by index
        workSheet = workbook.getSheet("QA3-short");

    }

    @AfterMethod
    public void tearDown() throws IOException {
        workbook.close();
        fileInputStream.close();
    }

    @Test
    public void readAndWrite() throws IOException {
        // iterate get all the rows
        for (int i = 1; i < workSheet.getPhysicalNumberOfRows(); i++) {
            Row currentRow = workSheet.getRow(i);
            String username = currentRow.getCell(0).toString();
            String password = currentRow.getCell(1).toString();
            String firstName = currentRow.getCell(2).toString();
            String lastName = currentRow.getCell(3).toString();
            String result = currentRow.getCell(4).toString();
            System.out.println("ROW " + i);
            System.out.println("username = " + username);
            System.out.println("password = " + password);
            System.out.println("firstName = " + firstName);
            System.out.println("lastName = " + lastName);
            System.out.println("result = " + result);
            //did some test, now want to write result back to excel
            currentRow.getCell(4).setCellValue("PASS");
            //get the updated value
            result = currentRow.getCell(4).toString();
            System.out.println("new result = " + result);
        }

        FileOutputStream fileOutputStream = new FileOutputStream("src/test/resources/Vytrack testusers2.xlsx");

        workbook.write(fileOutputStream);

        fileOutputStream.close();
    }


}
