package ohtu;

import ohtu.data_access.InMemoryUserDao;
import ohtu.data_access.UserDao;
import ohtu.domain.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tester {

    public static void main(String[] args) {
        
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:4567");
        
        sleep(2);
        
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        element.submit();
       
        
        // epäonnistunut kirjautuminen: oikea käyttäjätunnus, väärä salasana
        
        /*
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        element.submit();
        */
        
        //uuden käyttäjätunnuksen luominen
        
        /*
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("linda");
        element = driver.findElement(By.name("password"));
        element.sendKeys("adnil");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("adnil");
        element = driver.findElement(By.name("signup"));
        
        sleep(2);
        element.submit();
        */
        
        // uuden käyttäjätunnuksen luomisen jälkeen tapahtuva ulkoskirjautuminen sovelluksesta
        /*
       WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("testi4");
        element = driver.findElement(By.name("password"));
        element.sendKeys("testi4");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("testi4");
        element = driver.findElement(By.name("signup"));
        
        sleep(2);
        element.submit();
        
        sleep(2);
        WebElement mainPage = driver.findElement(By.linkText("continue to application mainpage"));
        mainPage.click();
        sleep(2);
        
        WebElement logout = driver.findElement(By.linkText("logout"));
        logout.click();
        sleep(2);
        */
        sleep(3);
        
        driver.quit();
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
