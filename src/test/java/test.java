import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class test
{
    public static void main(String[] args) throws InterruptedException
    {
        // WebDriver Initialization
        WebDriver  driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
        driver.manage().window().maximize();


        //Hitting URL
        driver.get("https://www.naukri.com/mnjuser/profile?id=&altresid");

        //Locating Elements
        driver.findElement(By.id("usernameField")).sendKeys("yuga.wadikar@gmail.com");
        driver.findElement(By.id("passwordField")).sendKeys("Yuga@7083");
        driver.findElement(By.xpath("//button[@type='submit'][1]")).click();

        //Clicking on Profile
        driver.findElement(By.xpath("//img[@alt='naukri user profile img']")).click();
        driver.findElement(By.linkText("View & Update Profile")).click();
        driver.findElement(By.xpath("//em[@class='icon edit ']")).click();

        //Editing Name section
        WebElement name= driver.findElement(By.id("name"));
        name.click();
        name.clear();
        name.sendKeys("YUGANDHARA WADIKAR");
        driver.findElement(By.xpath("//button[text()='Save']")).click();

        // Printing Today
        String update=driver.findElement(By.xpath("//span[text()='Today']")).getText();
        System.out.println(update);
        if(update.equals("Today"))
        {
            System.out.println("Profile Updated");
        }
        else
        {
            System.out.println("Profile update fail ");
        }

        //Quitting Webdriver
        driver.quit();


    }
}
