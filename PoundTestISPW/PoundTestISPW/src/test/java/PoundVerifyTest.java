import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class PoundVerifyTest {

    public static WebDriver driver;

    @BeforeMethod
    public static void setUp(){
        FirefoxOptions options = new FirefoxOptions();
        // accettazione dei cookies
        options.addPreference("network.cookie.cookieBehavior", 0);
        // imposto il path del mio driver firefox
        System.setProperty("webdriver.gecko.driver", "/Users/Leonardo/IdeaProjects/SeleniumISPW/src/test/resources/geckodriver.exe");
        driver = new FirefoxDriver(options);
    }

    @Test
    void PoundTest() throws InterruptedException {
        driver.get("https://www.squareyards.com/blog/kilograms-to-pounds-cnvart");
        // aspetto 3 secondi per il caricamento della pagina
        Thread.sleep(3000);
        // prendo il valore in pound di 1 kg
        WebElement box= driver.findElement(By.xpath("//*[@id=\"user_to\"]"));
        // metto il valore in una stringa
        String pound = box.getAttribute("value");
        // converto il valore in float
        Float poundValue = Float.parseFloat(pound);
        // ottengo il valore in pound di 3kg
        poundValue = poundValue * 3;
        // imposto una variabile booleana a true se il valore trovato è maggiore di 6 pound
        Boolean check;
        if (poundValue > 6f) {
            check = true;
        } else {
            check = false;
        }
        // verifico che check sia true
        Assert.assertTrue(check);
    }

    @AfterMethod
    public void cleanUp(){
        // chiudo il driver
        driver.close();
    }
}
