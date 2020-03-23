package com.Final;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xslf.usermodel.XSLFSheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class calculator {

	public static void main(String[] args) throws IOException,InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "F:\\elective 3\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.calculator.net/");
		driver.findElement(By.xpath("//*[@id=\"hl2\"]/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"topmenu\"]/ul/li[2]/a")).click();
		
		String fpath="C:\\Users\\God\\Desktop\\CT20172169881_GAswin\\book2.xlsx";
		File fi=new File(fpath);
		FileInputStream fis=new FileInputStream(fi);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sh1=wb.getSheetAt(0);
		
		Thread.sleep(3000);
		driver.findElement(By.name("cage")).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"cage\"]")).sendKeys(sh1.getRow(0).getCell(0).getRawValue());
		Thread.sleep(3000);
		driver.findElement(By.id("cheightmeter")).clear();
		Thread.sleep(3000);
		driver.findElement(By.id("cheightmeter")).sendKeys(sh1.getRow(0).getCell(1).getRawValue());
		Thread.sleep(3000);
		driver.findElement(By.id("ckg")).clear();
		Thread.sleep(3000);
		driver.findElement(By.id("ckg")).sendKeys(sh1.getRow(0).getCell(2).getRawValue());
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[2]/table[4]/tbody/tr/td[1]/input[2]")).click();
		
		File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile,new File( "C:\\Users\\God\\Desktop\\CT20172169881_GAswin\\bmi.png"));
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/a[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"hl2\"]/li[2]/a")).click();
		Thread.sleep(3000);
		WebElement ele= driver.findElement(By.id("cineunit"));
		Select ol=new Select(ele);
		ol.selectByIndex(2);
		WebElement ew=driver.findElement(By.id("couteunit"));
		Select il=new Select(ew);
		il.selectByIndex(1);
		driver.findElement(By.xpath("//*[@id=\"content\"]/table[1]/tbody/tr/td/table/tbody/tr[2]/td/input[2]")).click();
		
		//Take Screenshot
		File scrFile1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile1, new File("C:\\Users\\God\\Desktop\\CT20172169881_GAswin\\calorie.png"));
		Thread.sleep(3000);
		
		System.out.println("Successful");
		
		
		
	}

}
