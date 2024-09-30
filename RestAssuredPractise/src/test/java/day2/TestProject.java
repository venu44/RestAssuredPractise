package day2;

public class TestProject {
	
	
	WebDriver driver=new ChromeDriver();
	
	Driver.get("https://www.hitachicm.com/global/en/global-network/");
	
	driver.findElement(by.xpath("//div//div[@class="image nav-icon-img"][1])).click();
			
			driver.findElement(By.Xpath("//div[@class="hcm-search-bar__wrap"]) ).sendkeys("dgdjd"); 
			
	driver.findElement(By.Xpath("//div[@class=\"icon-search-text\"]")).click();

}
