
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
//import org.testng.asserts.SoftAssert;
public class MyFirstproject{
	public WebDriver driver;
	@Test(priority=0)
	public void project1() {
		System.setProperty("webdriver.chrome.driver","E:\\software\\chrome driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		//invoke the link and maximize window
		driver.get("https://testpages.herokuapp.com/styled/tag/dynamic-table.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


		//Displaying data present in table
		List<WebElement>xlist=driver.findElements(By.xpath("//table[@id='dynamictable']//tr/td"));
		for(int i=0;i<xlist.size();i++) {
			System.out.println(xlist.get(i).getText());
}
		
		//find the webElement TableData and click on it.
		WebElement TableData = driver.findElement(By.xpath("//*[contains(text(),'Table Data')]"));
		TableData.click();

		//first clear the data in the textbox and then send new json data.
		WebElement textbox = driver.findElement(By.xpath("//textarea[@id='jsondata']"));
		textbox.clear();
		textbox.sendKeys("[{\"name\" : \"Bob\", \"age\" : 20, \"gender\": \"male\"}, {\"name\": \"George\", \"age\" : 42, \"gender\": \"male\"}, {\"name\":\r\n"
				+ "\"Sara\", \"age\" : 42, \"gender\": \"female\"}, {\"name\": \"Conor\", \"age\" : 40, \"gender\": \"male\"}, {\"name\":\r\n"
				+ "\"Jennifer\", \"age\" : 42, \"gender\": \"female\"}]");
		System.out.println("Data is successfully added");

		// find Refresh button and click on it
				WebElement RefreshButton = driver.findElement(By.xpath("//button[@id='refreshtable']"));
				RefreshButton.click();


		List<WebElement>ylist=driver.findElements(By.xpath("//table[@id='dynamictable']//tr/td"));
		for(int i=0;i<ylist.size();i++) {
			System.out.println(ylist.get(i).getText());}
		if(!xlist.containsAll(ylist))  {
			System.out.println("Add some more data into a table");	
		}


		//closing Window

		driver.close();


	}

}


















