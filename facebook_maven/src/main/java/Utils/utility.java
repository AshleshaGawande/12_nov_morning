package Utils;

import java.io.File;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import selenium1.FileInputStream;

public class utility {
	//repeated code/common code
public static String getExceldata(String sheet,int row,int cell)
{
	String path="C:\\Users\\User\\Desktop\\book1.xlsx";
	FileInputStream file = new FileInputStream(path);
	Workbook book = WorkbookFactory.create(file);
	Sheet ss = book.getSheet(sheet);
	Row row1 = ss.getRow(row);
	Cell cellnum = row1.getCell(cell);
	String data = cellnum.getStringCellValue();
	return data;
	
	
}


