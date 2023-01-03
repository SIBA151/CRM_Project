package Utility;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import base.TestBase;

public class TestUtility extends TestBase{
	
	static String sheetPath= System.getProperty("user.dir")+"\\testData\\FreeCrmTestData.xlsx";
	
	static Workbook wb;
	
	public void swichToFrame() {
		driver.switchTo().frame("mainpanel");
	}
	
	public static Object[][] getTestData(String sheetName) {
		File file=new File(System.getProperty("user.dir")+"\\testData\\FreeCrmTestData.xlsx");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			wb = new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Sheet sheet=wb.getSheet(sheetName);
		
		
		Object [][] data= new Object [sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0; i<sheet.getLastRowNum(); i++) {
			for(int j=0; j<sheet.getRow(0).getLastCellNum(); j++) {
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
	}
	
	public static void takeScreenshotAtEndOfTest(WebDriver driver, String screenShotName) {
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(source, new File("./ScreenShot/"+System.currentTimeMillis()+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
