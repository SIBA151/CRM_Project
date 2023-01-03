package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		
		String propFilePath=System.getProperty("user.dir")+"\\config\\config.properties";
		prop=new Properties();
		try{
		FileInputStream fi=new FileInputStream(propFilePath);
		
		prop.load(fi);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		String browserName=prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("Chrome")) {
			driver=new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("Firefox")) {
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(prop.getProperty("appUrl"));
	}

}
