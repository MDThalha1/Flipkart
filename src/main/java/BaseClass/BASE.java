package BaseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.google.common.graph.ElementOrder.Type;

public class BASE {
	public static WebDriver driver;
	public static String value;
	public static WebDriver BrowserLaunch(String type) {
		if (type.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			
			
		} else  if (type.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.firefox.driver", ".\\Driver\\gecko.exe");
		}
		return driver;
	}
	public static void Click(WebElement element) {
		// TODO Auto-generated method stub
		element.click();
	}
	public static void Send(WebElement element,String name) {
		// TODO Auto-generated method stub
		element.sendKeys(name);
	}
	public static void url(String value) {
		// TODO Auto-generated method stub
driver.get(value);
	}
	public static void quit() {
		// TODO Auto-generated method stub
driver.quit();
	}
	public static void close() {
		// TODO Auto-generated method stub
driver.close();
	}
	public static void forward() {
		// TODO Auto-generated method stub
driver.navigate().forward();
	}
	public static void back() {
		// TODO Auto-generated method stub
driver.navigate().back();
	}
	public static void to(String value) {
		// TODO Auto-generated method stub
driver.navigate().to(value);
	}
	public static WebDriver refresh() {
		// TODO Auto-generated method stub
driver.navigate().refresh();
return driver;
	}
	public static WebDriver Alertaccept() {
		// TODO Auto-generated method stub
driver.switchTo().alert().accept();
return driver;
	}
	public static WebDriver Alertdismiss() {
		// TODO Auto-generated method stub
		driver.switchTo().alert().dismiss();
		return driver;
	}
	public static WebDriver Alertsend(String value) {
		// TODO Auto-generated method stub
		driver.switchTo().alert().sendKeys(value);
		return driver;
	}
	public static WebDriver alertext() {
		// TODO Auto-generated method stub
		driver.switchTo().alert().getText();
		return driver;
	}
	public static WebDriver iframe(int num,String value,WebElement element) {
		// TODO Auto-generated method stub
		driver.switchTo().frame(num);
		driver.switchTo().frame(value);
		driver.switchTo().frame(element);
		return driver;

	}
	
	public static WebDriver impwait(int sec) {
		// TODO Auto-generated method stub
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
		return driver;

	}
	public static void Currenturl() {
		// TODO Auto-generated method stub
		driver.getCurrentUrl();
	}
	public static void Sleep(int num) throws Throwable {
		// TODO Auto-generated method stub
		Thread.sleep(num);
	}
	public static void act(WebDriver driver,String name,WebElement target,WebElement source) {
		// TODO Auto-generated method stub
		Actions act=new Actions(driver);
		if (name.equalsIgnoreCase("Click")) {
			act.click().build().perform();
			
		} else if(name.equalsIgnoreCase("DoubleClick")){
			act.doubleClick(target).build().perform();
			

		}
		else if(name.equalsIgnoreCase("context click")) {
			act.contextClick(target).build().perform();
		}
		else if(name.equalsIgnoreCase("click and hold")) {
			act.clickAndHold(target).build().perform();
	}
		else if(name.equalsIgnoreCase("move to element")) {
			act.moveToElement(target).build().perform();
		}
		else if(name.equalsIgnoreCase("drag and drop")) {
			act.dragAndDrop(target, source);
		}
}
	public static void getwindow(String value) {
		// TODO Auto-generated method stub
		Set<String> handle = driver.getWindowHandles();
		List<WebElement> parent = driver.findElements(By.xpath(value));
		for (WebElement webElement : parent) {
			System.out.println(webElement);
		}
	}
	public static WebDriver read_data(String path,String name,int row,int cell) throws Throwable {
		// TODO Auto-generated method stub
		File f=new File(path);
		FileInputStream fis=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(fis);
		Sheet s = w.getSheet(name);
		Row r = s.getRow(row);
		Cell c = r.getCell(cell);
		CellType cellType = c.getCellType();
		if (cellType.equals(CellType.STRING)) {
			value = c.getStringCellValue();
			
			
		} else if(cellType.equals(CellType.NUMERIC)){
			Object numericvalue=c.getNumericCellValue();
			int data=(int)numericvalue;
			value = String.valueOf(data);
		}
		return driver;
	}
	
}
	


