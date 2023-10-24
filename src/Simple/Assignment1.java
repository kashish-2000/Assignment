package Simple;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Assignment1 {
    WebDriver driver;

  @Test(priority = 0)
  public void f() throws InterruptedException {
	  ChromeOptions option = new ChromeOptions();
      option.addArguments("--remote-allow-origins=*");
      driver = new ChromeDriver(option);
      driver.manage().window().maximize();
      driver.get("https://data.grampower.com/hes/");
      Thread.sleep(1000);
  }
  @Test(priority = 1)
  public void locate() throws InterruptedException {
		
		driver.findElement(By.name("username"));
		driver.findElement(By.xpath("//input[@placeholder='Username']"));
		driver.findElement(By.xpath("//input[@placeholder='Password']"));
		driver.findElement(By.xpath("//input[@value='LOG IN']"));

  }
  @Test(priority = 2)
  public void autoscript() throws InterruptedException {
      driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("automation user"); // 1st Automation
		Thread.sleep(1000);
      driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("jobprogram"); // 2nd Automation
		Thread.sleep(1000);
      driver.findElement(By.xpath("//input[@value='LOG IN']")).click(); // 3rd Automation
		Thread.sleep(1000);
      driver.findElement(By.xpath("//img[@alt='arrow']")).click(); // 4th Automation
		Thread.sleep(1000);
      driver.findElement(By.xpath("(//input[@id='search_tb'])[1]")).sendkeys(Keys.ENTER); // 5th Automation
		Thread.sleep(1000);
		
      List<WebElement> rowelements = driver.findElements(By.xpath("//table[@class='table-responsive table table-bordered table-hover']//thead']//tbody/tr"));
      System.out.println("No. of row elements are : " + rowelements.size());
      int rowsize = rowelements.size();
      List<WebElement> columnelements = driver.findElements(By.xpath("//table[@class='table-responsive table table-bordered table-hover']"));
      System.out.println("No. of column elements are : " + columnelements.size());
      int columnsize = columnelements.size();
      for (int i = 1; i <= rowsize; i++) {
          for (int j = 1; j <= columnsize; j++) {
              System.out.println(driver.findElement(By.xpath("//table[@class='table-responsive table table-bordered table-hover']")).getText());
          }
      }
      

  }
  @Test(priority = 3)
  public void destroy() throws InterruptedException {
      Thread.sleep(1000);
		driver.quit();
  }
  
}
