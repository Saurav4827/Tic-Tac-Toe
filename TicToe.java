package hellocucumberpack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TicToe {
	
	   

	public static void main(String args[]) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "/home/qainfotech/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://10.0.1.86/tap_classroom/TicTacToe/");
		driver.manage().window().maximize();
		
		List<WebElement> elements=driver.findElements(By.cssSelector("table tbody tr td"));
		List<WebElement> visited =new ArrayList<WebElement>();
		String s1="Human Won!!";
		String s2="Tap Won";
		
      for (int i=0;i<elements.size();i++)
      {
          WebElement random=elements.get(new Random().nextInt(elements.size()));
          if(!visited.contains(random))
          {
        	  visited.add(random);
        	 
          }
          else
        	  i--;
          System.out.println(random);
          random.click();
          
        String text =(String)driver.findElement(By.id("turn")).getText();
        System.out.println(text);
        if(text.equals(s1) || text.equals(s2))
        {
        	System.out.println(" ...................stop..................");
        	break;
        }
          
//          Thread.sleep(500);
//     	  WebDriverWait wb = new WebDriverWait(driver,2);
//	      wb.until(ExpectedConditions.visibilityOfElementLocated(
//		  By.cssSelector("table tbody tr td img")));
      }
	
	}
}
