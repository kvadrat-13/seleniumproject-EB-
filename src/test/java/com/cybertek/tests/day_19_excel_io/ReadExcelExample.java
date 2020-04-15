package com.cybertek.tests.day_19_excel_io;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcelExample {

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

    @Test
    public void rowAndColumnCount() {
        System.out.println(workSheet.getSheetName());

        // returns the last row num based on 0 count
        int lastRowNum = workSheet.getLastRowNum();
        System.out.println("lastRowNum = " + lastRowNum);

        // gives us the number of rows
        int rowCount = workSheet.getPhysicalNumberOfRows();
        System.out.println("rowCount = " + rowCount);


        // their is no direct way to get the number of cols
        // workSheet.getRow(0) --> we wil get the first row and
        // getLastCEllNum(); --> get number cells in that row

        int colCount = workSheet.getRow(0).getLastCellNum();
        System.out.println("colCount = " + colCount);
    }

    @AfterMethod
    public void tearDown() throws IOException {
        workbook.close();
        fileInputStream.close();
    }

    @Test
    public void readSingleCells() {
        // to read data from cell:
        // workSheet.getRow(7) --> get the row using 0 based index
        //represent a row in worksheet
        Row row = workSheet.getRow(7);

        //row.getCell(2); --> the specific cell from that row, 0 based count
        // get the specific cel from that row
        Cell cell = row.getCell(2);

        // get data from the cell
        String value = cell.toString();

        System.out.println("value = " + value);
    }

    @Test
    public void printWholeRow() {
        //get the row
        Row row = workSheet.getRow(0);
        int colCount = row.getLastCellNum();
        System.out.println("colCount = " + colCount);

        for (int i = 0; i < colCount; i++) {
            Cell cell = row.getCell(i);
            System.out.println("cell " + i + " = " + cell.toString());
        }
    }

    @Test
    public void readWholeSheet() {
        // I use nested for loop to get all excel data.
        // outer loop gets the rows, inner loops get cells
        int rowCount = workSheet.getPhysicalNumberOfRows();
        int colCount = workSheet.getRow(0).getLastCellNum();
        System.out.println("rowCount = " + rowCount);
        System.out.println("colCount = " + colCount);

        // iterate through the table
        for (int i = 0; i < rowCount; i++) {
            Row currentRow = workSheet.getRow(i);
            for (int j = 0; j < colCount; j++) {
                Cell cell = currentRow.getCell(j);
                //get cell value
                String value = cell.toString();
                System.out.println("row " + i + ", col: " + j + ": " + value + "\t");
            }
            System.out.println();
        }
    }

}
