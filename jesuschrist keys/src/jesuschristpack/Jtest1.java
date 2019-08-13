package jesuschristpack;

import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Jtest1 {
	public static void main(String args[]){
		Scanner s=new Scanner(System.in);
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://lordcalls.com");
		driver.manage().window().maximize();
		
		
		WebElement textbox;
		textbox=driver.findElement(By.className("email"));
		textbox.sendKeys("Jesus Christ is my saviour");
		
		WebElement button;
		button=driver.findElement(By.id("mc-embedded-subscribe"));
		button.click();
		
		
		String HomeWindow = driver.getWindowHandle();
		Set<String> windows =  driver.getWindowHandles();
		System.out.println(HomeWindow);
		
		
		driver.switchTo().window(HomeWindow);
		
		String[] windowsnames=new String[windows.size()];
		System.out.println(windows.size());
		WebElement title;
		int i=0;
		for(String x : windows){
			System.out.println(x);
			windowsnames[i]=x;
			i++;
		}
		driver.switchTo().window(windowsnames[0]);
		System.out.println("1 "+driver.getTitle()+" "+windowsnames[0]);
		driver.switchTo().window(windowsnames[1]);
		System.out.println("2 "+driver.getTitle()+" "+windowsnames[1]);
		
		System.out.println("Home");
		driver.switchTo().window(HomeWindow);
		
		WebElement dailyprayers=driver.findElement(By.linkText("[Read more]"));
		
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
		dailyprayers.sendKeys(selectLinkOpeninNewTab);
		
		windows =  driver.getWindowHandles();
		System.out.println(windows.size());
		
		//driver.close();
	}

}
