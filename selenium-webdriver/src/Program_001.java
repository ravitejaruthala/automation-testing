// For launching, maximizing a browser and taking a screenshot of the page.

package sampleTestScripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class Program_001 {

	public static void main(String[] args) throws IOException {
		//
		Properties prop = new Properties();		
		FileInputStream file = new FileInputStream("/home/boss/Documents/programs/eclipse workspace/selenium-WebDriver/keywords.properties");
		prop.load(file);
		
        // declaration and instantiation of objects/variables
    	//System.setProperty("webdriver.firefox.marionette","geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();

		System.setProperty("webdriver.chrome.driver",prop.getProperty("Driver"));
		WebDriver driver = new ChromeDriver();
		
		//Declaring an implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		 // Create object of SimpleDateFormat class and decide the format
		 DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_H:m:s");
		
		 //get current date time with Date()
		 Date raw_date = new Date();

		 // Now format the date
		 String date= dateFormat.format(raw_date);
		 
        // launch browser and direct it to the Base URL
        driver.get(prop.getProperty("URL1"));
        driver.manage().window().maximize();
        
        // Take screenshot and store as a file format
        File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
         // now copy the  screenshot to desired location using copyFile //method
        FileHandler.copy(src, new File(prop.getProperty("Screenshot")+"/snap_"+date+".png"));
        }
         
        catch (IOException e)
         {
          System.out.println(e.getMessage());
         
         }

        //close Browser
        driver.close();
       
    }
	
}
