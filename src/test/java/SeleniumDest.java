import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.util.concurrent.TimeUnit;

public class SeleniumDest
{
    WebDriver driver;

    @Before
    public void setup()
    {
        String browser = System.getProperty("browser");

        //choix navigateur
        if (browser==null || browser=="chrome")
            driver = new ChromeDriver();
        else if (browser.equals("firefox"))
            driver = new FirefoxDriver();
        else driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://google.com");
    }

    @After
    public void exit()
    {
        driver.quit();
    }

    @Test
    public void testEnter() throws InterruptedException
    {
        WebElement recherche = driver.findElement(By.id("lst-ib"));
        recherche.sendKeys("canelé" + Keys.ENTER);
        WebElement premierResultat = driver.findElement(By.cssSelector(".rc > .r > a"));
        Assert.assertEquals(premierResultat.getText(), "Recette de Canelés Bordelais rapides : la recette facile");
    }


    @Test
    public void testClick() throws InterruptedException
    {
        WebElement recherche = driver.findElement(By.id("lst-ib"));
        recherche.sendKeys("canelé");
        recherche = driver.findElement(By.className("lsb"));
        recherche.click();
        WebElement premierResultat = driver.findElement(By.cssSelector(".rc > .r > a"));
        Assert.assertEquals(premierResultat.getText(), "Recette de Canelés Bordelais rapides : la recette facile");
    }

    @Test
    public void testEnterBonobo() throws InterruptedException
    {
        WebElement recherche = driver.findElement(By.id("lst-ib"));
        recherche.sendKeys("reproduction des bonobos" + Keys.ENTER);
    }





}
