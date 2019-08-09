package jesuschristpack;

import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.By;
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
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String HomeWindow = driver.getWindowHandle();
		Set<String> windows =  driver.getWindowHandles();
		System.out.println(HomeWindow);
		System.out.println("No. Windows : "+windows.size());
		System.out.println("Enter Window You want to switch : ");
		int y=s.nextInt();
		s.nextLine();
		System.out.println("Entered:"+y);
		String[] windowsnames=new String[windows.size()];
		
		int i=0;
		for(String x : windows){
			System.out.println(x);
			windowsnames[i]=x;
			i++;
		}
		driver.switchTo().window(windowsnames[y-1]);
		
		driver.close();
	}

}
